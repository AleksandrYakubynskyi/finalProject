package com.project.dao;

import com.project.entity.User;

import java.util.List;


public interface UserDao {
    public User getUserById(String id);

    public void addUser(User user);

    public List<User> getAllUsers();

    public void removeUser(String id);

    public void updateUser(User user);
}
