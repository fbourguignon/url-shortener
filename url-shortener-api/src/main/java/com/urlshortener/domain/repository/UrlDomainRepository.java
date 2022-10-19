package com.urlshortener.domain.repository;

import com.urlshortener.domain.model.Url;

import java.util.Optional;

public interface UrlDomainRepository {

    Url save(Url url);
    Optional<Url> findByKey(String key);

}
