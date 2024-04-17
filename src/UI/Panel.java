package UI;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
    public Panel() {
        ImageIcon icon = new ImageIcon("img/world_map.png"); // Ruta actualizada

        // Create a JLabel with the loaded image
        JLabel label = new JLabel(icon);
        
        //label.setPreferredSize(new Dimension(990, 660));
        
        //label.setBounds(0,0,990, 660 );
        
        
        label.setVisible(true);

        // Add the label to the panel
        add(label);

        JButton b1 = new JButton("Hola");
        JButton b2 = new JButton("Botón 2");
        JButton b3 = new JButton("Botón 3");
        JButton b4 = new JButton("Botón 4");

        // Add the buttons to the panel
        add(b1);
        add(b2);
        add(b3);
        add(b4);
    }
}
