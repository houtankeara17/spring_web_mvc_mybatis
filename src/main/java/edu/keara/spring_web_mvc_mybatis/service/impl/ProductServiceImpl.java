package edu.keara.spring_web_mvc_mybatis.service.impl;

import edu.keara.spring_web_mvc_mybatis.dto.CreateProductDto;
import edu.keara.spring_web_mvc_mybatis.dto.UpdateProductDto;
import edu.keara.spring_web_mvc_mybatis.model.Product;
import edu.keara.spring_web_mvc_mybatis.repository.ProductRepository;
import edu.keara.spring_web_mvc_mybatis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void create(CreateProductDto createProductDto) {
        llsjkjdhkjfhkdjfhkdjhkfh
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
