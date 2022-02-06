package com.andrewborchenko.spring.buycycle.controllers;

import com.andrewborchenko.spring.buycycle.models.User;
import com.andrewborchenko.spring.buycycle.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с таким " +
                    "email: " + user.getEmail() + " уже существует");
            return "registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    // для тестов
    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }

    @GetMapping("/index")
    public String testSecurityUrl() {
        return "index";
    }

    // в spring есть возможность ловить определенного user-а
    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allProducts", user.getProducts());
        return "user-info";
    }

}
