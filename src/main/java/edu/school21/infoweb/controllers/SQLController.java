package edu.school21.infoweb.controllers;

import edu.school21.infoweb.csv.CSVExecutor;
import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.models.*;
import edu.school21.infoweb.services.TablesService;
import edu.school21.infoweb.sqlServices.SqlExecutor;
import edu.school21.infoweb.sqlServices.SqlFunctions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/v1/sql/")
public class SQLController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(SQLController.class);
    @Autowired
    SqlFunctions sqlFunctions;
    @Autowired
    SqlExecutor sqlExecutor;
    @Autowired
    CSVExecutor csvExecutor;
    private StringBuilder sqlResponse;

    @Autowired
    private TablesService tablesService;

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
    public ResponseEntity<P2P> csvExport() {
        log.info("csvExport");
        csvExecutor.writeChecksCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<List<Checks>> csvImport() {
        log.info("import");
        return new ResponseEntity<>(csvExecutor.readChecksCSV(), HttpStatus.OK);
    }
}
