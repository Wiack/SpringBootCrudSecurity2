package com.example.spring_crudsecur1.Init;

import com.example.spring_crudsecur1.model.Role;
import com.example.spring_crudsecur1.model.User;
import com.example.spring_crudsecur1.service.RoleService;
import com.example.spring_crudsecur1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Init implements CommandLineRunner {
    private RoleService roleService;
    private UserService userService;

    @Autowired
    public Init(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        if (roleService.findByName("ROLE_ADMIN") == null) {
            roleService.saveRole(new Role("ROLE_ADMIN"));
           // roleService.addRoleAtStartup(1L, "ROLE_ADMIN");
        }

        if (roleService.findByName("ROLE_USER") == null) {
            roleService.saveRole(new Role("ROLE_USER"));
        }
    //    List<String> rolist = new ArrayList<>();

        final String ADM="ROLE_ADMIN";
        final String USR="ROLE_USER";

//
//        rolist.add("ROLE_ADMIN");
//        rolist.add("ROLE_USER");
//
//        for(String nameRole: rolist) {
//            if(!roleService.containsName(nameRole)) {
//                roleService.saveRole(new Role(nameRole));
//            }
//        }




//        roleService.containsName()


        User admin = userService.getByEmail("admin@gmail.com");
        if (admin == null) {
            admin = new User(
                    "adminName",
                    "adminLastName",
                    33,
                    "admin@gmail.com",
                    "0000",
                    Collections.singleton(roleService.findByName("ROLE_ADMIN")));

            userService.addUser(admin);
        }

        User user = userService.getByEmail("user@gmail.com");
        if (user == null) {
            user = new User(
                    "userName",
                    "userLastName",
                    23,
                    "user@gmail.com",
                    "0000",
                    Collections.singleton(roleService.findByName("ROLE_USER")));

            userService.addUser(user);
        }
    }
}



