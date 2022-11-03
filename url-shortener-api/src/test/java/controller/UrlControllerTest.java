package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.urlshortener.presentation.model.UrlShortenRequestDTO;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UrlControllerTest {

    private final String ENDPOINT = "/v1/url";
    private final String ENDPOINT_WITH_ID = ENDPOINT.concat("/%s");
    private String urlKey =  "";
    private final String notFoundKey =  "notFoundKey";

    @Test
    @Order(1)
    void shortenUrl_Success(RequestSpecification spec) throws JsonProcessingException {

        var request = new UrlShortenRequestDTO("www.google.com.br");
        urlKey = spec
                    .when()
                    .body(request)
                    .contentType(ContentType.JSON)
                    .post(ENDPOINT)
                .then()
                    .statusCode(201)
                    .body("url", equalTo("www.google.com.br"))
                    .body("key", notNullValue())
                .extract()
                    .body()
                    .path("key");
    }

    @Test
    @Order(2)
    public void getShortenedUrl_Success(RequestSpecification spec) {
        spec
                .when()
                    .redirects().follow(false)
                    .get(String.format(ENDPOINT_WITH_ID, this.urlKey));
    }

    @Test
    @Order(3)
    public void getShortenedUrl_KeyNotFound(RequestSpecification spec) {
        spec
             .when()
                .get(String.format(ENDPOINT_WITH_ID, notFoundKey))
             .then()
                .statusCode(422);

    }
}
