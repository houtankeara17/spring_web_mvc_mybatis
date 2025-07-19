package edu.keara.spring_web_mvc_mybatis.repository;

import edu.keara.spring_web_mvc_mybatis.model.Category;
import edu.keara.spring_web_mvc_mybatis.repository.Provider.CategoryProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface CategoryRepository {
    @SelectProvider(CategoryProvider.class)
    List<Category> selectProductCategories(@Param("productId") Integer productId);
}
