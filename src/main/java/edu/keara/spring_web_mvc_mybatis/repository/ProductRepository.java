package edu.keara.spring_web_mvc_mybatis.repository;

import edu.keara.spring_web_mvc_mybatis.model.Product;
import edu.keara.spring_web_mvc_mybatis.repository.Provider.ProductProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface
ProductRepository {
    // -----------------------
    // Find product by ID
    // -----------------------
    @Select("SELECT * FROM products WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "slug", column = "slug"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price"),
            @Result(property = "inStock", column ="in_stock"),
            @Result(property = "supplier", column = "supplier_id",
                    one = @One(select = "edu.keara.spring_web_mvc_mybatis.repository.SupplierRepository.findById")),
            @Result(property = "categories", column = "id",
                    many = @Many(select = "edu.keara.spring_web_mvc_mybatis.repository.CategoryRepository.selectProductCategories"))
    })
    Product findById(Integer id);

    // -----------------------
    // Find product by slug
    // -----------------------
    @Select("SELECT * FROM products WHERE slug = #{slug}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "slug", column = "slug"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price"),
            @Result(property = "inStock", column ="in_stock"),
            @Result(property = "supplier", column = "supplier_id",
                    one = @One(select = "edu.keara.spring_web_mvc_mybatis.repository.SupplierRepository.findById")),
            @Result(property = "categories", column = "id",
                    many = @Many(select = "edu.keara.spring_web_mvc_mybatis.repository.CategoryRepository.selectProductCategories"))
    })
    Product findBySlug(String slug);

    // Find all products (with supplier and categories
    @Select("SELECT * FROM products ORDER BY id DESC")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "slug", column = "slug"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price"),
            @Result(property = "inStock", column = "in_stock"),
            @Result(property = "supplier", column = "supplier_id",
            one = @One(select = "edu.keara.spring_web_mvc_mybatis.repository.SupplierRepository.findById")),
            @Result(property = "categories", column = "id",
            many = @Many(select = "edu.keara.spring_web_mvc_mybatis.repository.CategoryRepository.selectProductCategories"))
    })
    List<Product> findAll();

    // -----------------------
    // Global search by name and status
    // -----------------------
    @Select("""
    SELECT * FROM products
    WHERE LOWER(name) LIKE CONCAT('%', LOWER(#{name}), '%')
    AND in_stock = #{status}
    """)
    List<Product> searchByNameAndStatus(@Param("name") String name, @Param("status") Boolean status);

    // -----------------------
    // Insert a new product
    // -----------------------
    @InsertProvider(ProductProvider.class)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertProduct(@Param("pro") Product product);

    // -----------------------
    // Product-Category Many-too-Many handlers
    // -----------------------
    @InsertProvider(ProductProvider.class)
    void insertProductCategories(@Param("proId") Integer proId, @Param("catId") Integer catId);

    // -----------------------
    // Update product
    // -----------------------
    @UpdateProvider(value = ProductProvider.class, method = "updateProduct")
    void update(@Param("pro") Product product);

    // -----------------------
    // Product-Category Many-too-Many handlers
    // -----------------------
    @UpdateProvider(ProductProvider.class)
    void updateProductCategories(@Param("proId") Integer proId, @Param("catId") Integer catId);

    // -----------------------
    // Check existing product
    // -----------------------
    @Select("SELECT EXISTS(SELECT 1 FROM products WHERE id = #{id})")
    boolean existsById(@Param("id") Integer id);

    // -----------------------
    // Delete a product by ID
    // -----------------------
    @Delete("DELETE FROM products WHERE id = #{id}")
    void deleteById(Integer id);
}
