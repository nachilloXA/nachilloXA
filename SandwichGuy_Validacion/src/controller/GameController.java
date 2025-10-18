package controller;

import model.*;
import view.MainView;
import javax.swing.*;
import java.util.List;

public class GameController {
    private final MainView view;
    private Caja caja;
    private Mazo mazo;
    private Mano mano;
    private Pozo pozo;

    public GameController() {
        view = new MainView(this);
        view.setVisible(true);
    }

    public void crearPartida() {
        caja = new Caja();
        mazo = new Mazo(caja.getCartas());
        mano = new Mano();
        pozo = new Pozo();
        mostrarCaja();
        mostrarMano();
    }

    private void mostrarCaja() {
        JPanel panel = view.getCajaPanel();
        panel.removeAll();
        for (Carta c : caja.getCartas()) panel.add(new JLabel(c.toString()));
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarMano() { view.mostrarMano(mano.getCartas()); }

    private void mostrarPozo() {
        JPanel panel = view.getPozoPanel();
        panel.removeAll();
        for (Carta c : pozo.getCartas()) panel.add(new JLabel(c.toString()));
        panel.revalidate();
        panel.repaint();
    }

    public void robarCarta() {
        if (mazo == null || mazo.estaVacio()) {
            JOptionPane.showMessageDialog(null, "El mazo está vacío.");
            return;
        }
        Carta robada = mazo.sacarCarta();
        if (robada != null) {
            mano.agregarCarta(robada);
            mostrarMano();
        }
    }

    public void descartarCartaSeleccionada(Carta c) {
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una carta para descartar.");
            return;
        }
        mano.removerCarta(c);
        pozo.descartar(c);
        view.limpiarSeleccion();
        mostrarMano();
        mostrarPozo();
    }

    public void validarSandwich(List<Carta> seleccionadas) {
        if (seleccionadas.size() != 3) {
            JOptionPane.showMessageDialog(null, "Seleccione exactamente 3 cartas.");
            return;
        }

        boolean valido = SandwichValidator.esSandwich(seleccionadas);
        if (valido) {
            for (Carta c : seleccionadas) {
                mano.removerCarta(c);
                pozo.descartar(c);
            }
            JOptionPane.showMessageDialog(null, "¡Sándwich válido! 🥪 Cartas enviadas al pozo.");
        } else {
            JOptionPane.showMessageDialog(null, "No es un sándwich válido ❌");
        }

        view.limpiarSeleccion();
        mostrarMano();
        mostrarPozo();
    }

    public void cargarPartida() { JOptionPane.showMessageDialog(null, "Funcionalidad de carga no implementada aún."); }
}
