package edu.keara.spring_web_mvc_mybatis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class Supplier {
    private Integer id;
    private String company;
    private LocalDate since;
    private boolean status;
}
