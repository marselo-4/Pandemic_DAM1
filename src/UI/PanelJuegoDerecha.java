package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelJuegoDerecha extends JPanel implements ActionListener, ItemListener{
    private ImageIcon icono_azul = new ImageIcon(new ImageIcon("img/azul.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
    private ImageIcon icono_azul_grande = new ImageIcon(new ImageIcon("img/azulS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

    private ImageIcon icono_negro = new ImageIcon(new ImageIcon("img/negro.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
    private ImageIcon icono_negro_grande = new ImageIcon(new ImageIcon("img/negroS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

    private ImageIcon icono_amarillo = new ImageIcon(new ImageIcon("img/amarillo.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
    private ImageIcon icono_amarillo_grande = new ImageIcon(new ImageIcon("img/amarilloS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

    private ImageIcon icono_rojo = new ImageIcon(new ImageIcon("img/rojo.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
    private ImageIcon icono_rojo_grande = new ImageIcon(new ImageIcon("img/rojoS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

    private JRadioButton radioAzul = new JRadioButton(icono_azul);
    private JRadioButton radioNegro = new JRadioButton(icono_negro);
    private JRadioButton radioRojo = new JRadioButton(icono_rojo);
    private JRadioButton radioAmarillo = new JRadioButton(icono_amarillo);
    
    private JLabel labelAzul = new JLabel("0%");
    private JLabel labelNegro = new JLabel("0%");
    private JLabel labelRojo = new JLabel("0%");
    private JLabel labelAmarillo = new JLabel("0%");

    public PanelJuegoDerecha() {
    	
        setLayout(new FlowLayout());
        ButtonGroup vacunas = new ButtonGroup();
        agregarBotones(vacunas);
        this.setBackground(new Color(20, 20, 30)); // Fondo negro azulado
        setPreferredSize(new Dimension(150, 400));
        setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        
        Desarollar_y_curar();
    }

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == radioAzul) {
        if (radioAzul.isSelected()) {
            radioAzul.setIcon(icono_azul_grande);
            PanelBotonesMenuAbajo.textosCaja("Vacuna azul seleccionada");
        } else {
            radioAzul.setIcon(icono_azul);
        }
    } else if (e.getSource() == radioNegro) {
        if (radioNegro.isSelected()) {
            radioNegro.setIcon(icono_negro_grande);
            PanelBotonesMenuAbajo.textosCaja("Vacuna negra seleccionada");
        } else {
            radioNegro.setIcon(icono_negro);
        }
    } else if (e.getSource() == radioAmarillo) {
        if (radioAmarillo.isSelected()) {
            radioAmarillo.setIcon(icono_amarillo_grande);
            PanelBotonesMenuAbajo.textosCaja("Vacuna amarilla seleccionada");
        } else {
            radioAmarillo.setIcon(icono_amarillo);
        }
    } else if (e.getSource() == radioRojo) {
        if (radioRojo.isSelected()) {
            radioRojo.setIcon(icono_rojo_grande);
            PanelBotonesMenuAbajo.textosCaja("Vacuna roja seleccionada");
        } else {
            radioRojo.setIcon(icono_rojo);
        }
    }
}

public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == radioAzul) {
        if (!radioAzul.isSelected()) {
            radioAzul.setIcon(icono_azul);
        }
    } else if (e.getSource() == radioNegro) {
        if (!radioNegro.isSelected()) {
            radioNegro.setIcon(icono_negro);
        }
    } else if (e.getSource() == radioAmarillo) {
        if (!radioAmarillo.isSelected()) {
            radioAmarillo.setIcon(icono_amarillo);
        }
    } else if (e.getSource() == radioRojo) {
        if (!radioRojo.isSelected()) {
            radioRojo.setIcon(icono_rojo);
        }
    }
}

private void agregarBotones(ButtonGroup vacunas) {
	
	radioAzul.setOpaque(false);
    radioAzul.setContentAreaFilled(false);
    radioAzul.setBorderPainted(false);
    radioAzul.setFocusPainted(true);
    radioAzul.setForeground(Color.black);
    radioAzul.setPreferredSize(new Dimension(100, 100));
    vacunas.add(radioAzul);
    radioAzul.addActionListener(this);
    radioAzul.addItemListener(this);
    add(radioAzul);
    add(labelAzul);
    labelAzul.setForeground(Color.white);

    radioNegro.setOpaque(false);
    radioNegro.setContentAreaFilled(false);
    radioNegro.setBorderPainted(false);
    radioNegro.setFocusPainted(true);
    radioNegro.setForeground(Color.black);
    radioNegro.setPreferredSize(new Dimension(100, 100));
    vacunas.add(radioNegro);
    radioNegro.addActionListener(this);
    radioNegro.addItemListener(this);
    add(radioNegro);
    add(labelNegro);
    labelNegro.setForeground(Color.white);


    radioRojo.setOpaque(false);
    radioRojo.setContentAreaFilled(false);
    radioRojo.setBorderPainted(false);
    radioRojo.setFocusPainted(true);
    radioRojo.setForeground(Color.black);
    radioRojo.setPreferredSize(new Dimension(100, 100));
    vacunas.add(radioRojo);
    radioRojo.addActionListener(this);
    radioRojo.addItemListener(this);
    add(radioRojo);
    add(labelRojo);
    labelRojo.setForeground(Color.white);

    
    radioAmarillo.setOpaque(false);
    radioAmarillo.setContentAreaFilled(false);
    radioAmarillo.setBorderPainted(false);
    radioAmarillo.setFocusPainted(true);
    radioAmarillo.setForeground(Color.black);
    radioAmarillo.setPreferredSize(new Dimension(100, 100));
    vacunas.add(radioAmarillo);
    radioAmarillo.addActionListener(this);
    radioAmarillo.addItemListener(this);
    add(radioAmarillo);
    add(labelAmarillo);
    labelAmarillo.setForeground(Color.white);

}

public void Desarollar_y_curar() {
	 JPanel panel_botones_derecha = new JPanel();
	    panel_botones_derecha.setLayout(null);
	    add(panel_botones_derecha);
	    
		JButton curarCiudad = new JButton();
		curarCiudad.setOpaque(false);
		curarCiudad.setBorderPainted(false);
	    curarCiudad.setContentAreaFilled(false);
	    curarCiudad.setBounds(500, 550, 85, 85); // Desplaza el botón curarCiudad hacia abajo
	    
	    ImageIcon curarCiudadimg = new ImageIcon(new ImageIcon("img/cur_ciudad.png").getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));
	    curarCiudad.setIcon(curarCiudadimg);
		add(curarCiudad);

		JButton DesarollarVacuna = new JButton();
		DesarollarVacuna.setBorderPainted(false);
		DesarollarVacuna.setOpaque(false);
	    DesarollarVacuna.setContentAreaFilled(false);
	    DesarollarVacuna.setBounds(500, 650, 85, 85); // Desplaza el botón DesarollarVacuna hacia abajo
	    ImageIcon desvacunaimg = new ImageIcon(new ImageIcon("img/des_vacuna.png").getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));
	    DesarollarVacuna.setIcon(desvacunaimg);
		add(DesarollarVacuna);
	
}

}