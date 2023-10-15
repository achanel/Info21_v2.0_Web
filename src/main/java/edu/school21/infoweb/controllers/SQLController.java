package edu.school21.infoweb.controllers;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/v1/sql/")
public class SQLController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(SQLController.class);
    @Autowired
    SqlExecutor sqlExecutor;

    @GetMapping
    public String main() {
        return "main";
    }

    @PostMapping
    public ResponseEntity<String> sqlController(@RequestParam(required = false, name = "request") String request) throws BusinessException {
        log.info("POST sql_execute");
        return new ResponseEntity<>(sqlExecutor.execute(request).toString(), HttpStatus.OK);
    }
}
