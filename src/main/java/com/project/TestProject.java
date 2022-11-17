package com.project;

import com.project.dao.impl.DefaultPublicationDao;
import com.project.dao.impl.DefaultUserDao;
import com.project.util.DbHelper;

public class TestProject {
    public static void main(String[] args) {
        DbHelper db = new DbHelper();
        DefaultPublicationDao dfp = new DefaultPublicationDao(db);
        DefaultUserDao dfu = new DefaultUserDao(db);

    }
}
