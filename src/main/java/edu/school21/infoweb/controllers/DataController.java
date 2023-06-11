package edu.school21.infoweb.controllers;

import edu.school21.infoweb.dto.TablesDTO;
import edu.school21.infoweb.services.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/data/")
public class DataController {
    @Autowired
    private TablesService tablesService;

    @GetMapping("/get_table")
    public ResponseEntity<TablesDTO> getTable() {
        return new ResponseEntity<>(tablesService.getTable(), HttpStatus.OK);
    }

    @PostMapping("/save_table")
    public ResponseEntity<TablesDTO> saveNewTable(@RequestBody TablesDTO tablesDTO) {
        return new ResponseEntity<>(tablesService.saveTable(tablesDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_table")
    public ResponseEntity<TablesDTO> deleteTable(@RequestBody TablesDTO tablesDTO) {
        tablesService.deleteTable(tablesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
