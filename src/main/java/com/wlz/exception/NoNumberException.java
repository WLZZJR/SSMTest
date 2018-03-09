package com.wlz.exception;


/**
 * 无库异常
 */
public class NoNumberException extends RuntimeException {

    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
