package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producte implements Comparable<Producte>{
    protected String nom;
    protected double preu;

    @Override
    public int compareTo(Producte o) {
        int retorn = Double.compare(this.preu, o.getPreu());
        if (retorn == 0) {
            retorn = this.nom.compareTo(o.getNom());
        }

        return retorn;
    }
}
