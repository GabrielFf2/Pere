package org.example.compar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Personaaa implements Comparable<Personaaa> {
    String nombre;
    int edad;

    Personaaa(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Implementamos el método compareTo
    @Override
    public int compareTo(Personaaa otra) {
        return Integer.compare(this.edad, otra.edad);  // Ordenar por edad
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

public class EjemploComparableee {
    public static void main(String[] args) {
        List<Personaaa> personas = Arrays.asList(
                new Personaaa("Juan", 25),
                new Personaaa("Ana", 30),
                new Personaaa("Pedro", 20)
        );

        // Se usa el "orden natural" (definido por compareTo)
        Collections.sort(personas);

        personas.forEach(System.out::println);
        // Salida:
        // Pedro (20 años)
        // Juan (25 años)
        // Ana (30 años)
    }
}
