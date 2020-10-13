package com.uca.travel;

import com.uca.travel.number.FlightNumber;
import com.uca.travel.number.FlightNumberGenerator;

public final class Flight {

    private final FlightNumber number;
    private final Company company;

    Flight(Company company) throws IllegalArgumentException {
        number = FlightNumberGenerator.Generate(company);
        this.company = company;
    }

}
