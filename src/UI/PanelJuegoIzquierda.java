package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelJuegoIzquierda extends JPanel {
    private int circulosMaximos;
    private int circulosActuales;
    private BufferedImage imagen;

    public PanelJuegoIzquierda(int circulosMaximos, int circulosActuales) {
        this.circulosMaximos = circulosMaximos;
        this.circulosActuales = circulosActuales;

        try {
            imagen = ImageIO.read(new File("img/brote.png")); // Ruta 
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new FlowLayout());
        setBackground(new Color(20, 20, 30)); // Fondo negro azulado
        setPreferredSize(new Dimension(150, 400));
        //setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));

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

        int circleSize = 50; // Tamaño del círculo
        int padding = 8; // Espacio entre los círculos
        int startX = 23; // Posición inicial en X
        int startY = 130; // Posición inicial en Y

        for (int i = 0; i < circulosMaximos; i++) {
            int x = startX + (i % 2 == 0 ? 0 : circleSize + padding);
            int y = startY + (i * (circleSize + padding));
            Image image = i < circulosActuales ? imagen : null;
            if (image != null) {
                g2d.drawImage(image, x, y, circleSize, circleSize, null);
            } else {
                Color color = Color.GRAY;
                g2d.setColor(color);
                g2d.fill(new Ellipse2D.Double(x, y, circleSize, circleSize));
            }
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
