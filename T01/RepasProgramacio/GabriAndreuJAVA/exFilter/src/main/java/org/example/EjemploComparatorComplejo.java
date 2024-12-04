package org.example;

import java.util.Arrays;
import java.util.List;

class Empleat {
    String nombre;
    String departamento;
    int experiencia;
    double salario;

    Empleat(String nombre, String departamento, int experiencia, double salario) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.experiencia = experiencia;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nombre + " - " + departamento + " (" + experiencia + " años, $" + salario + ")";
    }
}

public class EjemploComparatorComplejo {
    public static void main(String[] args) {
        List<Empleat> empleados = Arrays.asList(
                new Empleat("Juan", "TI", 4, 3000),
                new Empleat("Ana", "TI", 6, 4000),
                new Empleat("Beatriz", "Ventas", 8, 3500),
                new Empleat("Carlos", "TI", 10, 5000),
                new Empleat("Elena", "Ventas", 7, 6000)
        );

        // Ordenar por departamento, luego por experiencia y por salario descendente
        empleados.sort((e1, e2) -> {
            int result = e1.departamento.compareTo(e2.departamento);
            if (result == 0) {
                result = Integer.compare(e2.experiencia, e1.experiencia); // Orden descendente de experiencia
                if (result == 0) {
                    result = Double.compare(e2.salario, e1.salario); // Orden descendente de salario
                }
            }
            return result;
        });

        empleados.forEach(System.out::println);
        // Salida:
        // Carlos - TI (10 años, $5000.0)
        // Ana - TI (6 años, $4000.0)
        // Juan - TI (4 años, $3000.0)
        // Elena - Ventas (7 años, $6000.0)
        // Beatriz - Ventas (8 años, $3500.0)
    }
}
