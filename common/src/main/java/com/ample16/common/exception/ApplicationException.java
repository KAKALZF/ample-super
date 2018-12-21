package com.ample16.common.exception;

public class    ApplicationException extends RuntimeException {
    public ApplicationException() {

    }

    public ApplicationException(String msg) {
        super(msg);
    }

    public ApplicationException(String msg, Throwable e) {
        super(msg, e);
    }
}

