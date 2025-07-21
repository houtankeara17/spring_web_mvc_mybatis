package edu.keara.spring_web_mvc_mybatis.dto;

import edu.keara.spring_web_mvc_mybatis.model.Category;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public record UpdateProductDto(
        String name,
        String description,
        BigDecimal price,
        Boolean inStock,
        Integer supplierId,
        List<Integer> categoryIds
) {
}
