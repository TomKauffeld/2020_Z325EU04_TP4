package com.uca.travel.number;

import com.uca.travel.Company;

import java.util.HashMap;
import java.util.Map;

public final class FlightNumberGenerator {

    private static final Map<Company, FlightNumberGenerator> flightNumberGenerators = new HashMap<>();

    private final Company company;
    private int nbFlights = 0;

    private FlightNumberGenerator(Company company){
        this.company = company;
        flightNumberGenerators.putIfAbsent(company, this);
    }

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(" -> new")
    public FlightNumber Generate(){
        return new FlightNumber(company.getCode() + (++nbFlights));
    }

    public static FlightNumberGenerator GetInstance(Company company) throws IllegalArgumentException{
        if (company == null)
            throw new IllegalArgumentException("company cannot be null");
        if (!flightNumberGenerators.containsKey(company))
            return new FlightNumberGenerator(company);
        return flightNumberGenerators.get(company);
    }

    @org.jetbrains.annotations.NotNull
    public static FlightNumber Generate(Company company) throws IllegalArgumentException {
        if (company == null)
            throw new IllegalArgumentException("company cannot be null");
        return GetInstance(company).Generate();
    }
}
