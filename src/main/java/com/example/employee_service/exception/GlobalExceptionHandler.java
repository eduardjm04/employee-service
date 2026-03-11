package com.example.employee_service.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.employee_service.constant.ErrorMessages;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        return new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ErrorMessages.RESOURCE_NOT_FOUND,
                ex.getMessage(),
                request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getField() + " " + e.getDefaultMessage())
                .findFirst()
                .orElse(ErrorMessages.VALIDATION_ERROR);

        return new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ErrorMessages.VALIDATION_ERROR,
                message,
                request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        return new ApiError(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ErrorMessages.INTERNAL_ERROR,
                ex.getMessage(),
                request.getRequestURI());
    }
}
