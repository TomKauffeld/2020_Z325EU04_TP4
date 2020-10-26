package com.uca.gestionVol.vols;

import com.uca.gestionVol.Trajectory;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Compagnie {
    private final String nom;
    private final List<Vol> propose = new ArrayList<>();

    public Compagnie(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Vol newVol(ZonedDateTime depart, Trajectory trajectory) {
        Vol vol = new Vol(this, depart, trajectory);
        propose.add(vol);
        return vol;
    }

    public Iterator<Vol> proposeVols() {
        return propose.iterator();
    }
}
