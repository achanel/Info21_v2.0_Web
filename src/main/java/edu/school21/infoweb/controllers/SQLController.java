package edu.school21.infoweb.controllers;

import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import edu.school21.infoweb.sqlServices.SqlFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/v1/sql/")
public class SQLController {
    @Autowired
    SqlFunctions sqlFunctions;
    @Autowired
    SqlExecutor sqlExecutor;
    private StringBuilder sqlResponse;

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("sqlResponse", sqlResponse);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam(required = false, name = "request") String request, Map<String, Object> model) throws BusinessException {
//        sqlResponse = sqlExecutor.execute(sqlFunctions.getStatement(request),
//                sqlFunctions.getParams());

//        String s = sqlExecutor.execute(sqlFunctions.getStatement(request), null);

        sqlResponse = sqlExecutor.execute(sqlFunctions.getStatement(request), sqlFunctions.getParams());

        model.put("sqlResponse", sqlResponse);

        return "main";
    }
}
