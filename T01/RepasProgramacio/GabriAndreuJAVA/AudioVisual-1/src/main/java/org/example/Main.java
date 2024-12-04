package org.example;

import org.example.model.Canco;
import org.example.model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface Operacion {
    int operation(int c, int s);
}

public class Main {
    public static void main(String[] args) throws IOException {
        AudioVisualServiceExternalImpl abv = new AudioVisualServiceExternalImpl();
        AudiovisualGenerica<Canco> hola = new AudiovisualGenerica<Canco>();
        abv.findAllCancons().forEach(System.out::println);
        List<Canco> a = abv.findAllCancons();
        hola.findByDuradaMaxima(a, 184).stream().forEach(System.out::println);
//        Operacion suma = (q, w) -> q + w;
//        List<Item> b = new ArrayList<>();
//        b.add(new Item(10, "andreu"));
//        b.add(new Item(3, "gabi"));
//        b.add(new Item(2, "tomeu"));
//        b.add(new Item(9, "andreu"));
//        b.add(new Item(5, "sergio"));
//        b.add(new Item(10, "toni"));
//        b.stream().sorted((o1, o2) -> {
//            int result = Integer.compare(o2.getId(), o1.getId());
//            if (result == 0) {
//                result = o2.getName().compareTo(o1.getName());
//            }
//            return result;
//        }).forEach(System.out::println);
    }
}