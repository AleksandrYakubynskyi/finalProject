package com.project.service;

import com.project.dao.PublicationDao;
import com.project.entity.Publication;
import com.project.entity.User;
import com.project.entity.enums.Topic;
import com.project.util.DbHelper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PublicationService {
    private final PublicationDao publicationDao;
    private final DbHelper dbHelper;


    public PublicationService(PublicationDao publicationDao, DbHelper dbHelper) {
        this.publicationDao = publicationDao;
        this.dbHelper = dbHelper;
    }

    public void addPublication(Publication publication) {
        publication.setId(UUID.randomUUID().toString());
        publicationDao.addPublication(publication);
    }

    public List<Publication> getAllPublications() {
        return publicationDao.getAllPublications();
    }
    public Optional<Publication> getPublicationById(String id){
        return publicationDao.getPublicationById(id);
    }

    public Optional<Publication> getPublicationByTopic(Topic topic) {
        return publicationDao.getPublicationByTopic(topic);
    }

    public void setPublicationForUser(User user, Publication publication) {
        publicationDao.setPublicationForUser(user, publication);
    }

    public void removePublication(String id) {
        publicationDao.removePublication(id);
    }

    public void updatePublication(Publication publication) {
        publicationDao.updatePublication(publication);
    }

    public DbHelper getDbHelper() {
        return dbHelper;
    }
}
