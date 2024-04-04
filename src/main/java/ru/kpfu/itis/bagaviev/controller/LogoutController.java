package ru.kpfu.itis.bagaviev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping(value = "logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user_id");
        return "index";
    }
}
