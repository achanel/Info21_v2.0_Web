package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transferredPoints")
public class TransferredPointsController {
    @GetMapping("/read")
    public String tasksRead() {
        return "/transferredPoints/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/transferredPoints/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/transferredPoints/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/transferredPoints/delete";
    }
}
