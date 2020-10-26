package com.uca.gestionReservations;

public class Passager {

    private final String nom;

    public Passager(String nom) {
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
        return o instanceof Passager && equals((Passager)o);
    }

    public boolean equals(Passager p) {
        return p != null && nom.equals(p.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
