package UI;
import javax.imageio.ImageIO;
import javax.swing.*;

import Clases.controlDatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Puntuaciones extends JPanel implements ActionListener {

    JButton volver;
    private Image Fondo;
    JRadioButton facilRadio, normalRadio, dificilRadio;
    ButtonGroup dificultadGroup;
   static JTextArea textArea;

    
    public Puntuaciones() {
        setLayout(new FlowLayout());
        try {
            Fondo = ImageIO.read(new File("src/assets/scr_puntuaciones.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        
        BotoneraYCajatxtRanking();

        
        
        volver = new JButton();
        volver.setIcon(new ImageIcon(new ImageIcon("src/assets/5.png").getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));
        volver.addActionListener(this);
        volver.setContentAreaFilled(false);
        volver.setBorderPainted(false);
        volver.setFocusPainted(false);
        add(volver);

        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalStrut(850)); // Añadimos margen
        box.add(volver);

        add(Box.createVerticalGlue());
        add(box);
        add(Box.createVerticalGlue());



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondoescalado = Fondo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

        // Dibujamos la imagen de fondo
        g.drawImage(fondoescalado, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volver) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Puntuaciones.this);
            frame.remove(Puntuaciones.this);
            frame.add(new PanelPrincipal()); // Suponiendo que PreviousPanel es el panel al que quieres volver
            frame.setVisible(true);
        } else if (e.getSource() == facilRadio) {
        	controlDatos.cargarRecordFacil(controlDatos.conectarBaseDatos());
        } else if (e.getSource() == normalRadio) {
        	controlDatos.cargarRecordNormal(controlDatos.conectarBaseDatos());
        }else if (e.getSource() == dificilRadio) {
        	controlDatos.cargarRecordDificil(controlDatos.conectarBaseDatos());

        }
    }
    
    public void BotoneraYCajatxtRanking () {

    	facilRadio = new JRadioButton("Fácil");
    	facilRadio.addActionListener(this);
        normalRadio = new JRadioButton("Normal");
    	normalRadio.addActionListener(this);
        dificilRadio = new JRadioButton("Difícil");
    	dificilRadio.addActionListener(this);
        dificultadGroup = new ButtonGroup();
        dificultadGroup.add(facilRadio);
        dificultadGroup.add(normalRadio);
        dificultadGroup.add(dificilRadio);
        add(facilRadio);
        add(normalRadio);
        add(dificilRadio);
        
        textArea = new JTextArea(20, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setForeground(Color.WHITE); 
        add(textArea);
        
        File fontFile = new File("fonts/DisposableDroidBB.ttf");
        Font fuentePersonalizada = null;
        
        try {
            fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            fuentePersonalizada = fuentePersonalizada.deriveFont(25f); 
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        textArea.setFont(fuentePersonalizada);
        
        textArea.setText("ai ai ai como me dueleee");

    }
    
    public static void textosCajaRanking(String texto) {
		// Creamos un hilo para el efecto de escritura
//		new Thread(() -> {
//			for (int i = 0; i <= texto.length(); i++) {
//				final int index = i;
//				// Actualizamos la caja de texto en el hilo de la interfaz de usuario (Swing)
//				SwingUtilities.invokeLater(() -> {
//					textArea.setText(texto.substring(0, index));
//				});
//				try {
//					// Simulamos un pequeño retraso entre cada caracter para el efecto de escritura
//					TimeUnit.MILLISECONDS.sleep(5);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
    	textArea.setText(texto);
	}
    
}
