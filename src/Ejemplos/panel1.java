package Ejemplos;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class panel1 extends JPanel implements ActionListener {

	JButton boton1;
	JButton boton2;
	JButton boton3;
	JTextField areatext;

	public panel1() {
		setLayout(new FlowLayout());

		boton1 = new JButton("Merequetenge");
		boton2 = new JButton("Panel 2");
		boton3 = new JButton("SALIR");
		areatext = new JTextField(20);
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);

		add(boton1);
		add(boton2);
		add(boton3);
		add(areatext);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton1) {
			areatext.setText("mecagon deu");

		} else if (e.getSource() == boton2) {
			JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
			marco.remove(this);
			marco.setVisible(true);
		} else if (e.getSource() == boton3) {
			System.exit(0);
		}
	}
}
