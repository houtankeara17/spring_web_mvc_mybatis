package edu.keara.spring_web_mvc_mybatis.repository.Provider;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider implements ProviderMethodResolver {
    private final String TB_NAME = "categories";
    public String selectProductCategories(){
        return new SQL(){{
            SELECT("*");
            FROM(TB_NAME + "c");
            INNER_JOIN("product_categories pc ON pc.category_id = c.id");
            WHERE("pc.product_id = #{productId}");
        }}.toString();
    }

    public String selectCategories(){
        return new SQL(){{
            SELECT("*");
            FROM(TB_NAME);
        }}.toString();
    }
}
