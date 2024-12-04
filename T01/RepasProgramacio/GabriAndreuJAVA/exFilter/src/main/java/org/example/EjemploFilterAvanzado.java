package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Persona {
    String nombre;
    int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

public class EjemploFilterAvanzado {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 25),
                new Persona("Ana", 35),
                new Persona("Javier", 40),
                new Persona("Beatriz", 50),
                new Persona("José", 33)
        );

        // Filtrar personas que tengan más de 30 años y cuyo nombre empiece con "J"
        List<Persona> filtradas = personas.stream()
                .filter(p -> p.edad > 30 && p.nombre.startsWith("J"))
                .collect(Collectors.toList());

        System.out.println(filtradas);  // Salida: [Javier (40 años), José (33 años)]
    }
}
