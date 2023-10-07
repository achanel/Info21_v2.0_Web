package edu.school21.infoweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.text.MessageFormat;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler({BusinessException.class, RuntimeException.class, SQLException.class, Exception.class})
    public ResponseEntity<Response> handleException(BusinessException e) {
        String message = MessageFormat.format("{0} returned with message: {1}",
                HttpStatus.BAD_REQUEST, e.getMessage()
        );
        Response response = new Response(message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}