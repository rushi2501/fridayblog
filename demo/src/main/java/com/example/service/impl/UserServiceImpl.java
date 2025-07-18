package com.example.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

        @Override
    public User createUser(User user) {
        boolean exists = userDao.getAllUsers().stream()
            .anyMatch(u -> u.getUsername().equalsIgnoreCase(user.getUsername()));
        if (exists) {
            throw new IllegalArgumentException("Sorry, This username is taken.");
        }
        return userDao.createUser(user);
    }

    @Override
public List<User> getAllUsers() {
    if (userDao.getAllUsers().isEmpty()) {
        throw new RuntimeException("No users found.");
    }
    return userDao.getAllUsers();
}

    @Override
    public Optional<User> getUserById(int id) {
        if (userDao.getUserById(id).isEmpty()) {
            throw new RuntimeException("User not found with id: " + id);
        }
        if (id <= 0) {
            throw new IllegalArgumentException("impossible id: " + id);
        }
        return userDao.getUserById(id);
    }

    @Override
    public Optional<User> updateUser(int id, User updatedUser) {
        if (userDao.updateUser(id, updatedUser).isEmpty()) {
            throw new RuntimeException("User not found with id: " + id);
        }
        if (id <= 0) {
            throw new IllegalArgumentException("impossible id");
        }
        return userDao.updateUser(id, updatedUser);
    }

    @Override
    public Optional<User> patchUser(int id, String username, String email) { // ADD CHECK TO SEE IF user or email EXISTS or is null
       if (userDao.patchUser(id, username, email).isEmpty()) {
            throw new RuntimeException("User not found with id: " + id);
        }
        if (id <= 0) {
            throw new IllegalArgumentException("impossible id ");
        }
        if (username == null || email == null) {
            throw new IllegalArgumentException("Username and email cannot both be null");
        }
        return userDao.patchUser(id, username, email);
    }

    @Override
    public boolean deleteUser(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("impossible id ");
        }
        if (userDao.getUserById(id).isEmpty()) {
            throw new RuntimeException("User not found with id: " + id);
        }
        return userDao.deleteUser(id);
    }
}