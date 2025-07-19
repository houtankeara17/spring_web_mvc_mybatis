package edu.keara.spring_web_mvc_mybatis.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private Integer id;
    private String slug;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean inStock;
    private Supplier supplier;
    private List<Category> categories;
}
