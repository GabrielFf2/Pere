package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploMap {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Multiplicar cada número por 2
        List<Integer> duplicados = numeros.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println(duplicados);  // Salida: [2, 4, 6, 8, 10]
    }
}
