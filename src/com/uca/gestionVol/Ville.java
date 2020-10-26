package com.uca.gestionVol;

public class Ville {
    private final String nom;

    public Ville(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return getNom();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Ville && equals((Ville)o);
    }

    public boolean equals(Ville v) {
        return v != null && nom.equals(v.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
