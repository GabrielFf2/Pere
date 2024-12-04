package org.example;

import java.util.Arrays;
import java.util.List;

class Empleado {
    String nombre;
    double salario;

    Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nombre + " ($" + salario + ")";
    }
}

public class EjemploComparatorAvanzado {
    public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Pedro", 3000),
                new Empleado("Ana", 4000),
                new Empleado("Beatriz", 3000),
                new Empleado("Carlos", 5000),
                new Empleado("Ana", 3000)
        );

        // Ordenar primero por salario ascendente y luego por nombre alfabético
        empleados.sort((e1, e2) -> {
            int resultado = Double.compare(e1.salario, e2.salario);
            if (resultado == 0) {
                resultado = e1.nombre.compareTo(e2.nombre);
            }
            return resultado;
        });

        System.out.println(empleados);
        // Salida: [Ana ($3000.0), Beatriz ($3000.0), Pedro ($3000.0), Ana ($4000.0), Carlos ($5000.0)]
    }
}
