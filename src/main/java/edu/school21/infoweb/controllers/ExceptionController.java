package edu.school21.infoweb.controllers;

import edu.school21.infoweb.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Deprecated
public class ExceptionController {

//    @GetMapping(value = "/error", produces = APPLICATION_JSON_VALUE)
//    public Response testDefaultControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
//            throws BusinessException {
//        if (exception) {
//            throw new BusinessException("BusinessException in testDefaultControllerAdvice");
//        }
//        return new Response("OK");
//    }

    @GetMapping("/error")
    public String testDefaultControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws BusinessException {
        if (exception) {
            throw new BusinessException("BusinessException in testDefaultControllerAdvice");
        }
        return "redirect:/error";
    }
}