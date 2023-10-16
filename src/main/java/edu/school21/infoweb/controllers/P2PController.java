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
@RequestMapping("/p2p")
public class P2PController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String p2pRead() {
        log.info("Read p2ps table");
        return "/p2p/read";
    }

    @GetMapping("/create")
    String createP2p() {
        log.info("Create p2ps table");
        return "/p2p/create";
    }

    @GetMapping("/update")
    String showUpdateP2p() {
        log.info("Update p2ps table");
        return "/p2p/update";
    }

    @GetMapping("/delete")
    String showDeleteP2p() {
        log.info("Delete p2ps table");
        return "/p2p/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export p2ps table to csv");
        csvExecutor.writeP2PCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import p2ps table from csv");
        csvExecutor.readCSV("P2P");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
