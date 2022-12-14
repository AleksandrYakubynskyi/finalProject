package com.project.dao;

import com.project.entity.Publication;
import com.project.entity.User;
import com.project.entity.enums.Topic;

import java.util.List;
import java.util.Optional;

public interface PublicationDao {
    public void addPublication(Publication publication);

    public List<Publication> getAllPublications();

    public Optional<Publication> getPublicationByTopic(Topic topic);

    public void setPublicationForUser(User user, Publication publication);

    public void removePublication(String id);

    public void updatePublication(Publication publication);

}
