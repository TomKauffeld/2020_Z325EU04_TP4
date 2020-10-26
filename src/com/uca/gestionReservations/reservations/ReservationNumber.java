package com.uca.gestionReservations.reservations;

import com.uca.gestionVol.vols.Vol;

public class ReservationNumber {

    private final String value;

    private ReservationNumber(String value){
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }

    private static int next = 1;
    public static ReservationNumber generate(Vol vol){
        return new ReservationNumber(vol.getNumero().toString() + "-" + (next++));
    }

}
