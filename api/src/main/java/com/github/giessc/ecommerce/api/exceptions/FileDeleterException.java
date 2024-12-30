package com.github.giessc.ecommerce.api.exceptions;

import lombok.Getter;

@Getter
public class FileDeleterException extends Throwable {
    public FileDeleterException(String message) {
        super(message);
    }

    public FileDeleterException(String message, Exception innerException) {
        super(message, innerException);
    }
}
