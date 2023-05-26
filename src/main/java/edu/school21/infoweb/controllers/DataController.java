package edu.school21.infoweb.controllers;

import edu.school21.infoweb.models.Peers;
import edu.school21.infoweb.services.PeersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/data/")
public class DataController {
    @Autowired
    private PeersService peersService;

    @GetMapping("/get")
    public ResponseEntity<List<Peers>> getAllPeers() {
        return new ResponseEntity<>(peersService.getAllPeers(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Peers> saveNewPeer(@RequestBody Peers peers) {
        return new ResponseEntity<>(peersService.savePeer(peers), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Peers> deletePeer(@RequestParam String id) {
        peersService.deletePeer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
