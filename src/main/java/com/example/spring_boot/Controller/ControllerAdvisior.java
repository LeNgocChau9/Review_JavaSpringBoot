package com.example.spring_boot.Controller;


import com.example.spring_boot.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisior extends ResponseEntityExceptionHandler {
    @ExceptionHandler (ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add(errorDTO.getError());
        errorDTO.setDeatail(details);
        return new ResponseEntity<>(errorDTO,org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }
}