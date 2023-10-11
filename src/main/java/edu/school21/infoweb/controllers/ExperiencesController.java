package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/experiences")
public class ExperiencesController {
    @GetMapping("/read")
    public String experiencesRead() {
        return "/experiences/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/experiences/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/experiences/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/experiences/delete";
    }
}
