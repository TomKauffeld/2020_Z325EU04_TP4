package com.uca.gestionReservations;

public class Contact {
    private final String phoneNumber;

    public Contact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "TEL: " + phoneNumber;
    }
}
