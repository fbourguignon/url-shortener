package com.urlshortener.presentation.model;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Value
@Introspected
public class UrlShortenRequestDTO {

    @NotNull
    @Pattern(regexp = "(https?://|www\\\\.)[-a-zA-Z0-9+&@#/%?=~_|!:.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "Field must be a valid url.")
    @Schema(description="url", example = "www.google.com.br")
    private String url;
}
