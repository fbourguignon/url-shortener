package com.urlshortener.domain.repository;

import com.urlshortener.domain.entity.Url;

import java.util.Optional;

public interface UrlRepository {

    Url save(Url url);
    Optional<Url> findByKey(String key);

}
