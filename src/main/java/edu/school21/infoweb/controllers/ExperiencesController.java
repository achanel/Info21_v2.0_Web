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
@RequestMapping("/experiences")
public class ExperiencesController {
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;

    @GetMapping("/read")
    public String experiencesRead() {
        return "/experiences/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/experiences/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/experiences/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/experiences/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        csvExecutor.writeXPCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
