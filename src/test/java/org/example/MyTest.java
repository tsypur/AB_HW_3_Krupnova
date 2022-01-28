package org.example;



import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;


public class MyTest {
    static Map<String, String> headers = new HashMap<>();
    static Properties prop = new Properties();


    @Test
    void getListUsersTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }
    @Test
    void getSingleUsersTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    void getSingleUsersNotFoundTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);
    }

    @Test
    void getCreateTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    void getUpdateTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }
    @Test
    void getDeleteTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }
    @Test
    void getRegisterSuccessfulTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/register")
                .then()
                .statusCode(200);
    }

    @Test
    void getLoginSuccessfulTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/login")
                .then()
                .statusCode(200);
    }

    @Test
    void getLoginUnsuccessfulTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/login")
                .then()
                .statusCode(400);
    }
    @Test
    void getDelayedResponseTest() {
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .statusCode(200);
    }
}