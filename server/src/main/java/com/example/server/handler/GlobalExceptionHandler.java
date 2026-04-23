package com.example.server.handler;


import com.example.result.Result;
import exception.BaseException;

import constant.MessageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Global Exception Handler
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * catch business exception
     */
    @ExceptionHandler(BaseException.class)
    public Result exceptionHandler(BaseException ex) {
        log.error("BaseException:", ex);
        return Result.error(ex.getMessage());
    }

    /**
     * handle duplicate / integrity constraint exception
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        log.error("SQLIntegrityConstraintViolationException:", ex);
        return Result.error("Data already exists or violates database constraint");
    }

    /**
     * Spring database exception
     */
    @ExceptionHandler(org.springframework.dao.DuplicateKeyException.class)
    public Result exceptionHandler(org.springframework.dao.DuplicateKeyException ex) {
        log.error("DuplicateKeyException:", ex);
        return Result.error("Duplicate record");
    }

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public Result exceptionHandler(org.springframework.dao.DataIntegrityViolationException ex) {
        log.error("DataIntegrityViolationException:", ex);
        return Result.error("Data integrity violation");
    }

    /**
     * for all others
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception ex) {
        log.error("Unhandled exception:", ex);
        return Result.error(MessageConstant.UNKNOWN_ERROR);
    }
}
