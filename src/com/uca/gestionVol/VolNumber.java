package com.uca.gestionVol;

import com.uca.gestionVol.vols.Compagnie;

public class VolNumber {
    private final String value;

    public VolNumber(String value){
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }

    private static int next = 1;
    public static VolNumber generate(Compagnie compagnie){
        return new VolNumber(compagnie.getNom().substring(0, 3) + "-" + (next++));
    }
}
