package org.example;

import org.example.model.ElementApi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class InfoWeb<T extends ElementApi> {

    public List<String> mesNous(List<T> list) {
        return list.stream().sorted().map(n -> n.getName()).toList();
    }

    public List<T> rockRick(List<T> list) {
        Predicate<T> isRick = n-> n.getName().toLowerCase().contains("rick");
        return list.stream().filter(isRick).toList();
    }

}
