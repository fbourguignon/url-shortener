package com.urlshortener.presentation.model;

import io.micronaut.core.annotation.Introspected;
import lombok.Value;

@Value
@Introspected
public class UrlShortenRequestDTO {
    private String url;
}
