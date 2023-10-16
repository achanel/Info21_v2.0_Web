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
@RequestMapping("/timeTracking")
public class TimeTrackingController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String timeTrackingRead() {
        log.info("Read timeTracking table");
        return "/timeTracking/read";
    }

    @GetMapping("/create")
    String createTimeTracking() {
        log.info("Create timeTracking table");
        return "/timeTracking/create";
    }

    @GetMapping("/update")
    String showUpdateTimeTracking() {
        log.info("Update timeTracking table");
        return "/timeTracking/update";
    }

    @GetMapping("/delete")
    String showDeleteTimeTracking() {
        log.info("Delete timeTracking table");
        return "/timeTracking/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export timeTracking table to csv");
        csvExecutor.writeTimeTrackingCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import timeTracking table from csv");
        csvExecutor.readCSV("TimeTracking");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
