package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploFilter {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filtrar los números que son mayores que 5
        List<Integer> filtrados = numeros.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());

        System.out.println(filtrados);  // Salida: [6, 7, 8, 9, 10]
    }
}

