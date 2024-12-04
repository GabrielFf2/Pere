package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EjemploComparator {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Juan", "Ana", "Pedro", "Beatriz", "Lucía");

        // Ordenar alfabéticamente usando Comparator
        Collections.sort(nombres, Comparator.naturalOrder());
        System.out.println(nombres);  // Salida: [Ana, Beatriz, Juan, Lucía, Pedro]

        // Ordenar de manera inversa
        Collections.sort(nombres, Comparator.reverseOrder());
        System.out.println(nombres);  // Salida: [Pedro, Lucía, Juan, Beatriz, Ana]
    }
}
