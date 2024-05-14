package UI;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Informacion extends JPanel implements ActionListener {

    JButton volver;
    private Image Fondo;

    public Informacion() {
        setLayout(new FlowLayout());
        try {
            Fondo = ImageIO.read(new File("src/assets/scr_informacion.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
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
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Informacion.this);
            frame.remove(Informacion.this);
            frame.add(new PanelPrincipal()); // Suponiendo que PreviousPanel es el panel al que quieres volver
            frame.setVisible(true);
        }
    }
}
