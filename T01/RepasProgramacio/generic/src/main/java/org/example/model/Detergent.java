package org.example.model;


public class Detergent extends Producte{
    private Tipus tipus;

    public Detergent(String nom, double preu, Tipus tipus) {
        super(nom, preu);
        this.tipus = tipus;
    }

    public enum Tipus {
        POLS, GEL, SEC
    }
}


