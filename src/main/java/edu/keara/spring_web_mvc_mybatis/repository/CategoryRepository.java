package edu.keara.spring_web_mvc_mybatis.repository;

import edu.keara.spring_web_mvc_mybatis.model.Category;
import edu.keara.spring_web_mvc_mybatis.repository.Provider.CategoryProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepository {
    @SelectProvider(CategoryProvider.class)
    List<Category> selectProductCategories(@Param("productId") Integer productId);

    @Insert("""
    INSERT INTO categories(name,description)
    VALUES (
           #{c.name}, #{c.description})
    """)
    void insert(@Param("c") Category category);

    @Select("SELECT * FROM categories WHERE id = #{id}")
    Category findById(@Param("id") Integer id);

    @Update("""
    UPDATE categories
    SET name = #{c.name},
        description = #{c.description}
    WHERE id = #{c.id}
    """)
    void update(@Param("c") Category category);

    @Delete("DELETE FROM categories WHERE id = #{id}")
    void deleteById(@Param("id") Integer id);

    @Select("SELECT * FROM categories")
    List<Category> findAll();
}
