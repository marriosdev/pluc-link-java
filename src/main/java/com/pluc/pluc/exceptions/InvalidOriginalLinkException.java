package com.pluc.pluc.exceptions;

public class InvalidOriginalLinkException extends RuntimeException{
    private static final long  serialVersionUID = 1L;

    public InvalidOriginalLinkException(String msg) {
        super(msg);
    }
}