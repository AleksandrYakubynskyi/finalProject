package com.project;

import com.project.dao.impl.DefaultPublicationDao;
import com.project.dao.impl.DefaultUserDao;
import com.project.entity.Publication;
import com.project.entity.User;
import com.project.entity.enums.Gender;
import com.project.entity.enums.Role;
import com.project.entity.enums.Topic;
import com.project.servlet.RegistrationServlet;
import com.project.util.DbHelper;

import java.math.BigDecimal;

public class TestProject {
    public static void main(String[] args) {
        DbHelper db = new DbHelper();
        DefaultPublicationDao dfp = new DefaultPublicationDao(db);
        DefaultUserDao dfu = new DefaultUserDao(db);
        //dfp.addPublication(new Publication("sads",Topic.POLITICS, BigDecimal.ZERO,"asds"));
        System.out.println(dfp.getPublicationByTopic(Topic.POLITICS));
        System.out.println(dfp.getAllPublications());
        //dfu.addUser(new User("asas","fdhg","dfghg","ghngf","ghngfh", Gender.MALE, Role.ADMIN));
        System.out.println(dfu.getUserByEmail("dfdf"));


    }
}
