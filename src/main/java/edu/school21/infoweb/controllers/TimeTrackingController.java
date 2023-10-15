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
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String tasksRead() {
        return "/timeTracking/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/timeTracking/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/timeTracking/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/timeTracking/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        csvExecutor.writeTimeTrackingCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        csvExecutor.readCSV("TimeTracking");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
