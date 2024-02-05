package org.bshg.blogssystem.zutils.exception;

import org.bshg.blogssystem.zutils.builder.IBuilder;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ApiError {
    private String type;
    private String message;
    private HttpStatus status;
    private int statusCode;
    private final Timestamp timestamp;

    public ApiError() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends IBuilder<ApiError, Builder> {
        public Builder() {
            super(new ApiError());
            this.builder = this;
        }

        public Builder type(ExceptionType type) {
            return setter(ApiError::setType, type.value());
        }

        public Builder message(String message) {
            return setter(ApiError::setMessage, message);
        }

        public Builder status(HttpStatus status) {
            return setter(ApiError::setStatus, status);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
        this.statusCode = this.status.value();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
