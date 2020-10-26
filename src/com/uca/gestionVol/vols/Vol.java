package com.uca.gestionVol.vols;

import com.uca.gestionVol.*;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Vol {

    public enum StateEnum {
        OPEN,
        CLOSED
    }

    private StateEnum state = StateEnum.OPEN;
    private final VolNumber numero;
    private final Compagnie compagnie;

    private final Trajectory trajectory;
    private final ZonedDateTime depart;

    Vol(Compagnie compagnie, ZonedDateTime depart, Trajectory trajectory) {
        this.depart = depart;
        this.trajectory = trajectory;
        this.compagnie = compagnie;
        numero = VolNumber.generate(compagnie);
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public ZonedDateTime getDateArrivee() {
        return depart.plus(trajectory.getDuration());
    }

    public ZonedDateTime getDateDepart() {
        return depart;
    }

    public Duration getDuree() {
        return trajectory.getDuration();
    }

    public Aeroport getDepart() {
        return trajectory.getDepart();
    }

    public Aeroport getArrivee() {
        return trajectory.getArrivee();
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public VolNumber getNumero() {
        return numero;
    }

    public StateEnum getState() {
        return state;
    }

    void ouvrir() {
        if (state != StateEnum.CLOSED)
            throw new IllegalStateException("vol can only be opened when in CLOSED state");
        state = StateEnum.OPEN;
    }

    void fermer() {
        if (state != StateEnum.OPEN)
            throw new IllegalStateException("vol can only be closed when in OPEN state");
        state = StateEnum.CLOSED;
    }

}
