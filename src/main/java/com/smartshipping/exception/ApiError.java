package com.smartshipping.exception;


import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
@Data
public class ApiError {
    private OffsetDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<FieldValidationError> errors;

}
