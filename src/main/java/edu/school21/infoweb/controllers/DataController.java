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

    @GetMapping("/get")
    public ResponseEntity<TablesDTO> getTables() {
        return new ResponseEntity<>(tablesService.getTables(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TablesDTO> saveNewPeer(@RequestBody TablesDTO tablesDTO) {
        return new ResponseEntity<>(tablesService.saveTables(tablesDTO), HttpStatus.CREATED);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Peers> deletePeer(@RequestParam String id) {
//        peersService.deletePeer(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
