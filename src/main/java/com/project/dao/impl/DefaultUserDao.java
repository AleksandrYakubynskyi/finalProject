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

public class DefaultUserDao implements UserDao {
    private final DbHelper dbHelper;

    public DefaultUserDao(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public User getUserById(String id) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_USER_BY_ID)) {

            preparedStatement.setString(NumberUtils.INTEGER_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getString(Attributes.ID));
        user.setFirstname(resultSet.getString(Attributes.FIRSTNAME));
        user.setLastname(resultSet.getString(Attributes.LASTNAME));
        user.setPassword(resultSet.getString(Attributes.PASSWORD));
        user.setGender(Gender.valueOf(resultSet.getString(Attributes.GENDER)));
        user.setRole(Role.valueOf(resultSet.getString(Attributes.ROLE)));

        return user;
    }
}
