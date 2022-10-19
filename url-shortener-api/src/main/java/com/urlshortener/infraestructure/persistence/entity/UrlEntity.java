package com.urlshortener.infraestructure.persistence.entity;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@MappedEntity
public class UrlEntity implements Serializable {

    @Id
    @GeneratedValue
    private String id;

    @NonNull
    @NotBlank
    private final String key;

    @NonNull
    @NotBlank
    private final String value;

    public UrlEntity(@NonNull String key, @NonNull String value) {
        this.key = key;
        this.value = value;
    }
}
