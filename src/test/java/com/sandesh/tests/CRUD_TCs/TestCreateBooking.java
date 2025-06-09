package com.sandesh.tests.CRUD_TCs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sandesh.base.BaseTest;
import com.sandesh.endpoints.API_Constants;
import com.sandesh.pojos.BookingDates;
import com.sandesh.pojos.BookingResponse;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

public class TestCreateBooking extends BaseTest {
    
    // Test Create Booking
        // Create Token.
        // Send Post Request with Token and PayLoad.
        // Read/Parse Reponse.
        // Assert Response.

    @DataProvider (name = "dp")
    public Object[][] dpMethod () {

        return new Object[][] {

            {"Pramod","Dutta",100,true,"2025-02-01","2025-02-02","Breakfast"},
            {"Sandesh",10000,1000,false,"2025-02-01","002-01","Breakfast"}

        };

    }
    

    @Test(dataProvider = "dp")
    public void testCreateBooking(String firstName, String lastName, Integer totalPrice, boolean depositPaid, String checkinDate, String checkoutDate, String additionalNeeds) {

        requestSpecification.basePath(API_Constants.CREATE_UPDATE_BOOKING_URL);

        BookingDates bookingDates;
        response = RestAssured
            .given(requestSpecification)
                .config(RestAssuredConfig.newConfig().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
            .when()
                .body(payloadBuilder.createPayloadBookingAsString(firstName,
                    lastName,
                    totalPrice,
                    depositPaid,
                    bookingDates = new BookingDates(checkinDate,checkoutDate),
                    additionalNeeds))
                .post();

        validatableResponse = response.then().log().all();
        // System.out.println(validatableResponse);
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadBuilder.bookingResponseJava(response.asString());

        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), firstName);
        assertActions.verifyStringKey(bookingResponse.getBooking().getLastname(), lastName);
        assertActions.verifyResponseBody(bookingResponse.getBooking().getTotalprice(), totalPrice, "Total Price mismatch");
        assertActions.verifyResponseBody(bookingResponse.getBooking().getDepositpaid(), depositPaid, "Deposit paid mismatch");
        assertActions.verifyResponseBody(bookingResponse.getBooking().getBookingdates(), bookingDates, "Booking Dates mismatch");
        assertActions.verifyResponseBody(bookingResponse.getBooking().getAdditionalneeds(), additionalNeeds, "Additional Needs mismatch");

    }

}
