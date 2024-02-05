package org.bshg.blogssystem.exception;

import org.bshg.blogssystem.zutils.exception.AbstractAppException;
import org.bshg.blogssystem.zutils.exception.ExceptionType;
import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractAppException {
    @Override
    protected void config() {
        config(HttpStatus.NOT_FOUND, ExceptionType.NOT_FOUND_ERROR);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
