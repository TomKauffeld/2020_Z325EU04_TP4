package com.uca.gestionReservations.reservations;

import com.uca.gestionReservations.Passager;
import com.uca.gestionVol.vols.Vol;

import java.time.ZonedDateTime;

public class Reservation {

    public enum StateEnum {
        PENDING,
        PAID,
        CONFIRMED,
        CANCELED
    }

    private final ReservationNumber numero;
    private final Client client;
    private final Passager concerne;
    private final ZonedDateTime date;
    private final Vol vol;
    private StateEnum state = StateEnum.PENDING;

    Reservation(Client client, Passager passager, ZonedDateTime date, Vol vol) {
        if (date.isAfter(vol.getDateDepart()))
            throw new IllegalArgumentException("cannot make a reservation after the flight has departed");
        if (vol.getState() != Vol.StateEnum.OPEN)
            throw new IllegalStateException("vol is not OPEN for reservations");
        concerne = passager;
        this.date = date;
        this.vol = vol;
        this.client = client;
        numero = ReservationNumber.generate(vol);
    }

    public Passager getConcerne() {
        return concerne;
    }

    public Vol getVol() {
        return vol;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public StateEnum getState() {
        return state;
    }

    public ReservationNumber getNumero() {
        return numero;
    }

    public void confimer() {
        if (state != StateEnum.PAID)
            throw new IllegalStateException("can only confirm when in PAID state");
        state = StateEnum.CONFIRMED;
    }

    public void annuler() {
        state = StateEnum.CANCELED;
    }

}
