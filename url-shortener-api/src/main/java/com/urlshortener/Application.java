package com.urlshortener;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "url-shortener-api",
                version = "0.1",
                description = "Sample project using some micronaut starters",
                license = @License(name = "Apache 2.0"),
                contact = @Contact(url = "http://github.com/fbourguignon", name = "Franklin Bourguignon")
        )
)
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
