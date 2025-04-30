package com.smartshipping.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex, HttpServletRequest request) {
        ApiError error = new ApiError();
        error.setTimestamp(OffsetDateTime.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError("Internal Server Error");
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex,
                                                     HttpServletRequest request) {
        ApiError error = new ApiError();
        error.setTimestamp(OffsetDateTime.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Validation Failed");
        error.setMessage("Um ou mais campos são inválidos");
        error.setPath(request.getRequestURI());
        error.setErrors(
                ex.getBindingResult().getFieldErrors().stream()
                        .map(fe -> {
                            FieldValidationError fve = new FieldValidationError();
                            fve.setField(fe.getField());
                            fve.setRejectedValue(String.valueOf(fe.getRejectedValue()));
                            fve.setReason(fe.getDefaultMessage());
                            return fve;
                        }).collect(Collectors.toList())
        );
        return ResponseEntity.badRequest().body(error);
    }
}
