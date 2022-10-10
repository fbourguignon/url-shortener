package com.urlshortener.domain.exception;

public class UrlNotFoundException extends DomainException {
    public UrlNotFoundException(String message) {
        super(message);
    }
}
