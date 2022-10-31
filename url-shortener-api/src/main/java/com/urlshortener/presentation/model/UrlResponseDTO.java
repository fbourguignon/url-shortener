package com.urlshortener.presentation.model;

import io.micronaut.core.annotation.Introspected;
import lombok.*;



@Data
@Builder
@Introspected
public class UrlResponseDTO {
    private String url;
    private String key;
}
