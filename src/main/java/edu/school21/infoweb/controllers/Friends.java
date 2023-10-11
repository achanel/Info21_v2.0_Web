package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class Friends {
    @GetMapping("/read")
    public String friendsRead() {
        return "/friends/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/friends/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/friends/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/friends/delete";
    }
}
