package org.example.model;

public class Macarrons extends Producte{
    private int calories;
    private int tempsCoccio;

    public Macarrons(String nom, double preu, int calories, int tempsCoccio) {
        super(nom, preu);
        this.calories = calories;
        this.tempsCoccio = tempsCoccio;
    }

    @Override
    public String toString() {
        return "Macarrons{" +
                ", nom='" + nom + '\'' +
                ", preu=" + preu +
                ", calories=" + calories +
                ", tempsCoccio=" + tempsCoccio +
                '}';
    }
}
