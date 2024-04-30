package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LanzadorPartida extends JPanel {
	
	public LanzadorPartida() {
    	setSize(1920,1080);
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        
        // Crear el panel y agregarlo al JFrame
        PanelMapa p = new PanelMapa();
        this.add(p, BorderLayout.CENTER);

        PanelBotonesMenuAbajo p2 = new PanelBotonesMenuAbajo();
        this.add(p2, BorderLayout.SOUTH);

        PanelJuegoIzquierda p3 = new PanelJuegoIzquierda(10, 0);
        this.add(p3, BorderLayout.WEST);
        
        PanelJuegoDerecha p4 = new PanelJuegoDerecha();
        this.add(p4, BorderLayout.EAST);

        
        setVisible(true);
	}
}