package org.example.compar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Persona implements Comparable<Persona> {
    String nombre;
    int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Implementamos el método compareTo
    @Override
    public int compareTo(Persona otra) {
        return Integer.compare(this.edad, otra.edad);  // Ordenar por edad
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

public class EjemploComparable {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 25),
                new Persona("Ana", 30),
                new Persona("Pedro", 20)
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





/*
Comparable:

Se implementa dentro de la clase que quieres ordenar.
Define un "orden natural" para los objetos.
Solo puedes tener un criterio de ordenación en la clase.
Implementa el método compareTo().
Comparator:

Se implementa fuera de la clase (como una clase separada o una lambda).
Permite definir múltiples criterios de ordenación.
Útil cuando no puedes o no quieres modificar la clase original.
Implementa el método compare().*/
