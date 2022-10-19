package com.urlshortener.infraestructure.persistence.converter;

import com.urlshortener.domain.model.Url;
import com.urlshortener.infraestructure.persistence.entity.UrlEntity;
import jakarta.inject.Singleton;

@Singleton
public class UrlEntityConverter {

    public UrlEntity toEntity(Url url){
        return UrlEntity
                .builder()
                .id(url.getId())
                .key(url.getKey())
                .value(url.getValue())
                .build();
    }

    public Url toDomain(UrlEntity entity){
        Url url = new Url();
        url.setKey(entity.getKey());
        url.setValue(entity.getValue());
        url.setId(entity.getId());
        return url;
    }
}
