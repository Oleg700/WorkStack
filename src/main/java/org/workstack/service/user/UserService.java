package org.workstack.service.user;

import org.workstack.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User getUserByName(String name);

    User saveUser(User user);
}
