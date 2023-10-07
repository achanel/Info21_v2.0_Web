package edu.school21.infoweb.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessException extends Exception {
    public BusinessException(String message) {

        super(message);
        log.warn("BusinessException");
    }
}
