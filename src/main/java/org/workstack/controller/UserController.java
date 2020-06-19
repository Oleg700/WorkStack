package org.workstack.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.User;
import org.workstack.model.dto.UserDto;
import org.workstack.service.user.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/users")
    public User save(@Valid @RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return userService.saveUser(user);
    }
}
