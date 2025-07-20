package edu.keara.spring_web_mvc_mybatis.controller;

import edu.keara.spring_web_mvc_mybatis.dto.CreateProductDto;
import edu.keara.spring_web_mvc_mybatis.dto.UpdateProductDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id){
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/by-slug")
    public ResponseEntity<Product> getBySlug(@RequestParam("slug") String slug) {
        Product product = productService.findBySlug(slug);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody CreateProductDto product){
        productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody UpdateProductDto product) {
        productService.update(id, product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Product>> searchByNameAndStatus(@RequestParam("name") String name, @RequestParam("status") Boolean status) {
        List<Product> results = productService.searchByNameAndStatus(name, status);
        return ResponseEntity.ok(results);
    }

}
