package com.urlshortener.presentation.rest;

import com.urlshortener.presentation.mapper.UrlDTOMapper;
import com.urlshortener.presentation.model.UrlShortenRequestDTO;
import com.urlshortener.presentation.model.UrlResponseDTO;
import com.urlshortener.application.service.UrlService;
import com.urlshortener.domain.model.Url;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.extern.slf4j.Slf4j;


import javax.validation.Valid;
import java.net.URI;

@Slf4j
@Controller("/v1/url")
public class UrlController {

    private final UrlService service;
    private final UrlDTOMapper mapper;

    public UrlController(UrlService service, UrlDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Post
    public HttpResponse<UrlResponseDTO> shortenUrl(@Valid @Body UrlShortenRequestDTO request){
        log.info("Handling request to short URL: [{}]", request.getUrl());
        Url url = service.shortUrl(request.getUrl());
        return HttpResponse.created(mapper.toDTO(url));
    }

    @Get("/{key}")
    public HttpResponse retrieveUrl(@PathVariable String key){
        log.info("Handling request to retrieve shortened URL: [{}]", key);
        Url url = service.retrieveUrl(key);
        return HttpResponse.redirect(URI.create(url.getValue()));
    }


}
