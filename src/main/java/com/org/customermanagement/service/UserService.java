package com.org.customermanagement.service;

import com.org.customermanagement.model.Role;
import com.org.customermanagement.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    void changeRole(Role newRole, String username);
    List<User> findAllUsers();
}