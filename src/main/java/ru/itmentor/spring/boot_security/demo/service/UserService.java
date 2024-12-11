package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    List<User> getAllUsers();
    Set<Role> getRolesByName(List<String> roleNames);
}
