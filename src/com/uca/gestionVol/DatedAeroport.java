package com.uca.gestionVol;

import java.time.ZonedDateTime;

public class DatedAeroport {

    private final Aeroport aeroport;
    private final ZonedDateTime dateTime;

    public DatedAeroport(Aeroport aeroport, ZonedDateTime dateTime) {
        this.aeroport = aeroport;
        this.dateTime = dateTime;
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

}
