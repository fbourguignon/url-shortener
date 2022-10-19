package com.urlshortener.application.repository;

import com.urlshortener.domain.model.Url;
import com.urlshortener.domain.repository.UrlDomainRepository;
import com.urlshortener.infraestructure.persistence.converter.UrlEntityConverter;
import com.urlshortener.infraestructure.persistence.repository.UrlJpaRepository;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class UrlRepository implements UrlDomainRepository {

    private final UrlJpaRepository repository;
    private final UrlEntityConverter converter;

    public UrlRepository(UrlJpaRepository repository, UrlEntityConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Url save(Url url) {
        return converter.toDomain(repository.save(converter.toEntity(url)));
    }

    @Override
    public Optional<Url> findByKey(String key) {
        return repository.findByKey(key).map(converter::toDomain);
    }
}
