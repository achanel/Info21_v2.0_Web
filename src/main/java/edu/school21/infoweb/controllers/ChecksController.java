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
@RequestMapping("/checks")
public class ChecksController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String checksRead() {
        log.info("Read checks table");
        return "/checks/read";
    }

    @GetMapping("/create")
    String createCheck() {
        log.info("Create checks table");
        return "/checks/create";
    }

    @GetMapping("/update")
    String showUpdateCheck() {
        log.info("Update checks table");
        return "/checks/update";
    }

    @GetMapping("/delete")
    String showDeleteCheck() {
        log.info("Delete checks table");
        return "/checks/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export checks table to csv");
        csvExecutor.writeChecksCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import checks table from csv");
        csvExecutor.readCSV("Checks");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
