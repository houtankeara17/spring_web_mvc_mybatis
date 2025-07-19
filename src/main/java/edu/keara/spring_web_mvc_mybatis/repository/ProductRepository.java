package edu.keara.spring_web_mvc_mybatis.repository;

import edu.keara.spring_web_mvc_mybatis.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface
ProductRepository {
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
}
