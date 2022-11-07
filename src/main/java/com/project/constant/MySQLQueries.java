package com.project.constant;

public class MySQLQueries {
    public static final String GET_USER_BY_ID = "SELECT * FROM User WHERE id = ?";
    public static final String GET_PUBLICATION_BY_TOPIC = "SELECT * FROM Publication WHERE topic = ?";
    public static final String ADD_USER = "INSERT INTO User VALUES (?,?,?,?,?,?,?)";
    public static final String ADD_PUBLICATION = "INSERT INTO Publication VALUES (?,?,?,?)";
}
