package org.workstack.security.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.workstack.model.User;
import org.workstack.repository.UserRepository;
import org.workstack.security.model.UserDetailsImpl;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name)
            throws UsernameNotFoundException {
        User user = userRepository.findByName(name);
        Hibernate.initialize(user.getRoles());
        return new UserDetailsImpl(user);
    }
}
