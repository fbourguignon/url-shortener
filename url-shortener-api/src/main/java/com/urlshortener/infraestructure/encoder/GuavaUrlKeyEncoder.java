package com.urlshortener.infraestructure.encoder;

import com.urlshortener.application.encoder.UrlKeyEncoder;
import jakarta.inject.Singleton;

@Singleton
public class GuavaUrlKeyEncoder implements UrlKeyEncoder {
    @Override
    public String encodeUrl(String url) {
        return null;
    }
}
