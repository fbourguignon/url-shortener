package com.urlshortener.infraestructure.encoder;

import com.google.common.hash.Hashing;
import com.urlshortener.application.encoder.UrlKeyEncoder;
import jakarta.inject.Singleton;

import javax.validation.constraints.NotNull;
import java.nio.charset.Charset;
import java.util.UUID;

@Singleton
public class GuavaUrlKeyEncoder implements UrlKeyEncoder {
    @Override
    public String encodeUrl(@NotNull String url) {
        return Hashing.adler32().hashString(url.concat(UUID.randomUUID().toString()), Charset.defaultCharset()).toString();
    }
}
