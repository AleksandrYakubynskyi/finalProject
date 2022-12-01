package com.project.dao.impl;

import com.project.constant.Attributes;
import com.project.constant.MySQLQueries;
import com.project.dao.PublicationDao;
import com.project.entity.Publication;
import com.project.entity.User;
import com.project.entity.enums.Topic;
import com.project.util.DbHelper;
import org.apache.commons.lang3.math.NumberUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultPublicationDao implements PublicationDao {

    private final DbHelper dbHelper;

    public DefaultPublicationDao(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public void addPublication(Publication publication) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.ADD_PUBLICATION)) {

            int parameterIndex = NumberUtils.INTEGER_ZERO;
            preparedStatement.setString(++parameterIndex, publication.getId());
            preparedStatement.setString(++parameterIndex, String.valueOf(publication.getTopic()));
            preparedStatement.setBigDecimal(++parameterIndex, publication.getPrice());
            preparedStatement.setString(++parameterIndex, publication.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Publication> getPublicationById(String id) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_PUBLICATION_BY_ID)) {

            preparedStatement.setString(NumberUtils.INTEGER_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(getPublicationFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Publication> getAllPublications() {
        List<Publication> publications = new ArrayList<>();
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_ALL_PUBLICATIONS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                publications.add(getPublicationFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return publications;
    }

    @Override
    public Optional<Publication> getPublicationByTopic(Topic topic) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.GET_PUBLICATION_BY_TOPIC)) {

            preparedStatement.setString(NumberUtils.INTEGER_ONE, String.valueOf(topic));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getPublicationFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void setPublicationForUser(User user, Publication publication) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.SET_PUBLICATION_FOR_USER)) {
            preparedStatement.setString(NumberUtils.INTEGER_ONE, user.getId());
            preparedStatement.setString(NumberUtils.INTEGER_TWO, publication.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removePublication(String id) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.DELETE_PUBLICATION)) {
            preparedStatement.setString(NumberUtils.INTEGER_ONE, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePublication(Publication publication) {
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MySQLQueries.UPDATE_PUBLICATION)) {

            int parameterIndex = NumberUtils.INTEGER_ZERO;
            preparedStatement.setString(++parameterIndex, publication.getId());
            preparedStatement.setString(++parameterIndex, String.valueOf(publication.getTopic()));
            preparedStatement.setBigDecimal(++parameterIndex, publication.getPrice());
            preparedStatement.setString(++parameterIndex, publication.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Publication getPublicationFromResultSet(ResultSet resultSet) throws SQLException {
        Publication publication = new Publication();

        publication.setId(resultSet.getString(Attributes.ID));
        publication.setTopic(Topic.valueOf(resultSet.getString(Attributes.TOPIC)));
        publication.setPrice(resultSet.getBigDecimal(Attributes.PRICE));
        publication.setContent(resultSet.getString(Attributes.CONTENT));

        return publication;
    }
}
