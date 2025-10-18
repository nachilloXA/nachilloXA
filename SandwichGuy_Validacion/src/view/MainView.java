package view;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import controller.GameController;
import model.Carta;

public class MainView extends JFrame {
    private final JButton nuevaPartidaBtn, cargarPartidaBtn, robarCartaBtn, descartarCartaBtn, validarSandwichBtn;
    private final JPanel cajaPanel, manoPanel, mazoPanel, pozoPanel;
    private final List<Carta> cartasSeleccionadas = new ArrayList<>();
    private final GameController controller;

    public MainView(GameController controller) {
        this.controller = controller;
        setTitle("The Sandwich Guy");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        nuevaPartidaBtn = new JButton("Nueva Partida");
        cargarPartidaBtn = new JButton("Cargar Partida");
        topPanel.add(nuevaPartidaBtn);
        topPanel.add(cargarPartidaBtn);
        add(topPanel, BorderLayout.NORTH);

        cajaPanel = crearSeccion("Caja");
        manoPanel = crearSeccion("Mano");
        mazoPanel = crearSeccion("Mazo");
        pozoPanel = crearSeccion("Pozo");

        JPanel center = new JPanel(new GridLayout(2, 2));
        center.add(cajaPanel);
        center.add(manoPanel);
        center.add(mazoPanel);
        center.add(pozoPanel);
        add(center, BorderLayout.CENTER);

        robarCartaBtn = new JButton("Robar Carta");
        descartarCartaBtn = new JButton("Descartar Carta");
        validarSandwichBtn = new JButton("Validar Sándwich");

        JPanel actionPanel = new JPanel();
        actionPanel.add(robarCartaBtn);
        actionPanel.add(descartarCartaBtn);
        actionPanel.add(validarSandwichBtn);
        add(actionPanel, BorderLayout.SOUTH);

        nuevaPartidaBtn.addActionListener(e -> controller.crearPartida());
        cargarPartidaBtn.addActionListener(e -> controller.cargarPartida());
        robarCartaBtn.addActionListener(e -> controller.robarCarta());
        descartarCartaBtn.addActionListener(e -> controller.descartarCartaSeleccionada(getPrimeraSeleccionada()));
        validarSandwichBtn.addActionListener(e -> controller.validarSandwich(new ArrayList<>(cartasSeleccionadas)));
    }

    private JPanel crearSeccion(String titulo) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.setLayout(new FlowLayout());
        return panel;
    }

    public void mostrarMano(List<Carta> cartas) {
        manoPanel.removeAll();
        for (Carta c : cartas) {
            JButton cartaBtn = new JButton(c.toString());
            cartaBtn.addActionListener(e -> toggleSeleccion(cartaBtn, c));
            manoPanel.add(cartaBtn);
        }
        manoPanel.revalidate();
        manoPanel.repaint();
    }

    private void toggleSeleccion(JButton btn, Carta carta) {
        if (cartasSeleccionadas.contains(carta)) {
            cartasSeleccionadas.remove(carta);
            btn.setBackground(null);
        } else if (cartasSeleccionadas.size() < 3) {
            cartasSeleccionadas.add(carta);
            btn.setBackground(Color.YELLOW);
        }
    }

    private Carta getPrimeraSeleccionada() {
        return cartasSeleccionadas.isEmpty() ? null : cartasSeleccionadas.get(0);
    }

    public void limpiarSeleccion() {
        cartasSeleccionadas.clear();
        for (Component comp : manoPanel.getComponents()) {
            if (comp instanceof JButton) comp.setBackground(null);
        }
    }

    public JPanel getCajaPanel() { return cajaPanel; }
    public JPanel getManoPanel() { return manoPanel; }
    public JPanel getMazoPanel() { return mazoPanel; }
    public JPanel getPozoPanel() { return pozoPanel; }

	
}
