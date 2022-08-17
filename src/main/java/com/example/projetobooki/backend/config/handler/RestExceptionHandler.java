package com.example.projetobooki.backend.config.handler;

import com.example.projetobooki.backend.config.exceptions.exceptionsconfig.CustomExceptionDetails;
import com.example.projetobooki.backend.config.exceptions.exceptionsconfig.CustomRestException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomRestException.class)
    public ResponseEntity<CustomExceptionDetails> handleCustomException(CustomRestException exception){

        return new ResponseEntity<>(
            CustomExceptionDetails
                    .builder()
                        .title(exception.getTitle())
                    .status(exception.getClass().getAnnotation(ResponseStatus.class).value().value())
                    .details(exception.getMessage())
                    .developerMessage(exception.getDeveloperMessage())
                    .timeStamp(LocalDateTime.now())
                    .build(),
            exception.getClass().getAnnotation(ResponseStatus.class).value()
        );
    }
}
