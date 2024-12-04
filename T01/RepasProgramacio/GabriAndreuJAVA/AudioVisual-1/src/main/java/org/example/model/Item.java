package org.example.model;

import java.util.Comparator;

public class Item implements Comparator<Item> {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compare(Item o1, Item o2) {
        int result = Integer.compare(o1.getId(), o2.getId());
        if (result == 0) {
            result = o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}
