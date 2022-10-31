package com.urlshortener.infraestructure.persistence.entity;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotBlank;

@Data
@Builder
@MappedEntity
public class UrlEntity {

    @Id
    @GeneratedValue
    private String id;

    @NotBlank
    private String key;

    @NotBlank
    private String value;

}
