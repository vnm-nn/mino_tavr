package com.mino_tavr.exception;

import lombok.Data;

@Data
public class IncorrectDataException {
    private String info;
    public IncorrectDataException() {}
}
