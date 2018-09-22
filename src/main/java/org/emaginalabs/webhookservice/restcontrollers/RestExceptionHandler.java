package org.emaginalabs.webhookservice.restcontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(HttpServletRequest request, Exception ex) {
        log.info("Exception {} on Request {}", ex.getMessage(), request.getRequestURL());
        return ex.getMessage();
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentExceptionn(HttpServletRequest request, Exception ex) {
        log.info("Exception {} on Request {}", ex.getMessage(), request.getRequestURL());
        return ex.getMessage();
    }

}
