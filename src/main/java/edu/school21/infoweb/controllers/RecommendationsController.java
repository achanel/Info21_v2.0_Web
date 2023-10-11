package edu.school21.infoweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recommendations")
public class RecommendationsController {
    @GetMapping("/read")
    public String recommendationsRead() {
        return "/recommendations/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/recommendations/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/recommendations/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/recommendations/delete";
    }
}
