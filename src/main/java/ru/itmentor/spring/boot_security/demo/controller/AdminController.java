package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.dto.UserDto;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
@Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/show/all")
    public List<UserDto> listUsers() {
        return userService.getAllUsers()
                .stream()
                .map(UserDto::new) // Преобразуем каждый User в UserDto
                .toList();
    }


    @GetMapping("/show/{id}")
    public UserDto showUser(@PathVariable int id) {
        return new UserDto(userService.getUser(id));
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(userService.getRolesByName(userDto.getRoles()));
        userService.saveUser(user);
        return "User " + user.getUsername() + " added";
    }

    @PutMapping("/edit/{id}")
    public String editUser(@PathVariable int id,@RequestBody UserDto userDto) {
        User user = new User();
        user.setId(id);
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(userService.getRolesByName(userDto.getRoles()));
        userService.saveUser(user);
        return "User " + user.getUsername() + " edited";
    }



    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User with id " + id + " deleted";
    }
}
