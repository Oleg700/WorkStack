package org.workstack.exception.handler;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    public static final String USER_DISABLED = "User is disabled";
    public static final String BAD_CREDENTIALS = "username or password is invalid";
    public static final String TOKEN_ERROR =  "Unable to get JWT Token";
    public static final String TOKEN_EXPIRED =  "JWT Token has expired";
    public static final String TIMESTAMP =  "timestamp";
    public static final String STATUS =  "status";
    public static final String ERRORS =  "errors";

    @ExceptionHandler(value = DisabledException.class)
    protected ResponseEntity<Object> handleDisabledException(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, USER_DISABLED,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    protected ResponseEntity<Object> handleBadCredentialsException(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, BAD_CREDENTIALS,
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, TOKEN_ERROR,
                new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    protected ResponseEntity<Object> handleExpiredJwtException(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, TOKEN_EXPIRED,
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(TIMESTAMP, new Date());
        body.put(STATUS, status.value());
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        body.put(ERRORS, errors);
        return new ResponseEntity<>(body, headers, status);
    }
}
