package edu.school21.infoweb.controllers;

import edu.school21.infoweb.models.Peers;
import edu.school21.infoweb.services.PeersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/v1/data/")
public class DataController {
    @Autowired
    private PeersService peersService;

    @GetMapping("/test")
    public List<Peers> getAllPeers() {
        return peersService.getAllPeers();
    }

    @GetMapping("/init")
    public void setPeers() {
        Peers peersTest = new Peers("kek", LocalDateTime.now());
        System.out.println("peer: " + peersTest);
        peersService.savePeer(peersTest);
    }
}
