package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Empleadoo {
    String nombre;
    String departamento;
    int experiencia;
    double salario;

    Empleadoo(String nombre, String departamento, int experiencia, double salario) {
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

public class EjemploFilterComplejo {
    public static void main(String[] args) {
        List<Empleadoo> empleados = Arrays.asList(
                new Empleadoo("Juan", "TI", 4,  3000),
                new Empleadoo("Ana", "TI", 6, 4000),
                new Empleadoo("Beatriz", "Ventas", 8, 3500),
                new Empleadoo("Carlos", "TI", 10, 5000),
                new Empleadoo("Elena", "Ventas", 7, 6000)
        );

        // Filtrar empleados de TI con más de 5 años de experiencia
        Optional<Empleadoo> mejorPagado = empleados.stream()
                .filter(e -> e.departamento.equals("TI"))
                .filter(e -> e.experiencia > 5)
                .max((e1, e2) -> Double.compare(e1.salario, e2.salario));

        if (mejorPagado.isPresent()) {
            System.out.println("Empleado mejor pagado en TI con más de 5 años de experiencia: " + mejorPagado.get());
        } else {
            System.out.println("No se encontraron empleados que cumplan los criterios.");
        }
        // Salida: Empleado mejor pagado en TI con más de 5 años de experiencia: Carlos - TI (10 años, $5000.0)
    }
}
