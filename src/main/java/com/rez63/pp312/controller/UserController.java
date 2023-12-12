package com.rez63.pp312.controller;

import com.rez63.pp312.model.User;
import com.rez63.pp312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }

    @GetMapping("/addUser")
    public String createUserForm(User user) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/list";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/list";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/list";
    }

    @GetMapping("/user-update")
    public String updateUserForm(@RequestParam(name = "id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userUpdate";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/list";
    }

    @GetMapping("/error")
    public String errorMessger(Model model) {
        model.addAttribute("errMess", "Something wrong");
        return "error";
    }
}
