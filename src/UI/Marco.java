package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Marco extends JFrame {

	Dimension screenSize;
    public Marco() {
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    	setLayout(new BorderLayout());
        //setBounds(450, 200, 1200, 715);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pandemic");
        
        // Crear el panel y agregarlo al JFrame
        PanelMapa p = new PanelMapa();
        this.getContentPane().add(p, BorderLayout.CENTER);

        PanelBotonesMenuAbajo p2 = new PanelBotonesMenuAbajo();
        this.getContentPane().add(p2, BorderLayout.SOUTH);

        PanelJuegoIzquierda p3 = new PanelJuegoIzquierda(10, 0);
        this.getContentPane().add(p3, BorderLayout.WEST);
        
        PanelJuegoDerecha p4 = new PanelJuegoDerecha();
        	this.getContentPane().add(p4, BorderLayout.EAST);

        
        setVisible(true);
    }

    public static void main(String[] args) {
        Marco marco = new Marco();
    }
}
