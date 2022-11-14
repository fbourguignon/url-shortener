package com.urlshortener.presentation.model;

import io.micronaut.core.annotation.Introspected;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Value
@Introspected
public class UrlShortenRequestDTO {

    @NotNull
    @Pattern(regexp = "(https?://|www\\\\.)[-a-zA-Z0-9+&@#/%?=~_|!:.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "Field must be a valid url.")
    private String url;
}
