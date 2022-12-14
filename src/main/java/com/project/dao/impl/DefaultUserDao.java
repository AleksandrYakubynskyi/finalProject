package com.project.dao.impl;

import com.project.constant.Attributes;
import com.project.constant.MySQLQueries;
import com.project.dao.UserDao;
import com.project.entity.User;
import com.project.entity.enums.Gender;
import com.project.entity.enums.Role;
import com.project.util.DbHelper;
import org.apache.commons.lang3.math.NumberUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultUserDao implements UserDao {
    private final DbHelper dbHelper;

    public DefaultUserDao(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public Optional<User> getUserById(String id) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_USER_BY_ID)) {

            preparedStatement.setString(NumberUtils.INTEGER_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void addUser(User user) {

        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.ADD_USER)) {

            int parameterIndex = NumberUtils.INTEGER_ZERO;
            preparedStatement.setString(++parameterIndex, user.getId());
            preparedStatement.setString(++parameterIndex, user.getFirstname());
            preparedStatement.setString(++parameterIndex, user.getLastname());
            preparedStatement.setString(++parameterIndex, user.getEmail());
            preparedStatement.setString(++parameterIndex, user.getPassword());
            preparedStatement.setString(++parameterIndex, String.valueOf(user.getGender()));
            preparedStatement.setString(++parameterIndex, String.valueOf(user.getRole()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(getUserFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void removeUser(String id) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.DELETE_USER)) {
            preparedStatement.setString(NumberUtils.INTEGER_ONE, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.UPDATE_USER)) {

            int parameterIndex = NumberUtils.INTEGER_ZERO;
            preparedStatement.setString(++parameterIndex, user.getId());
            preparedStatement.setString(++parameterIndex, user.getFirstname());
            preparedStatement.setString(++parameterIndex, user.getLastname());
            preparedStatement.setString(++parameterIndex, user.getEmail());
            preparedStatement.setString(++parameterIndex, user.getPassword());
            preparedStatement.setString(++parameterIndex, String.valueOf(user.getGender()));
            preparedStatement.setString(++parameterIndex, String.valueOf(user.getRole()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_USER_BY_EMAIL)) {

            preparedStatement.setString(NumberUtils.INTEGER_ONE, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getString(Attributes.ID));
        user.setFirstname(resultSet.getString(Attributes.FIRSTNAME));
        user.setLastname(resultSet.getString(Attributes.LASTNAME));
        user.setEmail(resultSet.getString(Attributes.EMAIL));
        user.setPassword(resultSet.getString(Attributes.PASSWORD));
        user.setGender(Gender.valueOf(resultSet.getString(Attributes.GENDER)));
        user.setRole(Role.valueOf(resultSet.getString(Attributes.ROLE)));

        return user;
    }
}
