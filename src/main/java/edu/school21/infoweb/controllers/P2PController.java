package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/p2p")
public class P2PController {
    @GetMapping("/read")
    public String p2pRead() {
        return "/p2p/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/p2p/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/p2p/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/p2p/delete";
    }
}
