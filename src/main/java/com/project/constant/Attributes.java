package com.project.constant;

import com.project.entity.enums.Topic;

import java.math.BigDecimal;

public class Attributes {
    public static final String USER_TABLE = "user";
    public static final String ID = "id";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String GENDER = "gender";
    public static final String ROLE = "role";
    public static final Topic TOPIC = Topic.valueOf("topic");
    public static final BigDecimal PRICE = BigDecimal.valueOf(Long.parseLong("price"));
    public static final String CONTENT = "content";

}
