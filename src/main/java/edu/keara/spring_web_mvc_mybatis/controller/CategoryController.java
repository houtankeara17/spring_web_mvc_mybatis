package edu.keara.spring_web_mvc_mybatis.controller;

import edu.keara.spring_web_mvc_mybatis.model.Category;
import edu.keara.spring_web_mvc_mybatis.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> results = categoryService.findAllCategories();
        return new ResponseEntity<>(results,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        Category result = categoryService.findCategoryById(id);
        return ResponseEntity.status(200).body(result);
    }

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
        return ResponseEntity.noContent().build(); // HTTP 204  No Content
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
