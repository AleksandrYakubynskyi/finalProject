package com.project.entity;

import com.project.entity.enums.Topic;

import java.math.BigDecimal;

public class Publication {
    private String id;
    private Topic topic;
    private String price;
    private String content;

    public Publication() {
    }

    public Publication(String id, Topic topic, BigDecimal price, String content) {
        this.id = id;
        this.topic = topic;
        this.price = String.valueOf(price);
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
