package UI;

import javax.swing.*;
import java.awt.*;

public class PanelBotonesMenuAbajo extends JPanel {

    public PanelBotonesMenuAbajo() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Usar BoxLayout horizontal

        // Espacio en blanco para empujar el JLabel hacia la derecha
        add(Box.createHorizontalGlue());

        ImageIcon icon = new ImageIcon("img/tierraR.gif");

        JLabel lbl = new JLabel(icon);

        // Establecer tamaño del JLabel
        lbl.setPreferredSize(new Dimension(150, 100));

        // Añadir el JLabel al panel
        add(lbl);

        this.setBackground(new Color(20, 20, 30)); // Fondo negro azulado
        setPreferredSize(new Dimension(150, 125)); // Ajustar tamaño del panel

        // Añadir borde verde chillón
        setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 3));
    }
}
