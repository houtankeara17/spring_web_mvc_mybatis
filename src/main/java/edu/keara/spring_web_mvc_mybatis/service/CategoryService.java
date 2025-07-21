package edu.keara.spring_web_mvc_mybatis.service;

import edu.keara.spring_web_mvc_mybatis.model.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(Category category);
    void updateCategory(Integer id, Category category);
    void deleteCategory(Integer id);
    Category findCategoryById(Integer id);
    List<Category> findAllCategories();
    Category findCategoryByName(String name);
}