package com.sandesh.assertions;

import static org.testng.Assert.assertEquals;

import com.sandesh.pojos.BookingDates;

import static org.assertj.core.api.Assertions.*;

public class AssertActions {

    public void verifyResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(Integer actual, Integer expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(Boolean actual, Boolean expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(BookingDates actual, BookingDates expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyStatusCode(int actual, int expected) {
        assertEquals(actual, expected);
    }

    public void verifyStringKey(String keyExpect, String keyActual) {
        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotBlank();
        assertThat(keyExpect).isEqualTo(keyActual);

    }

      public void verifyStringKeyNotNull(Integer keyExpect){
        // AssertJ
        assertThat(keyExpect).isNotNull();
    }

    public void verifyStringKeyNotNull(String keyExpect){
        // AssertJ
        assertThat(keyExpect).isNotNull();
    }
    
}
