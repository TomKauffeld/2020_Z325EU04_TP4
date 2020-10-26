package com.uca.gestionReservations.reservations;

import com.uca.gestionReservations.Contact;
import com.uca.gestionReservations.Paiement;
import com.uca.gestionReservations.Passager;
import com.uca.gestionVol.vols.Vol;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

    private final String nom;
    private final ClientReference reference;
    private final Paiement paiement;
    private final Contact contact;

    private final List<Reservation> reservations = new ArrayList<>();

    public Client(String nom, ClientReference reference, Paiement paiement, Contact contact) {
        this.nom = nom;
        this.reference = reference;
        this.paiement = paiement;
        this.contact = contact;
    }

    public String getNom() {
        return nom;
    }

    public ClientReference getReference() {
        return reference;
    }

    public Contact getContact() {
        return contact;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public Iterator<Reservation> getReservations() {
        return reservations.iterator();
    }

    public Reservation makeReservation(Passager passager, ZonedDateTime date, Vol vol) {
        Reservation reservation = new Reservation(this, passager, date, vol);
        reservations.add(reservation);
        return reservation;
    }
}
