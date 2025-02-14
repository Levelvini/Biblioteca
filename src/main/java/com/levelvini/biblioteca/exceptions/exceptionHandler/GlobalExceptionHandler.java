package com.levelvini.biblioteca.exceptions.exceptionHandler;

import com.levelvini.biblioteca.exceptions.EmptyDataException;
import com.levelvini.biblioteca.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> Exception(Exception ex){
        ErroResponse erro = new ErroResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro); 
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResponse> handlerResourseNotFoundException(ResourceNotFoundException ex){
        ErroResponse erro = new ErroResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(EmptyDataException.class)
    public ResponseEntity<ErroResponse> handlerEmptyDataException(EmptyDataException ex){
        ErroResponse erro = new ErroResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    //EmptyDataException é desnecessária, podendo ser substituída pelo ResourseNotFoundException! o Uso é para fins de aprendizado!
}
