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
@RequestMapping("/transferredPoints")
public class TransferredPointsController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String transferredPointsRead() {
        log.info("Read transferredPoints table");
        return "/transferredPoints/read";
    }

    @GetMapping("/create")
    String createTransferredPoints() {
        log.info("Create transferredPoints table");
        return "/transferredPoints/create";
    }

    @GetMapping("/update")
    String showUpdateTransferredPoints() {
        log.info("Update transferredPoints table");
        return "/transferredPoints/update";
    }

    @GetMapping("/delete")
    String showDeleteTransferredPoints() {
        log.info("Delete transferredPoints table");
        return "/transferredPoints/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export transferredPoints table to csv");
        csvExecutor.writeTransferredPointsCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import transferredPoints table from csv");
        csvExecutor.readCSV("TransferredPoints");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
