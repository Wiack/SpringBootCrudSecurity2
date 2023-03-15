package com.example.spring_crudsecur1.controller;

import com.example.spring_crudsecur1.model.User;
import com.example.spring_crudsecur1.service.RoleService;
import com.example.spring_crudsecur1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllUsers(Model model, Principal principal) {
        model.addAttribute("user", userService.getByEmail(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("allRoles", roleService.findAll());
        return "admin/index";
    }

    @GetMapping("/show")
    public String showAdmin(Model model, Principal principal) {
        model.addAttribute("user", userService.getByEmail(principal.getName()));
        return "admin/user";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/index";
        }
        userService.addUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id, Principal principal) {
        userService.deleteUserById(id, principal);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/index";
        }
        userService.updateUser(id, user);
        return "redirect:/admin";
    }
}
