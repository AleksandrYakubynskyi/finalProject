package com.project.dao;

import com.project.entity.Publication;
import com.project.entity.enums.Topic;

public interface PublicationDao {
    public Publication addPublication(String id);

    public Publication getAllPublications(String id);

    Publication getPublicationByTopic(Topic topic);

    public Publication setPublicationForUser(String id);

    public Publication removePublication(String id);

    public Publication updatePublication(String id);

}
