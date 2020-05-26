package com.example.demoadmin.service;

import com.example.demoadmin.model.User;

public interface UserService {
    public User checkUser(String user_id, String password);
}
