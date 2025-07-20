package edu.keara.spring_web_mvc_mybatis.exception;

import edu.keara.spring_web_mvc_mybatis.base.BaseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Business Exception Handler
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<BaseError> handleResponseStatusException(ResponseStatusException ex){
        BaseError baseError = BaseError.builder()
                .success(false)
        .code(ex.getStatusCode().value())
                .message(ex.getReason())
                .errors(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getStatusCode().value()).body(baseError);
    }
}
