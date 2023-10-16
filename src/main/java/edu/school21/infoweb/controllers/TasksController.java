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
@RequestMapping("/tasks")
public class TasksController {
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @Autowired
    private CSVExecutor csvExecutor;
    @Autowired
    private TablesService tablesService;
    @GetMapping("/read")
    public String tasksRead() {
        log.info("Read tasks table");
        return "/tasks/read";
    }

    @GetMapping("/create")
    String createTasks() {
        log.info("Create tasks table");
        return "/tasks/create";
    }

    @GetMapping("/update")
    String showUpdateTasks() {
        log.info("Update tasks table");
        return "/tasks/update";
    }

    @GetMapping("/delete")
    String showDeleteTasks() {
        log.info("Delete tasks table");
        return "/tasks/delete";
    }

    @PostMapping("/export")
    public ResponseEntity<TablesDTO> csvExport() {
        log.info("Export tasks table to csv");
        csvExecutor.writeTasksCSV(tablesService.getTable());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/import")
    public ResponseEntity<TablesDTO> csvImport() throws BusinessException {
        log.info("Import tasks table from csv");
        csvExecutor.readCSV("Tasks");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
