package com.urlshortener.application.service;

import com.urlshortener.application.exception.GenericException;
import com.urlshortener.application.encoder.UrlKeyEncoder;
import com.urlshortener.domain.model.Url;
import com.urlshortener.domain.exception.DomainException;
import com.urlshortener.domain.exception.UrlNotFoundException;
import com.urlshortener.domain.repository.UrlDomainRepository;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Singleton
public class UrlService {

    private final UrlDomainRepository repository;
    private final UrlKeyEncoder encoder;

    public UrlService(UrlDomainRepository urlDomainRepository, UrlKeyEncoder encoder) {
        this.repository = urlDomainRepository;
        this.encoder = encoder;
    }

    public Url shortUrl(Url url) {
        try {
            log.info("Shortening and saving url [{}]", url);
            url.setKey(encoder.encodeUrl(url.getValue()));
            return repository.save(url);
        } catch (Exception e){
            log.error("An error has occurred on save url [{}]", e.getMessage());
            throw new GenericException("An error has occurred on save url");
        }
    }

    public Url retrieveUrl(String key) {
        try {
            return repository.findByKey(key)
                    .orElseThrow(() -> new UrlNotFoundException(""));
        } catch (DomainException d){
            throw d;
        } catch (Exception e){
            throw new GenericException("An error has ocorred on save url");
        }
    }
}
