package edu.keara.spring_web_mvc_mybatis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category {
    private Integer id;
    private String name;
    private String description;
}
