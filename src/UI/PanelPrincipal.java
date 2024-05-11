package UI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PanelPrincipal extends JPanel implements ActionListener {
    public JButton nuevapartida;
    public JButton cargarpartida;
    public JButton informacion;
    public JButton puntuaciones;
    public JButton salir;
    private Image fondo;



    public PanelPrincipal() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Cambiamos a BoxLayout
        try {
            fondo = ImageIO.read(new File("src/assets/fondo.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Instanciamos botones
        nuevapartida = new JButton();
        cargarpartida = new JButton();
        puntuaciones = new JButton();
        informacion = new JButton();
        salir = new JButton();
        // Ponemos fotos a los botones
        nuevapartida.setIcon(new ImageIcon(new ImageIcon("src/assets/1.png").getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));
        cargarpartida.setIcon(new ImageIcon(new ImageIcon("src/assets/2.png").getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));
        puntuaciones.setIcon(new ImageIcon(new ImageIcon("src/assets/3.png").getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));
        informacion.setIcon(new ImageIcon(new ImageIcon("src/assets/4.png").getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));
        salir.setIcon(new ImageIcon(new ImageIcon("src/assets/salirtemp.png").getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));

        nuevapartida.addActionListener(this);
        cargarpartida.addActionListener(this);
        informacion.addActionListener(this);
        puntuaciones.addActionListener(this);
        salir.addActionListener(this);
        nuevapartida.setContentAreaFilled(false);
        cargarpartida.setContentAreaFilled(false);
        informacion.setContentAreaFilled(false);
        puntuaciones.setContentAreaFilled(false);
        salir.setContentAreaFilled(false);
        nuevapartida.setBorderPainted(false);
        cargarpartida.setBorderPainted(false);
        informacion.setBorderPainted(false);
        puntuaciones.setBorderPainted(false);
        salir.setBorderPainted(false);
        nuevapartida.setFocusPainted(false);
        cargarpartida.setFocusPainted(false);
        informacion.setFocusPainted(false);
        puntuaciones.setFocusPainted(false);
        salir.setFocusPainted(false);



        // Añadimos los botones a un Box y luego al panel principal
        Box box = Box.createVerticalBox();
        box.add(nuevapartida);
        box.add(Box.createVerticalStrut(50)); // Añadimos margen
        box.add(cargarpartida);
        box.add(Box.createVerticalStrut(50)); // Añadimos margen
        box.add(informacion);
        box.add(Box.createVerticalStrut(50)); // Añadimos margen
        box.add(puntuaciones);
        box.add(Box.createVerticalStrut(50)); // Añadimos margen
        box.add(salir);

        // Añadimos el Box al panel principal
        add(Box.createVerticalGlue());
        add(box);
        add(Box.createVerticalGlue());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondoescalado = fondo.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

        // Dibujamos la imagen de fondo
        g.drawImage(fondoescalado, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nuevapartida){
            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
            marco.remove(this);
            marco.setSize(1920, 1080);
            marco.add(new Nickname());
            marco.setVisible(true);
        }
        else if(e.getSource() == cargarpartida){
            // Es minimitza nose perque
            //JOptionPane.showMessageDialog(this, "Última partida cargada");
        	LanzadorPartida.setCargarGuardada(true);
        	  JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelPrincipal.this);
              frame.remove(PanelPrincipal.this);
              frame.add(new LanzadorPartida());
              frame.setVisible(true);
        	System.out.println("Última partida cargada");
        }
        else if(e.getSource() == puntuaciones){
            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
            marco.remove(this);
            marco.add(new Puntuaciones());
            marco.setVisible(true);
        }else if (e.getSource() == informacion) {
            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
            marco.remove(this);
            Informacion infoPanel = new Informacion();
            infoPanel.setPreferredSize(marco.getSize()); // Asegúrate de que el panel Informacion ocupe todo el espacio
            marco.add(infoPanel);
            marco.setVisible(true);
        } else if (e.getSource() == salir) {
            System.exit(0);
        }
    }
}