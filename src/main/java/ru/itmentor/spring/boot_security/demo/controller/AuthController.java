package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.dto.UserDto;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public UserDto registerPage() {
        return new UserDto(new User());
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "User " + user.getUsername() + " registered successfully";
    }
}
