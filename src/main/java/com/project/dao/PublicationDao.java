package com.project.dao;

import com.project.entity.Publication;
import com.project.entity.enums.Topic;

public interface PublicationDao {
    public void addPublication(Publication publication);

    public Publication getAllPublications(String id);

    public Publication getPublicationByTopic(Topic topic);

    public Publication setPublicationForUser(String id);

    public Publication removePublication(String id);

    public Publication updatePublication(String id);

}
