package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Emplead {
    String nombre;
    double salario;

    Emplead(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }
}

public class EjemploMapAvanzado {
    public static void main(String[] args) {
        List<Emplead> empleados = Arrays.asList(
                new Emplead("Juan", 2500),
                new Emplead("Ana", 4000),
                new Emplead("Beatriz", 3500),
                new Emplead("Carlos", 5000)
        );

        // Generar una lista de nombres en mayúsculas de los empleados que ganan más de $3000
        List<String> nombres = empleados.stream()
                .filter(e -> e.getSalario() > 3000)
                .map(e -> e.getNombre().toUpperCase())
                .collect(Collectors.toList());

        System.out.println(nombres);  // Salida: [ANA, BEATRIZ, CARLOS]
    }
}

