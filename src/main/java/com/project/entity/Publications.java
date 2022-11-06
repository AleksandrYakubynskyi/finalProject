package com.project.entity;

import java.math.BigDecimal;

public class Publications {
    private String id;
    private Topic topic;
    private BigDecimal price;

    public Publications(String id, Topic topic, BigDecimal price) {
        this.id = id;
        this.topic = topic;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
