package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;

@Repository
public class UserDaoImpl implements UserDao {
    private final List<User> users = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> getUserById(int id) { // !!!!!!! please figure out how this one works 
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public User createUser(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> updateUser(int id, User updatedUser) {
        return getUserById(id).map(existing -> {
            existing.setUsername(updatedUser.getUsername());
            existing.setEmail(updatedUser.getEmail());
            return existing;
        });
    }

    @Override
    public Optional<User> patchUser(int id, String username, String email) {
        return getUserById(id).map(existing -> {
            if (username != null) existing.setUsername(username);
            if (email != null) existing.setEmail(email);
            return existing;
        });
    }

       @Override
    public boolean deleteUser(int id) {
        return users.removeIf(u -> u.getId() == id);
    }

}
