package edu.school21.infoweb.exception;

import edu.school21.infoweb.dto.functions.LastCheck;
import lombok.extern.slf4j.Slf4j;


public class BusinessException extends Exception {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(BusinessException.class);
    public BusinessException(String message) {

        super(message);
        log.warn("BusinessException");
    }
}
