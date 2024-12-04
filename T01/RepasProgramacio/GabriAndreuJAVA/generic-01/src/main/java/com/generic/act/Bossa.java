package com.generic.act;

import java.util.ArrayList;

public class Bossa<T> {
    ArrayList<T> list = new ArrayList<T>();
    private int maxList;

    public Bossa(int max) {
        this.maxList = max;
    }

    public void add(T item) {
        if (list.size() < maxList) {
            list.add(item);
        } else {
            throw new RuntimeException("Tamaño Maximo");
        }
    }

    public void remove(int id) {
        if (list.size() > 0) {
            list.remove(id);
        } else {
            throw new RuntimeException("No hay nada");
        }
    }

    public void printAll() {
        list = new ArrayList<>(list.stream().sorted().toList());
        list.forEach(item -> {
            System.out.println(item.toString());
        });
    }
}
