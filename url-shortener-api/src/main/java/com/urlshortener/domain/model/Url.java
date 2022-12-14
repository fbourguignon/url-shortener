package com.urlshortener.domain.model;

import io.micronaut.core.annotation.Introspected;

import java.io.Serializable;
import java.util.UUID;
@Introspected
public class Url implements Serializable {

    private String id;
    private String key;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
