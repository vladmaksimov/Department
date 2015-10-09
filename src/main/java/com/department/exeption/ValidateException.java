package com.department.exeption;


import java.util.Map;

public class ValidateException extends Exception {
    private Map<String, String> errors;

    public ValidateException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}