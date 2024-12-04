package com.generic;

import com.generic.act.Bossa;
import com.generic.act.xocolatines;

public class Main {
    public static void main(String[] args) {    
        Bossa<xocolatines> bossa1 = new Bossa<>(10);
        xocolatines a = new xocolatines(10);
        xocolatines b = new xocolatines(5);
        xocolatines c = new xocolatines(7);
        bossa1.add(a);
        bossa1.add(b);
        bossa1.add(b);
        bossa1.add(a);
        bossa1.add(a);
        bossa1.add(c);
        bossa1.add(a);
        bossa1.add(a);
        bossa1.add(c);

        bossa1.remove(0);
        bossa1.printAll();
    }
}