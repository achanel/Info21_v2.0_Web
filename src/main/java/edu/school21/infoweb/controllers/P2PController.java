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
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String p2pRead() {
        return "/p2p/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/p2p/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/p2p/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/p2p/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        csvExecutor.writeP2PCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        csvExecutor.readCSV("P2P");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
