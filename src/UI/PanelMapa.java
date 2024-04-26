package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelMapa extends JPanel {
    private ImageIcon icon;
    private Image scaledImage;

    public PanelMapa() {
        icon = new ImageIcon("img/mapa.jpg"); // Ruta actualizada
       scaleImage();
    }

    private void scaleImage() {
        if (getWidth() > 0 && getHeight() > 0) {
            scaledImage = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (scaledImage != null) {
            g.drawImage(scaledImage, 0, 0, this);
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
        scaleImage();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }
}
