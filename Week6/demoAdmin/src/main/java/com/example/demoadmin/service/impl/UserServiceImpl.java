package com.example.demoadmin.service.impl;

import com.example.demoadmin.model.User;
import com.example.demoadmin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User checkUser(String user_id, String password) {
        if (user_id == null || password == null || user_id == "" || password == "") return null;
        User user = new User(user_id, password);
        return user;
    }
}
