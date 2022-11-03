package com.urlshortener.application.service;

import com.urlshortener.application.exception.BusinessException;
import com.urlshortener.application.exception.GenericException;
import com.urlshortener.application.encoder.UrlKeyEncoder;
import com.urlshortener.domain.model.Url;
import com.urlshortener.domain.exception.DomainException;
import com.urlshortener.domain.exception.UrlNotFoundException;
import com.urlshortener.domain.repository.UrlDomainRepository;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


@Singleton
@Slf4j
public class UrlService {

    private final UrlDomainRepository repository;
    private final UrlKeyEncoder encoder;

    public UrlService(UrlDomainRepository urlDomainRepository, UrlKeyEncoder encoder) {
        this.repository = urlDomainRepository;
        this.encoder = encoder;
    }

    public Url shortUrl(String url) {
        try {
            Url newUrl = new Url();
            newUrl.setValue(url);
            newUrl.setKey(encoder.encodeUrl(url));
            return repository.save(newUrl);
        } catch (Exception e){
            log.error("An exception has occurred on save encoded URL:[{}]",e.getMessage());
            throw new GenericException("An error has occurred on save url");
        }
    }

    public Url retrieveUrl(String key) {
        try {
            return repository.findByKey(key)
                    .orElseThrow(() -> new UrlNotFoundException(""));
        } catch (DomainException de){
            log.error("An domain exception has occurred on save encoded URL:[{}]",de.getMessage());
            throw new BusinessException(de.getMessage());
        } catch (Exception e){
            log.error("An exception has occurred on save encoded URL:[{}]",e.getMessage());
            throw new GenericException("An error has ocorred on save url");
        }
    }
}
