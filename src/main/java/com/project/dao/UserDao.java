package com.project.dao;

import com.project.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserDao {
    public Optional<User> getUserById(String id);

    public void addUser(User user);

    public List<User> getAllUsers();

    public void removeUser(String id);

    public void updateUser(User user);
    public Optional<User> getUserByEmail(String email);
}
