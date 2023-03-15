package com.example.spring_crudsecur1.service;

import com.example.spring_crudsecur1.model.Role;
import com.example.spring_crudsecur1.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
