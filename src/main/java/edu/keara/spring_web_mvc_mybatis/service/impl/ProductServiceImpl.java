package edu.keara.spring_web_mvc_mybatis.service.impl;

import edu.keara.spring_web_mvc_mybatis.dto.CreateProductDto;
import edu.keara.spring_web_mvc_mybatis.dto.UpdateProductDto;
import edu.keara.spring_web_mvc_mybatis.model.Product;
import edu.keara.spring_web_mvc_mybatis.model.Supplier;
import edu.keara.spring_web_mvc_mybatis.repository.ProductRepository;
import edu.keara.spring_web_mvc_mybatis.repository.SupplierRepository;
import edu.keara.spring_web_mvc_mybatis.service.ProductService;
import edu.keara.spring_web_mvc_mybatis.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    // -----------------------
    // Find All or Get all products
    // -----------------------
    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    // -----------------------
    // Find by id
    // -----------------------
    @Override
    public Product findById(Integer id) {
        Product product = productRepository.findById(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id);
        }
        return product;
    }

    // -----------------------
    // Find by slug
    // -----------------------
    @Override
    public Product findBySlug(String slug) {
        Product product = productRepository.findBySlug(slug);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with slug: " + slug);
        }
        return product;
    }

    // -----------------------
    // Search by name and status
    // -----------------------
    @Override
    public List<Product> searchByNameAndStatus(String name, Boolean status) {
        return productRepository.searchByNameAndStatus(name, status);
    }

    // -----------------------
    // Create new product
    // -----------------------
    @Override
    @Transactional
    public void create(CreateProductDto product) {

        Product newProduct = new Product();
        newProduct.setName(product.name());
        newProduct.setSlug(SlugUtil.toSlug(product.name()));
        newProduct.setDescription(product.description());
        newProduct.setPrice(product.price());
        newProduct.setInStock(product.inStock());

        Supplier supplier = supplierRepository.findById(product.supplierId());

        if (supplier != null) {
            newProduct.setSupplier(supplier);
        }

        productRepository.insertProduct(newProduct);

        if (product.categoryIds().size() > 0) {
            for (Integer categoryId : product.categoryIds()) {
                productRepository.insertProductCategories(newProduct.getId(), categoryId);
            }
        }
    }

    // -----------------------
    // Update product by id
    // -----------------------
    @Override
    @Transactional
    public void update(Integer id, UpdateProductDto updateProduct) {
        boolean exists = productRepository.existsById(id);

        if(!exists){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id);
        }

        if (exists) {
            Product newProduct = new Product();
            newProduct.setId(id);
            newProduct.setName(updateProduct.name());
            newProduct.setSlug(SlugUtil.toSlug(updateProduct.name()));
            newProduct.setDescription(updateProduct.description());
            newProduct.setPrice(updateProduct.price());
            newProduct.setInStock(updateProduct.inStock());

            Supplier supplier = supplierRepository.findById(updateProduct.supplierId());
            if (supplier == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found with id: " + updateProduct.supplierId());
            }

            newProduct.setSupplier(supplier);
            productRepository.update(newProduct);
        }
    }

    // -----------------------
    // Delete product by id
    // -----------------------
    @Override
    @Transactional
    public void delete(Integer id) {
        boolean exists = productRepository.existsById(id);
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
