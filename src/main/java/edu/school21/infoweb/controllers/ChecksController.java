package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/checks")
public class ChecksController {
    @GetMapping("/read")
    public String peersRead() {
        return "/checks/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/checks/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/checks/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/checks/delete";
    }
}
