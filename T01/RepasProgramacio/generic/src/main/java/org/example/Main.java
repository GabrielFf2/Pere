package org.example;

import org.example.model.Cotxe;
import org.example.model.Detergent;
import org.example.model.Macarrons;

import javax.crypto.Mac;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        BossaCompra<Macarrons> bossaMacarrons = new BossaCompra<>(7);

        Macarrons mac1 = new Macarrons("Macarronis molonis", 12.5, 232, 12);
        Macarrons mac2 = new Macarrons("Macarrons Buitoni", 2, 100, 23);
        Macarrons mac3 = new Macarrons("Buitoni Macarroni", 2, 100, 23);
        Macarrons mac4 = new Macarrons("Doctor Oedker", 20, 232, 12);
        Macarrons mac5 = new Macarrons("Buitoni Macarroni", 200, 100, 23);
        Macarrons mac6 = new Macarrons("Tratoria", 34, 100, 23);

        try {
            bossaMacarrons.afegir(mac1);
            bossaMacarrons.afegir(mac2);
            bossaMacarrons.afegir(mac3);
            bossaMacarrons.afegir(mac4);
            bossaMacarrons.afegir(mac5);
            bossaMacarrons.afegir(mac6);
        } catch (Exception e) {
            System.out.println("Bossa plena");
        }

        bossaMacarrons.llistarCars(10);

        //bossaMacarrons.getItems().stream().map(n -> n.getNom().toUpperCase()).forEach(n -> System.out.println(n));

//        bossaMacarrons.llistarOrdenat();
//
//        bossaMacarrons.llistar();
//
//        bossaMacarrons.treure(mac2);
//
//        bossaMacarrons.llistar();

        ////////////////////

        BossaCompra<Detergent> bossaDetergent = new BossaCompra<>(3);

        Detergent det1 = new Detergent("Dixan", 12, Detergent.Tipus.GEL);
        Detergent det2 = new Detergent("Vernel", 23, Detergent.Tipus.POLS);
        Detergent det3 = new Detergent("GreenWorld", 120, Detergent.Tipus.SEC);

        bossaDetergent.afegir(det1);
        bossaDetergent.afegir(det2);
        bossaDetergent.afegir(det3);

        bossaDetergent.llistar();

        bossaDetergent.treure(det1);

        bossaDetergent.llistar();



//        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
//
//        Predicate<Integer> mesGransQue3 = n -> n > 3;
//
//        List<Integer> numerosMultiplicats = numeros.stream().filter(mesGransQue3).map(n -> n * 2).toList();
//        numerosMultiplicats.forEach(n -> System.out.println(n));

//        Predicate<Macarrons> mesCarsQue10 = mac -> mac.getPreu() > 10;
//
//        bossaMacarrons.getItems().stream().filter(mesCarsQue10).sorted().map(mac-> mac.getNom()).forEach(mac-> System.out.println(mac.toUpperCase()));
    }
}