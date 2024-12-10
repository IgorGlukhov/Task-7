package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    List<User> getAllUsers();

    List<Role> getAllRoles();

}
