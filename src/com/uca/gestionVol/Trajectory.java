package com.uca.gestionVol;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Trajectory {


    private final Aeroport depart;
    private final Aeroport arrivee;
    private final Duration duration;

    private final List<Escale> escales = new ArrayList<>();

    public Trajectory(Aeroport depart, Aeroport arrivee, Duration duration) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.duration = duration;
    }

    public Aeroport getArrivee() {
        return arrivee;
    }

    public Aeroport getDepart() {
        return depart;
    }

    public Duration getDuration() {
        return duration;
    }


    public void addEscale(Escale escale) {
        escales.add(validateAddingEscale(escale));
        escales.sort((a, b) -> a.isAfter(b) ? 1 : -1);
    }


    private Escale validateAddingEscale(Escale escale) {
        if (!(escale.isBefore(duration)))
            throw new IllegalArgumentException("escale must be during the flight");
        if (escales.stream().anyMatch(e -> e.intersects(escale)))
            throw new IllegalArgumentException("escale intersects another escale");
        if (escale.getAeroport().equals(depart))
            throw new IllegalArgumentException("escale is at starting aeroport");
        if (escale.getAeroport().equals(arrivee))
            throw new IllegalArgumentException("escale is at ending aeroport");
        if (escales.stream().anyMatch(e -> e.getAeroport().equals(escale.getAeroport())))
            throw new IllegalArgumentException("escale is at the same aeroport as another escale");
        return escale;
    }
}
