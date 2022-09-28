package com.example.Sprint1MGN.controller;

import com.example.Sprint1MGN.controller.dto.response.DepositResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class requestExceptionHandler {
    // 捕捉 MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DepositResponse> handler(MethodArgumentNotValidException e) {

        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String message = allErrors.stream().map(n -> String.valueOf(n.getDefaultMessage()))
                .collect(Collectors.joining(", "));
        DepositResponse error = new DepositResponse().builder().message(message).build();
        return new ResponseEntity<DepositResponse>(error, HttpStatus.OK);
    }
}
