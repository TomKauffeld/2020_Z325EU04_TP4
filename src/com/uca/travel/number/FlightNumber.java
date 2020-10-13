package com.uca.travel.number;

public final class FlightNumber {

    private final String number;

    FlightNumber(String number){
        this.number = number;
    }


    @Override
    public String toString() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        return o instanceof FlightNumber && equals((FlightNumber)o);
    }

    public boolean equals(FlightNumber fn) {
        return fn != null && number.equals(fn.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
