package edu.school21.infoweb.exception;

public class BusinessException extends Exception {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(BusinessException.class);

    public BusinessException(String message) {

        super(message);
        log.warn("BusinessException");
    }
}
