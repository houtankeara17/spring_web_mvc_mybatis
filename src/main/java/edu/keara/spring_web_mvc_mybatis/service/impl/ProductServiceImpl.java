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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    @Override
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


    @Override
    public void update(UpdateProductDto updateProductDto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public List<Product> searchByNameAndStatus(String name, Boolean status) {
        return List.of();
    }
}
