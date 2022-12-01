package com.project.constant;

public class MySQLQueries {
    public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String GET_PUBLICATION_BY_ID = "SELECT * FROM publication WHERE id = ?";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    public static final String GET_PUBLICATION_BY_TOPIC = "SELECT * FROM publication WHERE topic = ?";
    public static final String ADD_USER = "INSERT INTO user VALUES (?,?,?,?,?,?,?)";
    public static final String ADD_PUBLICATION = "INSERT INTO publication VALUES (?,?,?,?)";
    public static final String GET_ALL_USERS = "SELECT* FROM user";
    public static final String GET_ALL_PUBLICATIONS = "SELECT * FROM publication";
    public static final String DELETE_USER = "DELETE  FROM user WHERE id = ?";
    public static final String DELETE_PUBLICATION = "DELETE  FROM publication WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE user SET id = ?, firstname = ?, lastname = ?, email = ?" +
            ", password = ?, gender = ?, role = ? WHERE id = ?";
    public static final String UPDATE_PUBLICATION = "UPDATE publication SET id = ?, topic = ?, price = ?, content = ?" +
            "WHERE id = ?";
    public static final String SET_PUBLICATION_FOR_USER = "INSERT INTO user2publicationRelations VALUES (?,?)";
}
