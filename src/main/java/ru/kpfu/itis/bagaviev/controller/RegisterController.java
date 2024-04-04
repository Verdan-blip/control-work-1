package ru.kpfu.itis.bagaviev.controller;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.bagaviev.dto.UserRegisterDto;
import ru.kpfu.itis.bagaviev.service.UserService;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "register")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "register/process", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String processRegistration(UserRegisterDto userRegisterDto) {

        boolean emailExists = userService.existsByEmail(userRegisterDto.getEmail());
        boolean phoneExists = userService.existsByPhone(userRegisterDto.getPhone());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phoneExists", phoneExists);
        jsonObject.put("emailExists", emailExists);

        if (!phoneExists && !emailExists) {
            userService.save(userRegisterDto);
            jsonObject.put("status", "success");
        } else {
            jsonObject.put("status", "failure");
        }

        return jsonObject.toString();
    }
}
