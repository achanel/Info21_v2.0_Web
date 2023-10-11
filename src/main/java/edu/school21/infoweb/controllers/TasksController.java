package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TasksController {
    @GetMapping("/read")
    public String tasksRead() {
        return "/tasks/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/tasks/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/tasks/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/tasks/delete";
    }
}
