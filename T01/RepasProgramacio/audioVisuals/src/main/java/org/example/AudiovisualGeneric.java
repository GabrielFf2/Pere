package org.example;

import org.example.model.Audiovisual;

import java.util.List;
import java.util.function.Predicate;

public class AudiovisualGeneric <T extends Audiovisual>{
    public List<T> ordenar(List<T> items) {
        return items.stream().sorted((a, b) -> {
            if(a.getTemps() > b.getTemps())
                return 1;
            else if (a.getTemps() < b.getTemps())
                return -1;
            else
                return 0;
        }).toList();
    }

    public List<T> findByDuradaMinima(List<T> items, int duradaMinima) {
        Predicate<T> duraMinim = n -> n.getTemps() >= duradaMinima;

        return items.stream().filter(duraMinim).toList();
    }

    public List<T> findByDuradaMaxima(List<T> items, int duradaMaxima) {
        Predicate<T> duraMaxim = n -> n.getTemps() <= duradaMaxima;

        return items.stream().filter(duraMaxim).toList();
    }
}
