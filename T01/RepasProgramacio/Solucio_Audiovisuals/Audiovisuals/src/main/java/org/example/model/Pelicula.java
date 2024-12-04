package org.example.model;

public class Pelicula extends Audio implements IVideo{
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
