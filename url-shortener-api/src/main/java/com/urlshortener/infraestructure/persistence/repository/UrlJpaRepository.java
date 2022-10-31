package com.urlshortener.infraestructure.persistence.repository;

import com.urlshortener.infraestructure.persistence.entity.UrlEntity;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@MongoRepository
public interface UrlJpaRepository extends CrudRepository<UrlEntity, String> {
    Optional<UrlEntity> findByKey(String key);
}
