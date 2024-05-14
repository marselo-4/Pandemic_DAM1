package UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class hasGanado extends JPanel implements ActionListener { // Pantalla has Ganado

    JButton volver;
    private Image Fondo;

    public hasGanado() {
        setLayout(new FlowLayout());
        try {
            Fondo = ImageIO.read(new File("src/assets/src_fin2.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        volver = new JButton();
        volver.setIcon(new ImageIcon(new ImageIcon("src/assets/salirtemp.png").getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));
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
        	System.exit(0);
        }
    }
}
