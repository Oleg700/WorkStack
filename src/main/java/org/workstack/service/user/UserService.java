package org.workstack.service.user;

import org.workstack.model.User;

public interface UserService {

    User getUserByName(String name);

    void saveUser(User user);
}
