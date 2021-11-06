package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class RestControllerTest {

    @Inject
    @RestClient
    NOKRestClient nokRestClient;

    @Test
    void testHelloWorld() {

        String response = RestAssured.given()
                .accept(ContentType.TEXT)
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .extract()
                .asPrettyString();

        assertEquals("Hello world", response);
    }

    @Test
    void testHelloWorldWithNOKRestClient() {
        assertEquals("Hello world", nokRestClient.getHello());
    }
}