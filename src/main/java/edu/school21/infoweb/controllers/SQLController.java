package edu.school21.infoweb.controllers;

import edu.school21.infoweb.csv.CSVExecutor;
import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import edu.school21.infoweb.sqlServices.SqlFunctions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/v1/sql/")
public class SQLController {
    @Autowired
    SqlFunctions sqlFunctions;
    @Autowired
    SqlExecutor sqlExecutor;
    @Autowired
    CSVExecutor csvExecutor;
    private StringBuilder sqlResponse;

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("sqlResponse", sqlResponse);

        return "main";
    }

    @PostMapping
    public String sqlController(@RequestParam(required = false, name = "request") String request,
                                Map<String, Object> model) throws BusinessException {
        model.put("sqlResponse", sqlExecutor.execute(request));

        return "main";
    }

    @PostMapping("/export")
    public String csvExport(Map<String, Object> model) throws IOException {
        log.info("csvExport");
        try {
            csvExecutor.writeCSV(sqlExecutor.getCsv(), "export");
        }
        catch(Exception e)
        {
            log.error("Error While writing CSV ", e);
        }
        sqlResponse.setLength(0);
        model.put("sqlResponse", sqlResponse);
        return "redirect:/v1/sql/";
    }

    @PostMapping("/import")
    public String csvImport(Map<String, Object> model) throws IOException {
        log.info("import");
        try {
            String csvResponse = csvExecutor.readCSV("export.csv");

            model.put("csvResponse", csvResponse);
        }
        catch(Exception e)
        {
            log.error("Error While reading CSV ", e);
        }
        return "main";
    }
}
