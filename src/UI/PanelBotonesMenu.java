package UI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotonesMenu extends JPanel{
	public PanelBotonesMenu() {
		 
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
