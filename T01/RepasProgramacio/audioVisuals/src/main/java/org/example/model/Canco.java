package org.example.model;

public final class Canco extends Audio{
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
        return String.format("La cançó %c de l'artista %a té copyright", nom, artista);
    }

    @Override
    public String toString(){
        return this.nom + " - " + this.artista + " - " + this.getTemps() + " segons";
    }
}