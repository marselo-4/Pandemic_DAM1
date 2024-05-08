package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Backend.logicaJuego;
import Clases.CiudadBoton;
import Clases.VacunaBoton;

public class PanelJuegoDerecha extends JPanel implements ActionListener, ItemListener{
	Random rand = new Random();
	
	public static ImageIcon icono_azul = new ImageIcon(new ImageIcon("img/azul.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
    public static ImageIcon icono_azul_grande = new ImageIcon(new ImageIcon("img/azulS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    public static ImageIcon icono_verde = new ImageIcon(new ImageIcon("img/verde.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
    public static ImageIcon icono_verde_grande = new ImageIcon(new ImageIcon("img/verdeS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    public static ImageIcon icono_amarillo = new ImageIcon(new ImageIcon("img/amarillo.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
    public static ImageIcon icono_amarillo_grande = new ImageIcon(new ImageIcon("img/amarilloS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    public static ImageIcon icono_rojo = new ImageIcon(new ImageIcon("img/rojo.png").getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
    public static ImageIcon icono_rojo_grande = new ImageIcon(new ImageIcon("img/rojoS.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

    public static VacunaBoton radioAzul = new VacunaBoton();
    public static VacunaBoton radioVerde = new VacunaBoton();
    public static VacunaBoton radioRojo = new VacunaBoton();
    public static VacunaBoton radioAmarillo = new VacunaBoton();
    public static ButtonGroup vacunas = new ButtonGroup();
    
    public static JLabel labelAzul = new JLabel("0%");
    public static JLabel labelVerde = new JLabel("0%");
    public static JLabel labelRojo = new JLabel("0%");
    public static JLabel labelAmarillo = new JLabel("0%");
    
    public static JButton curarCiudad = new JButton();
    public static JButton DesarollarVacuna = new JButton();
   
    private int vacunaSeleccionada = -1;

    private BufferedImage imagenFondo;

    public PanelJuegoDerecha() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(150, 400));

        
        
        cargarFondo();
    }

    private void cargarFondo() {
        try {
            imagenFondo = ImageIO.read(new File("img/lateral.png")); // Ruta del fondo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar fondo
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == radioAzul) {
        if (radioAzul.isSelected()) {
            radioAzul.setIcon(icono_azul_grande);
            logicaJuego.textosCaja("Vacuna azul seleccionada"); 
            vacunaSeleccionada = 1;
        } else {
            radioAzul.setIcon(icono_azul);
        }
    } else if (e.getSource() == radioVerde) {
        if (radioVerde.isSelected()) {
            radioVerde.setIcon(icono_verde_grande);
            logicaJuego.textosCaja("Vacuna verde seleccionada");
            vacunaSeleccionada = 2;
        } else {
            radioVerde.setIcon(icono_verde);
        }
    } else if (e.getSource() == radioAmarillo) {
        if (radioAmarillo.isSelected()) {
            radioAmarillo.setIcon(icono_amarillo_grande);
            logicaJuego.textosCaja("Vacuna amarilla seleccionada");
            vacunaSeleccionada = 3;
        } else {
            radioAmarillo.setIcon(icono_amarillo);
        }
    } else if (e.getSource() == radioRojo) {
        if (radioRojo.isSelected()) {
            radioRojo.setIcon(icono_rojo_grande);
            logicaJuego.textosCaja("Vacuna roja seleccionada");
            vacunaSeleccionada = 4;
        } else {
            radioRojo.setIcon(icono_rojo);
        }
    }else if (e.getSource() == DesarollarVacuna) { 
        // Deshabilitar el botón mientras se realiza la animación

        switch (vacunaSeleccionada) {
            case 1:
            	boolean b = logicaJuego.updateAP(2);
            	if(b) {
                    DesarollarVacuna.setEnabled(false);
                    logicaJuego.textosCajaColor("Vacuna azul desarrollada con exito!", Color.blue);
                	logicaJuego.animateJLabel(labelAzul, radioAzul.getVacuna().getPorcentaje(), logicaJuego.dp.getpDesarrollo(), radioAzul.getVacuna(), () -> {
                        DesarollarVacuna.setEnabled(true);
                        });
                	break;
            	}

                break;
            case 2:
            	boolean b1 = logicaJuego.updateAP(2);
            	if(b1) {
                    DesarollarVacuna.setEnabled(false);
                    logicaJuego.textosCajaColor("Vacuna verde desarrollada con exito!", Color.green);
                    logicaJuego.animateJLabel(labelVerde, radioVerde.getVacuna().getPorcentaje(), logicaJuego.dp.getpDesarrollo(), radioVerde.getVacuna(), () -> {
                        DesarollarVacuna.setEnabled(true);
                    });
                    break;
            	}
            case 3:
            	boolean b2 = logicaJuego.updateAP(2);
            	if(b2) {
                    DesarollarVacuna.setEnabled(false);
                    logicaJuego.textosCajaColor("Vacuna amarilla desarrollada con exito!", Color.yellow);
                    logicaJuego.animateJLabel(labelAmarillo, radioAmarillo.getVacuna().getPorcentaje(), logicaJuego.dp.getpDesarrollo(), radioAmarillo.getVacuna(), () -> {
                        DesarollarVacuna.setEnabled(true);
                    });
                    break;
            	}
            case 4:
            	boolean b3 = logicaJuego.updateAP(2);
            	if(b3) {
                    DesarollarVacuna.setEnabled(false);
                    logicaJuego.textosCajaColor("Vacuna roja desarrollada con exito!", Color.red);
                    logicaJuego.animateJLabel(labelRojo, radioRojo.getVacuna().getPorcentaje(), logicaJuego.dp.getpDesarrollo(), radioRojo.getVacuna(), () -> {
                        DesarollarVacuna.setEnabled(true);
                    });
                    break;
            	}
            default:
            	DesarollarVacuna.setEnabled(true);
                break;
        }
    }else if(e.getSource() == curarCiudad) {
    	System.out.println("Intentando curar");
    	logicaJuego.curarCiudad(PanelMapa.ciudadSeleccionada);
    }

}

public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == radioAzul) {
        if (!radioAzul.isSelected()) {
            radioAzul.setIcon(icono_azul);
        }
    } else if (e.getSource() == radioVerde) {
        if (!radioVerde.isSelected()) {
            radioVerde.setIcon(icono_verde);
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

}