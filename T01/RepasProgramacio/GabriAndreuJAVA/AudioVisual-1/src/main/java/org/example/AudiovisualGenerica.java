package org.example;

import org.example.model.AudioVisual;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AudiovisualGenerica<T extends AudioVisual> {

    public List<T> findByDuradaMinima(List<T> lista, int duradaMinima) {
        Predicate<T> minimo = x -> x.getTemps() > duradaMinima;
        return lista.stream().filter(minimo).toList();
    }

    public List<T> findByDuradaMaxima(List<T> lista, int duradaMaxima) {
        Predicate<T> maxima = x -> x.getTemps() <= duradaMaxima;
        return lista.stream().filter(maxima).toList();
    }

}
