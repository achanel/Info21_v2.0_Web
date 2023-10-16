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
@RequestMapping("/peers")
public class PeerController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String peersRead() {
        log.info("Read peers table");
        return "/peers/read";
    }

    @GetMapping("/create")
    String createPeer() {
        log.info("Create peers table");
        return "/peers/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        log.info("Update peers table");
        return "/peers/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        log.info("Delete peers table");
        return "/peers/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export peers table to csv");
        csvExecutor.writePeersCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import peers table from csv");
        csvExecutor.readCSV("Peers");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
