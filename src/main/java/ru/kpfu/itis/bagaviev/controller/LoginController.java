package ru.kpfu.itis.bagaviev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.bagaviev.dto.UserLoginDto;

@Controller
public class LoginController {

    @GetMapping(value = "login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "login/process")
    public String submitLogin(UserLoginDto userLoginDto) {
        return "redirect:/profile";
    }

}
