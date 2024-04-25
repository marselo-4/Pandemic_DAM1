package UI;

import java.awt.*;
import javax.swing.*;

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
        
        this.setBackground(Color.gray);
        setPreferredSize(new Dimension(150, 125)); // Ajustar tamaño del panel
    }
}