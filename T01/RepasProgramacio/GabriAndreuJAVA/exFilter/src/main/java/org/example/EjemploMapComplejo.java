package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Epleado {
    String nombre;
    int experiencia;
    double salario;

    Epleado(String nombre, int experiencia, double salario) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.salario = salario;
    }

    public double calcularAumento() {
        return salario + (salario * (0.05 * experiencia));
    }

    @Override
    public String toString() {
        return nombre + " - " + experiencia + " años: $" + calcularAumento();
    }
}

public class EjemploMapComplejo {
    public static void main(String[] args) {
        List<Epleado> empleados = Arrays.asList(
                new Epleado("Juan", 4, 3000),
                new Epleado("Ana", 6, 4000),
                new Epleado("Beatriz", 8, 3500),
                new Epleado("Carlos", 10, 5000)
        );

        // Generar un informe con los empleados y sus nuevos salarios tras calcular el aumento
        List<String> informe = empleados.stream()
                .map(e -> e.nombre + " - Nuevo salario: $" + e.calcularAumento())
                .collect(Collectors.toList());

        informe.forEach(System.out::println);
        // Salida:
        // Juan - Nuevo salario: $3600.0
        // Ana - Nuevo salario: $5200.0
        // Beatriz - Nuevo salario: $4900.0
        // Carlos - Nuevo salario: $7500.0
    }
}
