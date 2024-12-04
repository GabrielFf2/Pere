package com.generic.act;

import java.util.Comparator;

public class xocolatines implements Comparable<xocolatines> {
    private int preu;
    private String tipusXoco = "Negre";

    public xocolatines(int a) {
        this.preu = a;
    }

    public String toString() {
        return getClass().getName() + " - Preu: " + preu + " - TipusXoco: " + tipusXoco;
    }

    @Override
    public int compareTo(xocolatines o) {
        int result = Integer.compare(o.preu, this.preu);
        if (result == 0) {
            result = this.tipusXoco.compareTo(o.tipusXoco);
        }
        return result;
    }

}
