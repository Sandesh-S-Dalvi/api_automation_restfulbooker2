package com.sandesh.tests.CRUD_TCs;

import org.testng.annotations.Test;

import com.sandesh.base.BaseTest;
import com.sandesh.endpoints.API_Constants;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

public class TestReadBooking extends BaseTest {

    @Test()
    public void testReadBooking() {

        requestSpecification.basePath(API_Constants.CREATE_UPDATE_BOOKING_URL);
        
        response = RestAssured
            .given(requestSpecification)
                .header("Cache-Control", "Max-Age=86400")
                .config(RestAssuredConfig.newConfig().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    
    }

}
