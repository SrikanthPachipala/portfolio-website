package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	User getUser(Long id);
    List<User> getAllUsers();
    User saveUser(User user);
}
