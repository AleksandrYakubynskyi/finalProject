package com.project.service;

import com.project.dao.UserDao;
import com.project.entity.User;
import com.project.util.DbHelper;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final DbHelper dbHelper;
    private final UserDao userDao;

    public UserService(DbHelper dbHelper, UserDao userDao) {
        this.dbHelper = dbHelper;
        this.userDao = userDao;
    }

    public Optional<User> getUserById(String id) {
        return userDao.getUserById(id);
    }
    public Optional<User> getUserByEmail(String email){

        return userDao.getUserByEmail(email);
    }

    public void addUser(User user) {
        userDao.addUser(user);

    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void removeUser(String id) {
        userDao.removeUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public DbHelper getDbHelper() {
        return dbHelper;
    }
}
