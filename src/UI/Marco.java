package UI;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Marco extends JFrame {

    public Marco() {
        setLayout(new BorderLayout());
        setBounds(450, 200, 1200, 715);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pandemic");
        
        // Crear el panel y agregarlo al JFrame
        Panel p = new Panel();
        this.getContentPane().add(p, BorderLayout.CENTER);

        Panel p2 = new Panel();
        this.getContentPane().add(p2, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        Marco marco = new Marco();
    }
}
