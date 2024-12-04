package org.example.model;

public final class Canco extends Audio {
    private String nom;
    private String artista;

    public Canco(String nom, String artista) {
        this.nom = nom;
        this.artista = artista;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String copyright() {
        return String.format("La canco %a del artista %b te copyright", this.getNom(), this.getArtista());
    }

    public String toString() {
        return String.format("Canco [nom=%s, artista=%s, temps=%s]", nom, artista, getTemps());
    }
}
