package com.smartshipping.exception;

import lombok.Data;

@Data
public class FieldValidationError {
    private String field;
    private String rejectedValue;
    private String reason;
    // getters e setters
}
