package UI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBotonesMenu extends JPanel{
	public PanelBotonesMenu() {
		 
		this.setBackground(Color.black);
		JLabel brotes = new JLabel("Brotes: X");
		
		JLabel acciones = new JLabel("Acciones restantes : X");
		JTextField tf = new JTextField(20);
		JButton vacuna = new JButton();
		
		add(brotes);
		add(acciones);

		add(tf);
	}
}
