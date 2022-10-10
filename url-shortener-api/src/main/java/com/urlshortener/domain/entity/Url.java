package com.urlshortener.domain.entity;

import java.util.UUID;

public class Url {

    private UUID id;
    private String key;
    private String value;

    public Url(String key, String value) {
        this.id = UUID.randomUUID();
        this.key = key;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
