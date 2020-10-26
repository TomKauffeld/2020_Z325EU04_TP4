package com.uca.gestionVol;


import java.time.Duration;
import java.time.ZonedDateTime;

public class Escale {
    private final Duration depart;
    private final Duration arrivee;
    private final Aeroport aeroport;

    public Escale(Duration depart, Duration arrivee, Aeroport aeroport) {
        if (depart.minus(arrivee).isNegative())
            throw new IllegalArgumentException("depart must be after arrivee");
        this.depart = depart;
        this.arrivee = arrivee;
        this.aeroport = aeroport;
    }

    public ZonedDateTime getArrivee(ZonedDateTime offset) {
        return offset.plus(arrivee);
    }

    public ZonedDateTime getDepart(ZonedDateTime offset) {
        return offset.plus(depart);
    }

    public Duration getDuree() {
        return depart.minus(arrivee);
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public boolean isBefore(Duration duration){
        return depart.minus(duration).isNegative();
    }

    public boolean isAfter(Escale escale) {
        return escale.arrivee.minus(depart).isNegative();
    }

    public boolean intersects(Escale escale) {
        return escale.arrivee.minus(depart).isNegative() && arrivee.minus(escale.depart).isNegative();
    }
}