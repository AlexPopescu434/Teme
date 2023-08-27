package org.example.studentrepo;

public class ValidationException extends Exception {

    private String errorCode;

    public ValidationException(String message) {
        super(message);
    }
}