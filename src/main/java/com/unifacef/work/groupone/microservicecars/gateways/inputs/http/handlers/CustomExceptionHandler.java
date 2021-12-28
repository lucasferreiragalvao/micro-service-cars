package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.handlers;

import com.unifacef.work.groupone.microservicecars.exceptions.BadRequestException;
import com.unifacef.work.groupone.microservicecars.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    @ExceptionHandler(NotFoundException.class)
    public HttpEntity<ErrorResponse> handleNotFoundException(final NotFoundException ex){
        log.error(ex.getMessage(),ex);
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE,APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createMessage(ex),responseHeaders, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public HttpEntity<ErrorResponse> handleBadRequestException(final BadRequestException ex){
        log.error(ex.getMessage(),ex);
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE,APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createMessage(ex),responseHeaders,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class})
    public HttpEntity<ErrorResponse> handleIllegalArgumentException(final RuntimeException ex) {
        log.error(ex.getMessage(), ex);
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createMessage(ex), responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<ErrorResponse> handlerValidationException(
            final MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        final BindingResult bindingResult = ex.getBindingResult();
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        final ErrorResponse message = processFieldErrors(fieldErrors);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse createMessage(final Throwable ex){
        ErrorResponse message = null;
        if (isNotBlank(ex.getMessage())) {
            message = new ErrorResponse(Collections.singletonList(ex.getMessage()));
        }
        return message;
    }

    private ErrorResponse processFieldErrors(final List<FieldError> fieldErrors) {
        final List<String> errors =
                fieldErrors.stream()
                        .map(error -> String.format("%s: %s", error.getField(), error.getDefaultMessage()))
                        .collect(toList());
        return new ErrorResponse(errors);
    }
}
