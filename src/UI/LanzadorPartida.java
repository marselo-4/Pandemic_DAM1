package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LanzadorPartida extends JPanel {
	public static PanelMapa p = new PanelMapa();
	public static PanelBotonesMenuAbajo p2 = new PanelBotonesMenuAbajo();
	public static PanelJuegoIzquierda p3 = new PanelJuegoIzquierda(10, 0);
	public static PanelJuegoDerecha p4 = new PanelJuegoDerecha();
	
	public LanzadorPartida() {
    	setSize(1920,1080);
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        
        this.add(p, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.WEST);
        this.add(p4, BorderLayout.EAST);

        //Álvaro: he puesto los paneles públicos para poder editarlos desde el backend si es necesario
        
        setVisible(true);
	}
}