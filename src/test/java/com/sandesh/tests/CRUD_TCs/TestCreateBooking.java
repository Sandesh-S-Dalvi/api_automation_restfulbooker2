package com.sandesh.tests.CRUD_TCs;

import org.testng.annotations.Test;

import com.sandesh.base.BaseTest;
import com.sandesh.endpoints.API_Constants;
import com.sandesh.pojos.BookingResponse;

import io.restassured.RestAssured;

public class TestCreateBooking extends BaseTest {
    
    // Test Create Booking
        // Create Token.
        // Send Post Request with Token and PayLoad.
        // Read/Parse Reponse.
        // Assert Response.

    @Test()
    public void testCreateBooking() {

        requestSpecification.basePath(API_Constants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
            .when()
                .body(payloadBuilder.createPayloadBookingAsString())
                .post();

        validatableResponse = response.then().log().all();
        System.out.println(validatableResponse);
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadBuilder.bookingResponseJava(response.asString());

        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Pramod");
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());

    }

}
