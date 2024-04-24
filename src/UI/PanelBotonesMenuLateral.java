package UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBotonesMenuLateral extends JPanel{

	public PanelBotonesMenuLateral(){
		
		this.setBackground(Color.gray);        
//		setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

        setPreferredSize(new Dimension(200,600)); 

		JLabel test = new JLabel("test");
		
		add(test);

	}
	

}