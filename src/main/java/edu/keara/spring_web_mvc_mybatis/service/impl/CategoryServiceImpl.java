package edu.keara.spring_web_mvc_mybatis.service.impl;

import edu.keara.spring_web_mvc_mybatis.model.Category;
import edu.keara.spring_web_mvc_mybatis.repository.CategoryRepository;
import edu.keara.spring_web_mvc_mybatis.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    // -----------------------
    // Get all categories
    // -----------------------
    @Override
    public List<Category> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    // -----------------------
    // Search category by name
    // -----------------------
    @Override
    public Category findCategoryByName(String name) {
        Category existCategory = categoryRepository.searchByName(name);
        if(existCategory == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with name:" + name);
        }
        return existCategory;
    }

    // -----------------------
    // Find category by id
    // -----------------------
    @Override
    public Category findCategoryById(Integer id) {
        Category existCategory = categoryRepository.findById(id);
        if(existCategory == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id:" + id);
        }
        return existCategory;
    }

    // -----------------------
    // Create new category
    // -----------------------
    @Override
    @Transactional
    public void createCategory(Category category) {
        categoryRepository.insert(category);
    }

    // -----------------------
    // Update category by id
    // -----------------------
    @Override
    @Transactional
    public void updateCategory(Integer id, Category category) {
        Category existingCategory = categoryRepository.findById(id);
        if(existingCategory == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id:" + id);
        }
        existingCategory.setId(id);
        categoryRepository.update(category);
    }

    // -----------------------
    // Delete category by id
    // -----------------------
    @Override
    @Transactional
    public void deleteCategory(Integer id) {
        Category existingCategory = categoryRepository.findById(id);
        if (existingCategory == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id:" + id);
        }
        categoryRepository.deleteById(id);
    }
}
