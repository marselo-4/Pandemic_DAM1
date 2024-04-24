package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBotonesMenuAbajo extends JPanel {
	public PanelBotonesMenuAbajo() {
		setLayout(new FlowLayout());

		this.setBackground(Color.gray);
		setPreferredSize(new Dimension(100, 125));

		// setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
//		JLabel acciones = new JLabel("Acciones restantes : X");
//		JTextField tf = new JTextField(20);
//		JButton vacuna = new JButton();
//		
//		add(brotes);
//		add(acciones);
//		add(tf);        

		ButtonGroup vacunas = new ButtonGroup();

		JRadioButton radioAzul = new JRadioButton();
		vacunas.add(radioAzul);
		add(radioAzul);
		radioAzul.setOpaque(false);
		radioAzul.setContentAreaFilled(false);
		radioAzul.setBorderPainted(false);
		radioAzul.setFocusPainted(true);
		radioAzul.setForeground(Color.black);
		Icon icono_azul = new ImageIcon(
				new ImageIcon("img/toxichazard.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
		radioAzul.setIcon(icono_azul);
		
		//No funciona mirar overide
		if (radioAzul.isSelected()) {
			icono_azul = new ImageIcon(
					new ImageIcon("img/toxichazard.png").getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
			radioAzul.setIcon(icono_azul);
			add(radioAzul);

		}
		
		
		JRadioButton radioNegro = new JRadioButton();
		vacunas.add(radioNegro);
		add(radioNegro);

		
		
		JRadioButton radioRojo = new JRadioButton();
		vacunas.add(radioRojo);
		add(radioRojo);

		
		JRadioButton radioAmarillo = new JRadioButton();
		vacunas.add(radioAmarillo);
		add(radioAmarillo);

		
		JButton desarollarVac = new JButton("Desarrollar");
		vacunas.add(desarollarVac);
		add(desarollarVac);

	}
	


//	 private static void customizeRadioButton(JRadioButton radioButton, Color color) {
//	        radioButton.setOpaque(false);
//	        radioButton.setContentAreaFilled(false);
//	        radioButton.setBorderPainted(false);
//	        radioButton.setFocusPainted(true);
//	        radioButton.setForeground(Color.black);
//	        radioButton.setIcon(new Icon() {
//	            @Override
//	            public void paintIcon(Component c, Graphics g, int x, int y) {
//	                if (radioButton.isSelected()) {
//	                    Icon icono_rojo = new ImageIcon(new ImageIcon("img/toxichazard.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
//
//	                }
//	            }	
//	            @Override
//	            public int getIconWidth() {
//	                return 60;
//	            }
//
//	            @Override
//	            public int getIconHeight() {
//	                return 60;
//	            }
//	        });
//	    }
}
