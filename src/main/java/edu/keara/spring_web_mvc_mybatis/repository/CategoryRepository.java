package edu.keara.spring_web_mvc_mybatis.repository;

import edu.keara.spring_web_mvc_mybatis.model.Category;
import edu.keara.spring_web_mvc_mybatis.repository.Provider.CategoryProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepository {

    // -----------------------
    // ✍️ Using with the Inline SQL type
    // -----------------------

    // -----------------------
    // Get all categories in the Category Repository
    // -----------------------
    @Select("SELECT * FROM categories")
    List<Category> findAll();

    // -----------------------
    // Get all categories in the Category Repository
    // Using with dynamic SQL type (Dynamic Provider
    // -----------------------
    @SelectProvider(CategoryProvider.class)
    List<Category> selectProductCategories(@Param("productId") Integer productId);

    // -----------------------
    // Search category name in the Category Repository
    // -----------------------
    @Select("SELECT * FROM categories WHERE name = #{name}")
    Category searchByName(String name);

    // -----------------------
    // Insert category name in the Category Repository
    // -----------------------
    @Insert("""
    INSERT INTO categories(name,description)
    VALUES (
           #{c.name}, #{c.description})
    """)
    void insert(@Param("c") Category category);

    // -----------------------
    // Find by id in the Category Repository
    // -----------------------
    @Select("SELECT * FROM categories WHERE id = #{id}")
    Category findById(@Param("id") Integer id);

    // -----------------------
    // Update category by id in the Category Repository
    // -----------------------
    @Update("""
    UPDATE categories
    SET name = #{c.name},
        description = #{c.description}
    WHERE id = #{c.id}
    """)
    void update(@Param("c") Category category);

    // -----------------------
    // Delete category by id in the Category Repository
    // -----------------------
    @Delete("DELETE FROM categories WHERE id = #{id}")
    void deleteById(@Param("id") Integer id);
}
