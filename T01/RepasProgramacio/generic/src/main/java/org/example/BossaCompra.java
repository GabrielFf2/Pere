package org.example;

import org.example.model.Producte;

import java.util.*;
import java.util.function.Predicate;

public class BossaCompra<  T extends Producte> {
    private List<T> items;
    private int capacitat;

    public BossaCompra(int capacitat) {
        this.items = new ArrayList<T>();
        this.capacitat = capacitat;
    }

    public void afegir(T item) {
        if (this.items.size() >= this.capacitat)
            throw new RuntimeException("La bossa és plena");

        items.add(item);
    }

    public void treure(T item) {
        if (this.items.size() == 0)
            throw new NoSuchElementException("La bossa és buida, no es pot treure l'ítem");

        if(!this.items.contains(item))
            throw new NoSuchElementException("Item no està dins la bossa");

        this.items.remove(item);
    }

    public List<T> getItems(){
        return this.items;
    }

    public void llistar() {
        if (this.items.size() == 0) {
            System.out.println("---------------");
            System.out.println("La bossa és buida");
            System.out.println("---------------");
        } else {
            System.out.println("---------------");
            for (T item : this.items) {
                System.out.println(item);
            }
            System.out.println("---------------");
        }
    }

    public void llistarCars(double preu) {
        Predicate<Producte> mesCarsQue = (n) -> n.getPreu() >= preu;
        //Predicate<Producte> comencaPerM = n -> n.getNom().startsWith("M");

//        Predicate<Producte> combinat = mesCarsQue10.and(comencaPerM);
//
//        comencaPerM.test(new Producte("Mortadela", 32));

        List<T> producteCars = this.items.stream().filter(mesCarsQue).toList();

        for (T item : producteCars) {
            System.out.println(item);
        }

//        //equivalent
//        producteCars.forEach(n -> System.out.println(n));
//
//        //equivalent
//        producteCars.forEach(System.out::println);
//
//        // equivalent total
//        this.items.stream().filter(combinat).forEach(System.out::println);
    }


    public void llistarOrdenat(){
        this.items.stream().sorted().forEach(System.out::println);
    }


}
