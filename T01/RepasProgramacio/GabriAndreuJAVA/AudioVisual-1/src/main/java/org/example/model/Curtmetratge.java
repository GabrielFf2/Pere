package org.example.model;

public class Curtmetratge extends Pelicula {
    private boolean isTrailer;

    public Curtmetratge(String titol, boolean isTrailer) {
        super(titol);
        this.isTrailer = isTrailer;
    }

    public boolean isTrailer() {
        return isTrailer;
    }

    public void setTrailer(boolean trailer) {
        isTrailer = trailer;
    }
}
