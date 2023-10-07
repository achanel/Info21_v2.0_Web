package edu.school21.infoweb.controllers;

import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.services.TablesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/v1/data/")
public class DataController {
    @Autowired
    private TablesService tablesService;
    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(DataController.class);
    @GetMapping("/get_table")
    public ResponseEntity<TablesDTO> getTable() {
        log.info("Get table");
        return new ResponseEntity<>(tablesService.getTable(), HttpStatus.OK);
    }

    @PostMapping("/save_table")
    public ResponseEntity<TablesDTO> saveNewTable(@RequestBody TablesDTO tablesDTO) {
        log.info("Save table");
        return new ResponseEntity<>(tablesService.saveTable(tablesDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_table")
    public ResponseEntity<TablesDTO> deleteTable(@RequestBody TablesDTO tablesDTO) {
        log.info("Delete table");
        tablesService.deleteTable(tablesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update_table")
    public ResponseEntity<TablesDTO> updateTable(@RequestBody TablesDTO tablesDTO) {
        log.info("Update table");
        return new ResponseEntity<>(tablesService.saveTable(tablesDTO), HttpStatus.OK);
    }
}
