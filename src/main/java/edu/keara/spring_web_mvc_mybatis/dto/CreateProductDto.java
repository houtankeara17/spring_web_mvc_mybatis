package edu.keara.spring_web_mvc_mybatis.dto;

import java.math.BigDecimal;

public record CreateProductDto(
        String name,
        String description,
        BigDecimal price,
        Boolean inStock,
        Integer supplierId
) {

}
