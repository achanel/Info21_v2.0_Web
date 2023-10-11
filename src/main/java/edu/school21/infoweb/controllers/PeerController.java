package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/peers")
public class PeerController {
    @GetMapping("/read")
    public String peersRead() {
        return "/peers/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/peers/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/peers/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/peers/delete";
    }
}
