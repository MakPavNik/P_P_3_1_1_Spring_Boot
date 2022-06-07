package com.makarov.P_P_3_1_1_Spring_Boot.controllers;

import com.makarov.P_P_3_1_1_Spring_Boot.models.User;
import com.makarov.P_P_3_1_1_Spring_Boot.repository.UserRepository;
import com.makarov.P_P_3_1_1_Spring_Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getTableUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    public String addUserTable(User user) {
        return "add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/update/{id}")
    public String updateUserTable(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update";
    }
    @PostMapping("/update")
    public String updateUser (User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
