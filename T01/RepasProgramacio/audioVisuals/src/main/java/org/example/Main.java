package org.example;

import org.example.model.Canco;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        IAudioVisual audioVisualService = new AudioVisualServiceInternImpl();
        try {
//            List<Canco> canconsLliures = audiovisualService.findAllCanconsLliures();
//            System.out.println(canconsLliures);

//            System.out.println("-----------------------");
//            System.out.println("-----------------------");
//
            List<Canco> cancons = audioVisualService.findAllCancons();
            List<Canco> canconsLliures = audioVisualService.findAllCanconsLliures();

            AudiovisualGeneric<Canco> canconsUtil = new AudiovisualGeneric<>();
//            System.out.println(canconsUtil.ordenar(cancons));
            canconsUtil.ordenar(cancons).forEach(System.out::println);

            System.out.println("-----------------------");
            System.out.println("-----------------------");

            canconsUtil.findByDuradaMinima(cancons, 310).forEach(System.out::println);

            System.out.println("-----------------------");
            System.out.println("-----------------------");

            canconsUtil.findByDuradaMaxima(cancons, 230).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error del proveidor de recursos audiovisuals");
            throw new RuntimeException(e);
        }
    }
}