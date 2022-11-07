package com.project.dao;

import com.project.entity.User;


public interface UserDao {
    public User getUserById(String id);

    public User addUser(String id);

    public User getAllUsers(String id);

    public User removeUser(String id);

    public User updateUser(String id);
}
