package com.mino_tavr.exception;

public class NoTechniqueInDBException extends RuntimeException {
    public NoTechniqueInDBException(String message) {
        super(message);
    }
}
