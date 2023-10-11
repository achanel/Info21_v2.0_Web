package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/timeTracking")
public class TimeTrackingController {
    @GetMapping("/read")
    public String tasksRead() {
        return "/timeTracking/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/timeTracking/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/timeTracking/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/timeTracking/delete";
    }
}
