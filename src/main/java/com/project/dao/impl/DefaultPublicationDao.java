package com.project.dao.impl;

import com.project.constant.Attributes;
import com.project.constant.MySQLQueries;
import com.project.dao.PublicationDao;
import com.project.entity.Publication;
import com.project.entity.User;
import com.project.entity.enums.Gender;
import com.project.entity.enums.Role;
import com.project.entity.enums.Topic;
import com.project.util.DbHelper;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultPublicationDao implements PublicationDao {

    private final DbHelper dbHelper;

    public DefaultPublicationDao(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public Publication addPublication(String id) {
        return null;
    }

    @Override
    public Publication getAllPublications(String id) {
        return null;
    }

    @Override
    public Publication getPublicationByTopic(Topic topic) {

        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_PUBLICATION_BY_TOPIC)) {

            preparedStatement.setString(NumberUtils.INTEGER_ONE, String.valueOf(topic));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return getPublicationFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Publication setPublicationForUser(String id) {
        return null;
    }

    @Override
    public Publication removePublication(String id) {
        return null;
    }

    @Override
    public Publication updatePublication(String id) {
        return null;
    }
    private Publication getPublicationFromResultSet(ResultSet resultSet) throws SQLException {
        Publication publication = new Publication();

        publication.setId(resultSet.getString(Attributes.ID));
        publication.setTopic(Topic.valueOf(resultSet.getString(String.valueOf(Attributes.TOPIC))));
        publication.setPrice(BigDecimal.valueOf(Long.parseLong(resultSet.getString(String.valueOf(Attributes.PRICE)))));
        publication.setContent(resultSet.getString(Attributes.CONTENT));

        return publication;
    }
}
