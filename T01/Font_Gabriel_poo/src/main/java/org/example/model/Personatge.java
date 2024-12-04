package org.example.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class Personatge extends ElementApi {

    private Estat estat;
    private String especie;
    private String tipus;
    private Genere genere;


    public Personatge(Estat estat, String especie, String tipus, Genere genere) {
        this.estat = estat;
        this.especie = especie;
        this.tipus = tipus;
        this.genere = genere;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
