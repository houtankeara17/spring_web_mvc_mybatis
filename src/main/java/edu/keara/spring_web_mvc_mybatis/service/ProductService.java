package edu.keara.spring_web_mvc_mybatis.service;

import edu.keara.spring_web_mvc_mybatis.dto.CreateProductDto;
import edu.keara.spring_web_mvc_mybatis.dto.UpdateProductDto;
import edu.keara.spring_web_mvc_mybatis.model.Product;

import java.util.List;

public interface ProductService {
    void create(CreateProductDto createProductDto);
    void update(Integer id, UpdateProductDto updateProduct);
    void delete(Integer id);
    Product findById(Integer id);
    List<Product> findAll();
    List<Product> searchByNameAndStatus(String name, Boolean status);
    Product findBySlug(String slug);
}
