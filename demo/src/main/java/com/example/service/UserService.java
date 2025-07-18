package com.example.service;
import java.util.List;
import java.util.Optional;

import com.example.model.User;


public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(int id); // why optional?
    Optional<User> updateUser(int id, User updatedUser);
    Optional<User> patchUser(int id, String username, String email);
    boolean deleteUser(int id);
}