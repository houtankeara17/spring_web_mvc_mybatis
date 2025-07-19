package edu.keara.spring_web_mvc_mybatis.controller;

import edu.keara.spring_web_mvc_mybatis.model.Product;
import edu.keara.spring_web_mvc_mybatis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> result = productService.findAll();
        return ResponseEntity.ok(result);
    }
}
