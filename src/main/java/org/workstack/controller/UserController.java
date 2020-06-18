package org.workstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.User;
import org.workstack.service.user.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/users")
    public User save(@RequestBody User user){
        return userService.saveUser(user);
    }

    private User getUserByName() {
        return userService.getUserByName("John");
    }
}
