package UI;

import javax.imageio.ImageIO;
import javax.swing.*;

import Backend.logicaJuego;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelJuegoIzquierda extends JPanel {
    public static int circulosMaximos;
    public static int circulosActuales;
    private BufferedImage imagen;
    private BufferedImage imagenFondo;

    public PanelJuegoIzquierda() {
        try {
            imagen = ImageIO.read(new File("img/brote.png")); // Ruta
            imagenFondo = ImageIO.read(new File("img/lateral.png")); // Ruta del fondo
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(150, 400));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar fondo lateral
        if (imagenFondo != null) {
            g2d.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }

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
        repaint();
    }

    public int getNumeroCirculosActuales() {
        return circulosActuales;
    }

    public int getNumeroCirculosMaximos() {
        return circulosMaximos;
    }
    
    public void generarBrotesCirculos(int circulosMaximos, int circulosActuales) {
        this.circulosMaximos = circulosMaximos;
        this.circulosActuales = circulosActuales;
        
        JButton sumarButton = new JButton("Sumar");
        sumarButton.addActionListener(e -> {
            if (this.circulosActuales < this.circulosMaximos) {
                this.circulosActuales++;
                repaint();
            }
        });
        add(sumarButton);
    }
}
