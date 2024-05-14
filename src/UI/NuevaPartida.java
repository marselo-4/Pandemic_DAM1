package UI;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import Backend.parametros;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class NuevaPartida extends JPanel implements ActionListener {

    JButton facil; // boton
    JButton medio; // boton
    JButton dificil; // boton
    JButton volver; // boton
    private Image Fondo; // foto

    public NuevaPartida() {
        setLayout(new FlowLayout());
        try {
            Fondo = ImageIO.read(new File("src/assets/dificultad.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        facil = new JButton();
        facil.setIcon(new ImageIcon(new ImageIcon("src/assets/facil.png").getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)));
        facil.addActionListener(this);
        facil.setContentAreaFilled(false);
        facil.setBorderPainted(false);
        facil.setFocusPainted(false);
        add(facil);

        medio = new JButton();
        medio.setIcon(new ImageIcon(new ImageIcon("src/assets/medio.png").getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)));
        medio.addActionListener(this);
        medio.setContentAreaFilled(false);
        medio.setBorderPainted(false);
        medio.setFocusPainted(false);
        add(medio);

        dificil = new JButton();
        dificil.setIcon(new ImageIcon(new ImageIcon("src/assets/dificil.png").getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)));
        dificil.addActionListener(this);
        dificil.setContentAreaFilled(false);
        dificil.setBorderPainted(false);
        dificil.setFocusPainted(false);
        add(dificil);


        volver = new JButton();
        volver.setIcon(new ImageIcon(new ImageIcon("src/assets/5.png").getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));
        volver.addActionListener(this);
        volver.setContentAreaFilled(false);
        volver.setBorderPainted(false);
        volver.setFocusPainted(false);
        add(volver);

        Box caja = Box.createHorizontalBox();
        caja.add(Box.createHorizontalStrut(100)); // Añadimos margen
        caja.add(facil);
        caja.add(Box.createHorizontalStrut(100)); // Añadimos margen
        caja.add(medio);
        caja.add(Box.createHorizontalStrut(100)); // Añadimos margen
        caja.add(dificil);
        caja.add(Box.createHorizontalStrut(100)); // Añadimos margen
        caja.add(Box.createVerticalStrut(850)); // Añadimos margen

        add(Box.createHorizontalGlue());
        add(caja);
        add(Box.createHorizontalGlue());

        Box box = Box.createVerticalBox();
        box.add(volver);
        box.add(Box.createVerticalStrut(300));

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
        try {
            // Cargar el archivo de sonido
            File soundFile = new File("src/assets/gfx/selec.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            
            // Obtener un clip de sonido
            Clip clip = AudioSystem.getClip();
            
            // Abrir el flujo de audio y cargar datos
            clip.open(audioIn);
            
            // Reproducir el sonido
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
            e1.printStackTrace();
        }
        if (e.getSource() == volver) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(NuevaPartida.this);
            frame.remove(NuevaPartida.this);
            frame.add(new PanelPrincipal());
            frame.setVisible(true);
            
        }else if (e.getSource() == facil) {
            parametros.setEleccion("Facil");
            System.out.println("Has escogido el nivel fácil");
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(NuevaPartida.this);
            frame.remove(NuevaPartida.this);
            frame.add(new LanzadorPartida());
            frame.setVisible(true);

        }else if (e.getSource() == medio) {
        	parametros.setEleccion("Normal");
            System.out.println("Has escogido el nivel medio");
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(NuevaPartida.this);
            frame.remove(NuevaPartida.this);
            frame.add(new LanzadorPartida());
            frame.setVisible(true);
            
        }else if (e.getSource() == dificil) {
        	parametros.setEleccion("Dificil");
            System.out.println("Has escogido el nivel difícil");
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(NuevaPartida.this);
            frame.remove(NuevaPartida.this);
            frame.add(new LanzadorPartida()); 
            frame.setVisible(true);
            

        }
    }
}
