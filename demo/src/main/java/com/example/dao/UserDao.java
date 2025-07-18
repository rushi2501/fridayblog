package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.model.User;

public interface UserDao {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    User createUser(User user);
    Optional<User> updateUser(int id, User updatedUser);
    Optional<User> patchUser(int id, String username, String email);
    boolean deleteUser(int id);
}
