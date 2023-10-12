package edu.school21.infoweb.controllers;

import edu.school21.infoweb.csv.CSVExecutor;
import edu.school21.infoweb.dto.TablesDTO;
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
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String peersRead() {
        return "/checks/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/checks/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/checks/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/checks/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        csvExecutor.writeChecksCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
