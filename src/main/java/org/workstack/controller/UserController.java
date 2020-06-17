package org.workstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.User;
import org.workstack.service.user.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<User> getUser() {
        User user = userService.getUserByName("John");
        return ResponseEntity.ok().body(user);
    }
}
