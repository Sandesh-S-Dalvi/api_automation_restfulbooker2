package com.sandesh.modules;

import com.google.gson.Gson;
import com.sandesh.pojos.Auth;
import com.sandesh.pojos.Booking;
import com.sandesh.pojos.BookingDates;
import com.sandesh.pojos.BookingResponse;
import com.sandesh.pojos.TokenResponse;

public class PayloadBuilder {
    
    Gson gson;

    public String createPayloadBookingAsString(String firstName, String lastName, Integer totalPrice, boolean depositPaid, BookingDates bookingDates, String additionalNeeds) {
        
        Booking booking = new Booking(firstName,lastName,totalPrice,depositPaid,bookingDates,additionalNeeds);
        // Booking booking = new Booking();
        // booking.setFirstname("Pramod");
        // booking.setLastname("Dutta");
        // booking.setTotalprice(113);
        // booking.setDepositpaid(true);
        // booking.setBookingdates(new BookingDates("2024-02-01", "2024-02-01"));
        // booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // Java Object -> JSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        return jsonStringBooking;


    }

    // Converting the String to the JAVA Object
    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public String setAuthPayload() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        
        gson = new Gson();
        
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        
        return jsonPayloadString;
    }

    public String getTokenFromJSON(String asString) {

        gson = new Gson();

        TokenResponse tokenResponse = gson.fromJson(asString, com.sandesh.pojos.TokenResponse.class);
        System.out.println("Token is -> " + tokenResponse.getToken().toString());

        return tokenResponse.getToken().toString();

    }

}