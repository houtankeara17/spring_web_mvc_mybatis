package edu.keara.spring_web_mvc_mybatis.dto;

public record UpdateProductDto(
        String name,
        String description,
        Integer supplierId
) {

}
