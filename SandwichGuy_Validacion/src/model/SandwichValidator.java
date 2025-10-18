package model;

import java.util.List;
import java.util.Collections;

public class SandwichValidator {

    public static boolean esSandwich(List<Carta> tripleta) {
        if (tripleta.size() != 3) return false;

        // Ordenar cartas por número
        Collections.sort(tripleta, (a,b) -> Integer.compare(a.getNumero(), b.getNumero()));

        int v1 = tripleta.get(0).getNumero();
        int v2 = tripleta.get(1).getNumero();
        int v3 = tripleta.get(2).getNumero();

        // Verificación normal
        if (Math.abs(v1 - v2) == Math.abs(v2 - v3)) return true;

        // Con vuelta (circular K->A->2)
        int d1 = distanciaCircular(v1, v2);
        int d2 = distanciaCircular(v2, v3);

        return d1 == d2;
    }

    private static int distanciaCircular(int a, int b) {
        int d1 = Math.abs(a - b);
        int d2 = 13 - d1;
        return Math.min(d1, d2);
    }
}
