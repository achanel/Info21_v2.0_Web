package edu.school21.infoweb.controllers;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.exception.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ExceptionController {

    @GetMapping(value = "/testDefaultControllerAdvice", produces = APPLICATION_JSON_VALUE)
    public Response testDefaultControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws BusinessException {
        if (exception) {
            throw new BusinessException("BusinessException in testDefaultControllerAdvice");
        }
        return new Response("OK");
    }

}