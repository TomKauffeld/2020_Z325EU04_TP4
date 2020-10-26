package com.uca.gestionVol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Aeroport {

    private final String nom;
    private final Set<Ville> dessert = new HashSet<>();

    public Aeroport(String nom, Ville ville, Ville... villes) {
        this.nom = nom;
        this.dessert.add(ville);
        this.dessert.addAll(Arrays.asList(villes));
    }

    public String getNom() {
        return nom;
    }

    public boolean addVille(Ville ville) {
        return dessert.add(ville);
    }

    @Override
    public String toString() {
        return getNom();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Aeroport && equals((Aeroport)o);
    }

    public boolean equals(Aeroport a) {
        return a != null && nom.equals(a.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
