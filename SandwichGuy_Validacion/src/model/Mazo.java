package model;

import java.util.Collections;
import java.util.Stack;
import java.util.List;

public class Mazo {
    private final Stack<Carta> pila;

    public Mazo(List<Carta> cartas) {
        pila = new Stack<>();
        pila.addAll(cartas);
        Collections.shuffle(pila);
    }

    public Carta sacarCarta() { return pila.isEmpty() ? null : pila.pop(); }
    public boolean estaVacio() { return pila.isEmpty(); }
}
