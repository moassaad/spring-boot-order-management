package com.nti.project.controller;


import com.nti.project.dto.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException exception){
        List<ErrorResponseDTO> ERRORS = exception.getBindingResult().getFieldErrors().stream().map(
                error -> {
                    ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
                    errorResponseDTO.setFiled(error.getField());
                    errorResponseDTO.setMessage(error.getDefaultMessage());
                    return errorResponseDTO;
                }
        ).toList();
        return ResponseEntity.badRequest().body(ERRORS);
    }
}
