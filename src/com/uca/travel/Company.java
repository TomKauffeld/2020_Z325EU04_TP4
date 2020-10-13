package com.uca.travel;

public final class Company {

    private final String code;
    private final String name;

    public Company(String code, String name) throws IllegalArgumentException {
        this.code = validateCode(code);
        this.name = validateName(name);
    }


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    public Flight CreateFlight(){
        return new Flight(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        return o instanceof Company && equals((Company)o);
    }

    public boolean equals(Company c) {
        return c != null && code.equals(c.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    private static String validateCode(String code) throws IllegalArgumentException{
        if (code == null)
            throw new IllegalArgumentException("code cannot be null");
        return code;
    }

    private static String validateName(String name) throws IllegalArgumentException{
        if (name == null)
            throw new IllegalArgumentException("name cannot be null");
        return name;
    }
}
