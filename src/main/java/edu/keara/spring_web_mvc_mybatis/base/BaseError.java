package edu.keara.spring_web_mvc_mybatis.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BaseError<T>(
        boolean success,
       int code,
       String message,
       T errors,
       LocalDateTime timestamp
) {

}
