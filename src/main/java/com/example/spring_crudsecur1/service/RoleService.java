package com.example.spring_crudsecur1.service;

import com.example.spring_crudsecur1.model.Role;

import java.util.List;

public interface RoleService {

    Role findByName(String name);
    List<Role> findAll();
    void saveRole(Role role);

}
