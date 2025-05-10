package com.sandesh.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingDates {

    @SerializedName("checkin")
    @Expose
    private String checkin;
    @SerializedName("checkout")
    @Expose
    private String checkout;

    /**
     * No args constructor for use in serialization
     *
     */
    public BookingDates() {
    }

    public BookingDates(String checkin, String checkout) {
        super();
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

}
