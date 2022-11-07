package com.project.dao;

import com.project.entity.User;


public interface UserDao {
    public User getUserById(String id);

    public void addUser(User user);
    public User getAllUsers(String id);

    public User removeUser(String id);

    public User updateUser(String id);
}
