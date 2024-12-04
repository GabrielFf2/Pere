package org.example.model;

public class Pelicula extends AudioVisual implements IVideo {

    private String titol;

    public Pelicula(String titol) {
        this.titol = titol;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    @Override
    public final int[] qualitat(int qualitat) {
        return new int[0];
    }

    @Override
    public void calcularFormatSortida(int fps) {

    }

    @Override
    public int qualificar() {
        return 0;
    }
}
