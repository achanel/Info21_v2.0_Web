package edu.school21.infoweb.controllers;

import edu.school21.infoweb.utils.CSVExecutor;
import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.exception.BusinessException;
import edu.school21.infoweb.services.TablesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/verter")
public class VerterController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String verterRead() {
        log.info("Read verter table");
        return "/verter/read";
    }

    @GetMapping("/create")
    String createVerter() {
        log.info("Create verter table");
        return "/verter/create";
    }

    @GetMapping("/update")
    String showUpdateVerter() {
        log.info("Update verter table");
        return "/verter/update";
    }

    @GetMapping("/delete")
    String showDeleteVerter() {
        log.info("Delete verter table");
        return "/verter/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export verter table to csv");
        csvExecutor.writeVerterCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import verter table from csv");
        csvExecutor.readCSV("Verter");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
