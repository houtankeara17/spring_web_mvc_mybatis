package edu.keara.spring_web_mvc_mybatis.controller;

import edu.keara.spring_web_mvc_mybatis.dto.CreateProductDto;
import edu.keara.spring_web_mvc_mybatis.model.Product;
import edu.keara.spring_web_mvc_mybatis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody CreateProductDto product){
        productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
