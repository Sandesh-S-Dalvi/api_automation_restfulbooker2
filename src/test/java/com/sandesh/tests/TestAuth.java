package com.sandesh.tests;

import org.testng.annotations.Test;

import com.sandesh.base.BaseTest;
import com.sandesh.endpoints.API_Constants;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

public class TestAuth extends BaseTest {

    @Test
    public void testAuthentication() {

        requestSpecification.basePath(API_Constants.AUTH_URL);

        response = RestAssured
            .given(requestSpecification)
                .config(RestAssuredConfig.newConfig().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
            .when().body(payloadBuilder.setAuthPayload())
                .post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);                

    }

}
