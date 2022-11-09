package com.project;

import com.project.dao.impl.DefaultPublicationDao;
import com.project.dao.impl.DefaultUserDao;
import com.project.entity.Publication;
import com.project.entity.User;
import com.project.entity.enums.Gender;
import com.project.entity.enums.Role;
import com.project.entity.enums.Topic;
import com.project.util.DbHelper;

import java.math.BigDecimal;


public class TestProject {
    public static void main(String[] args) {
        DbHelper db = new DbHelper();
        DefaultPublicationDao dfp = new DefaultPublicationDao(db);
        DefaultUserDao dfu = new DefaultUserDao(db);
        dfp.addPublication(new Publication("2", Topic.ECONOMY, BigDecimal.ONE, "sldklcksnvfkd"));
        dfu.addUser(new User("df", "dfdf", "dfdf", "dfdf", "dfdfd", Gender.MALE, Role.USER));
        System.out.println(dfp.getAllPublications());
        System.out.println(dfp.getPublicationByTopic(Topic.ECONOMY));
        //dfp.removePublication("2");
        //dfu.removeUser("df");
//        dfp.setPublicationForUser(new User("df","dfdf", "dfdf", "dfdf", "dfdfd", Gender.MALE, Role.USER), new Publication("2", Topic.ECONOMY, BigDecimal.ONE, "sldklcksnvfkd"));
    }
}
