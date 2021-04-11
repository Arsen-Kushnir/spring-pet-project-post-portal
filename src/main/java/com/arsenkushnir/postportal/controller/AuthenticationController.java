package com.arsenkushnir.postportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

import static com.arsenkushnir.postportal.util.FlashMessageConstants.FLASH_MESSAGE_ERROR;
import static com.arsenkushnir.postportal.util.FlashMessageConstants.FLASH_MESSAGE_SUCCESS;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login(String error, String logout, Model model) {

        if (Objects.nonNull(error)) {
            model.addAttribute(FLASH_MESSAGE_ERROR, "Invalid username or password!");
        }

        if(Objects.nonNull(logout)){
            model.addAttribute(FLASH_MESSAGE_SUCCESS, "You have successfully logout!");
        }

        return "/main/login";
    }
}
