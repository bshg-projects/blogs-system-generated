package org.bshg.blogssystem.exception;

import org.bshg.blogssystem.zutils.exception.AbstractAppException;
import org.bshg.blogssystem.zutils.exception.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(AbstractAppException.class)
    public <T extends AbstractAppException> ResponseEntity<ApiError> handleCostumeExceptions(T e) {
        var error = e.getError();
        return ResponseEntity
                .status(error.getStatus())
                .body(error);
    }
}
