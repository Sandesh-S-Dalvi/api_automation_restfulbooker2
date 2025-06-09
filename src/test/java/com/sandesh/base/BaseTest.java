package com.sandesh.base;

import org.testng.annotations.BeforeTest;

import com.sandesh.assertions.AssertActions;
import com.sandesh.endpoints.API_Constants;
import com.sandesh.modules.PayloadBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadBuilder payloadBuilder;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;
    
    @BeforeTest
    public void setUp() {
        payloadBuilder = new PayloadBuilder();
        assertActions = new AssertActions();

        requestSpecification = new RequestSpecBuilder()
            .setBaseUri(API_Constants.BASE_URL)
            .addHeader("content-Type", "application/json")
            .build().log().all();
    }

    public String getToken() {
        requestSpecification = RestAssured
            .given()
            //.baseUri(API_Constants.BASE_URL)
            .basePath(API_Constants.AUTH_URL);

        String payload = payloadBuilder.setAuthPayload();

        response = requestSpecification
            .contentType(ContentType.JSON)
            .body(payload)
            .when()
            .post();

        String token = payloadBuilder
            .getTokenFromJSON(response.asString());

        return token;
        
    }


}
