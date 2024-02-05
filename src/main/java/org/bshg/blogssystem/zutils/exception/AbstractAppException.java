package org.bshg.blogssystem.zutils.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractAppException extends RuntimeException {
    protected String message;
    private HttpStatus status;
    private ExceptionType type;

    protected AbstractAppException(String message) {
        this.message = message;
        this.config();
    }

    protected void config(HttpStatus status, ExceptionType type) {
        this.status = status;
        this.type = type;
    }

    protected abstract void config();

    public ApiError getError() {
        return ApiError.builder()
                .type(type)
                .status(status)
                .message(message)
                .build();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ExceptionType getType() {
        return type;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
