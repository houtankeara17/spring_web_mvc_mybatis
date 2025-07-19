package edu.keara.spring_web_mvc_mybatis.repository.Provider;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class ProductProvider implements ProviderMethodResolver {
    private final String TB_NAME = "products";

    public String insertProduct(){
        return new SQL(){{
            INSERT_INTO(TB_NAME);
            VALUES("slug","#{pro.slug}");
            VALUES("name","#{pro.name}");
            VALUES("description","#{pro.description}");
            VALUES("price","#{pro.price}");
            VALUES("in_stock","#{pro.inStock}");
            VALUES("supplier_id","#{pro.supplier.id}");
        }}.toString();
    }

    public String updateProduct(){
        return new SQL(){{
            UPDATE(TB_NAME);
            SET("slug=#{pro.slug}");
            SET("name=#{pro.name}");
            SET("description=#{pro.description}");
            SET("price=#{pro.price}");
            SET("in_stock=#{pro.inStock}");
            SET("supplier_id=#{pro.supplierId}");
            WHERE("id=#{pro.id}");
        }}.toString();
    }

    public String insertProductCategories(){
        return new SQL(){{
            INSERT_INTO("product_categories");
            VALUES("product_id","#{proId}");
            VALUES("category_id","#{catId}");
        }}.toString();
    }

    public String deleteProductCategories(){
        return new SQL(){{
            DELETE_FROM("product_categories");
            WHERE("product_id = #{proId}");
        }}.toString();
    }

    public String findAllProducts(){
        return new SQL(){{
            SELECT("*");
            FROM(TB_NAME);
        }}.toString();
    }
}
