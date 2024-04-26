package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelJuegoIzquierda extends JPanel {
    private int circulosMaximos;
    private int circulosActuales;

    public PanelJuegoIzquierda(int circulosMaximos, int circulosActuales) {
        this.circulosMaximos = circulosMaximos;
        this.circulosActuales = circulosActuales;

        setLayout(new FlowLayout());
        setBackground(new Color(20, 20, 30)); // Fondo negro azulado
        setPreferredSize(new Dimension(130, 400));
        setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));

        JButton sumarButton = new JButton("Sumar");
        sumarButton.addActionListener(e -> {
            if (this.circulosActuales < this.circulosMaximos) {
                this.circulosActuales++;
                repaint();
            }
        });
        add(sumarButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int circleSize = 30; // Tamaño del círculo
        int padding = 5; // Espacio entre los círculos
        int startX = 25; // Posición inicial en X
        int startY = 45; // Posición inicial en Y

        for (int i = 0; i < circulosMaximos; i++) {
            int x = startX + (i % 2 == 0 ? 0 : circleSize + padding);
            int y = startY + (i * (circleSize + padding));
            Color color = i < circulosActuales ? Color.RED : Color.GRAY;
            g2d.setColor(color);
            g2d.fill(new Ellipse2D.Double(x, y, circleSize, circleSize));
        }
    }

    public void setNumeroCirculosActuales(int circulosActuales) {
        this.circulosActuales = circulosActuales;
        repaint(); // Vuelve a pintar los círculos cuando cambia el número de círculos actuales
    }

    public int getNumeroCirculosActuales() {
        return circulosActuales;
    }

    public int getNumeroCirculosMaximos() {
        return circulosMaximos;
    }
}
