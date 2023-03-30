package com.TechItEasy2.TechItEasy2.TechItEasy.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> exception(IndexOutOfBoundsException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

//    Stationary voor exceptions CLASSNAME vervangen door exception type
//    @ExceptionHandler(value = Classname .class)
//    public ResponseEntity<Object> exception(Classname exception){
//        return new ResponseEntity<>(exception.getMessage, HttpStatus.NOT_FOUND);
//    }

}
