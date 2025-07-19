package edu.keara.spring_web_mvc_mybatis.service.impl;

import edu.keara.spring_web_mvc_mybatis.model.Category;
import edu.keara.spring_web_mvc_mybatis.repository.CategoryRepository;
import edu.keara.spring_web_mvc_mybatis.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public void createCategory(Category category) {
        categoryRepository.insert(category);
    }

    @Override
    public void updateCategory(Integer id, Category category) {
        Category existingCategory = categoryRepository.findById(id);
        if(existingCategory == null){
            throw new RuntimeException("Category with id " + id + " does not exist");
        }
        existingCategory.setId(id);
        categoryRepository.update(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category existingCategory = categoryRepository.findById(id);
        if (existingCategory == null){
            throw new RuntimeException("Category with id " + id + " does not exist");
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findCategoryById(Integer id) {
        Category existCategory = categoryRepository.findById(id);
        if(existCategory == null){
            throw new RuntimeException("Category with id " + id + " does not exist");
        }
        return existCategory;
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
