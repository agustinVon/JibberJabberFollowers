package com.agustinvon.jibberjabberfollowers.controller;

import com.agustinvon.jibberjabberfollowers.exceptions.AlreadyFollowedException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionMapper extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = NoSuchElementException.class)
    protected ResponseEntity<Object> handleException(NoSuchElementException ex, WebRequest request) {
        final Map<String, Object> errorAttributes = new DefaultErrorAttributes().getErrorAttributes(request, ErrorAttributeOptions.defaults());
        errorAttributes.put("status", HttpStatus.NOT_FOUND.value());
        errorAttributes.put("message", ex.getMessage());
        errorAttributes.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        return handleExceptionInternal(ex, errorAttributes, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = AlreadyFollowedException.class)
    protected ResponseEntity<Object> handleException(AlreadyFollowedException ex, WebRequest request) {
        final Map<String, Object> errorAttributes = new DefaultErrorAttributes().getErrorAttributes(request, ErrorAttributeOptions.defaults());
        errorAttributes.put("status", HttpStatus.BAD_REQUEST.value());
        errorAttributes.put("message", ex.getMessage());
        errorAttributes.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        return handleExceptionInternal(ex, errorAttributes, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}