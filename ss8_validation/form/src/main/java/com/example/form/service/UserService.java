package com.example.form.service;

import com.example.form.model.User;
import com.example.form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
}
