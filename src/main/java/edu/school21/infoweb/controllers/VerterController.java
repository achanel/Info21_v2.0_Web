package edu.school21.infoweb.controllers;

        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/verter")
public class VerterController {
    @GetMapping("/read")
    public String tasksRead() {
        return "/verter/read";
    }

    @GetMapping("/create")
    String createPeer() {
        return "/verter/create";
    }

    @GetMapping("/update")
    String showUpdatePeer() {
        return "/verter/update";
    }

    @GetMapping("/delete")
    String showDeletePeer() {
        return "/verter/delete";
    }
}
