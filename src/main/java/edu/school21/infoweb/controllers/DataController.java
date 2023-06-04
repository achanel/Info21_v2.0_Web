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

    @GetMapping("/get_peer")
    public ResponseEntity<TablesDTO> getPeers() {
        return new ResponseEntity<>(tablesService.getPeers(), HttpStatus.OK);
    }

    @PostMapping("/save_peer")
    public ResponseEntity<TablesDTO> saveNewPeer(@RequestBody TablesDTO tablesDTO) {
        return new ResponseEntity<>(tablesService.savePeers(tablesDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_peer")
    public ResponseEntity<TablesDTO> deletePeer(@RequestBody TablesDTO tablesDTO) {
        tablesService.deletePeers(tablesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/get_task")
    public ResponseEntity<TablesDTO> getTasks() {
        return new ResponseEntity<>(tablesService.getTasks(), HttpStatus.OK);
    }
    @PostMapping("/save_task")
    public ResponseEntity<TablesDTO> saveNewTask(@RequestBody TablesDTO tablesDTO) {
        return new ResponseEntity<>(tablesService.saveTasks(tablesDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_task")
    public ResponseEntity<TablesDTO> deleteTask(@RequestBody TablesDTO tablesDTO) {
        tablesService.deleteTasks(tablesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get_check")
    public ResponseEntity<TablesDTO> getChecks() {
        return new ResponseEntity<>(tablesService.getChecks(), HttpStatus.OK);
    }

    @PostMapping("/save_check")
    public ResponseEntity<TablesDTO> saveNewCheck(@RequestBody TablesDTO tablesDTO) {
        return new ResponseEntity<>(tablesService.saveChecks(tablesDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_check")
    public ResponseEntity<TablesDTO> deleteCheck(@RequestBody TablesDTO tablesDTO) {
        tablesService.deleteChecks(tablesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get_friend")
    public ResponseEntity<TablesDTO> getFriends() {
        return new ResponseEntity<>(tablesService.getFriends(), HttpStatus.OK);
    }

    @PostMapping("/save_friend")
    public ResponseEntity<TablesDTO> saveNewFriends(@RequestBody TablesDTO tablesDTO) {
        return new ResponseEntity<>(tablesService.saveFriends(tablesDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_friend")
    public ResponseEntity<TablesDTO> deleteFriend(@RequestBody TablesDTO tablesDTO) {
        tablesService.deleteFriends(tablesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
