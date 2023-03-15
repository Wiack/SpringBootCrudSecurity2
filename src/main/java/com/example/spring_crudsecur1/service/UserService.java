package com.example.spring_crudsecur1.service;

import com.example.spring_crudsecur1.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUserById(Long id, Principal principal);

    void updateUser(Long id, User user);

    User getById(Long id);

    User getByEmail(String email);

}
