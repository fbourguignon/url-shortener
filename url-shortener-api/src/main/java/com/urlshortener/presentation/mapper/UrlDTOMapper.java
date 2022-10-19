package com.urlshortener.presentation.mapper;

import com.urlshortener.presentation.model.UrlResponseDTO;
import com.urlshortener.domain.model.Url;
import jakarta.inject.Singleton;

@Singleton
public class UrlDTOMapper {

    public UrlResponseDTO toDTO(Url encodedUrl){
        return UrlResponseDTO
                .builder()
                .url(encodedUrl.getValue())
                .build();
    }
}
