package com.urlshortener.presentation.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UrlResponseDTO {
    private String url;
}
