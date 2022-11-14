package com.urlshortener.presentation.rest;

import com.urlshortener.presentation.mapper.UrlDTOMapper;
import com.urlshortener.presentation.model.UrlShortenRequestDTO;
import com.urlshortener.presentation.model.UrlResponseDTO;
import com.urlshortener.application.service.UrlService;
import com.urlshortener.domain.model.Url;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Shorten URL",
            description = "Route to short a URL and retrieve a key"
    )
    @ApiResponse(
            content = @Content(mediaType = "text/json",
                    schema = @Schema(type="string"))
    )
    public HttpResponse<UrlResponseDTO> shortenUrl(@Valid @Body UrlShortenRequestDTO request){
        log.info("Handling request to short URL: [{}]", request.getUrl());
        Url url = service.shortUrl(request.getUrl());
        return HttpResponse.created(mapper.toDTO(url));
    }

    @Get("/{key}")
    @Operation(summary = "Retrieve URL",
            description = "Route to retrieve a shortened URL by key"
    )
    @ApiResponse(
            content = @Content(mediaType = "text/json",
                    schema = @Schema(type="string"))
    )
    @ApiResponse(responseCode = "301", description = "Redirect to shortened URL")
    public HttpResponse retrieveUrl(@PathVariable String key){
        log.info("Handling request to retrieve shortened URL: [{}]", key);
        Url url = service.retrieveUrl(key);
        return HttpResponse.redirect(URI.create(url.getValue()));
    }


}
