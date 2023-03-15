//package com.example.SprigCrudSecur1.DefaultUser;
//
//import com.example.SprigCrudSecur1.model.User;
//import com.example.SprigCrudSecur1.service.RoleService;
//import com.example.SprigCrudSecur1.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//@Component
//public class DefUser implements CommandLineRunner {
//    private RoleService roleService;
//    private UserService userService;
//
//    @Autowired
//    public DefUser(RoleService roleService, UserService userService) {
//        this.roleService = roleService;
//        this.userService = userService;
//    }
////String firstName, String lastName, Byte age, String email, String password, Set<Role> roles
//    @Override
//    public void run(String... args) {
//
//        User admin = userService.getByEmail("admin@gmail.com");
//        if (admin == null) {
//            admin = new User(
//                    "adminName",
//                    "adminLastName",
//                    33,
//                    "admin@gmail.com",
//                    "0000",
//                    Collections.singleton(roleService.findByName("ROLE_ADMIN")));
//
//            userService.addUser(admin);
//        }
//    }
//}
//
//
//
