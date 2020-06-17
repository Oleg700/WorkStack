package org.workstack.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workstack.model.User;
import org.workstack.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
