package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Backend.logicaJuego;
import Clases.controlDatos;
import Clases.datosPartida;

public class LanzadorPartida extends JPanel {
	public static boolean CargarGuardada = false; // bool cargar
	public static PanelMapa p = new PanelMapa(); // panel
	public static PanelBotonesMenuAbajo p2 = new PanelBotonesMenuAbajo(); // panel
	public static PanelJuegoIzquierda p3 = new PanelJuegoIzquierda(); // panel
	public static PanelJuegoDerecha p4 = new PanelJuegoDerecha(); // panel
	public static hasGanado p5 = new hasGanado(); // panel
	public static hasPerdido p6 = new hasPerdido();  // panel
	public static boolean mec = false; // bool panel
	public static boolean mecmec = false; // bool panel


	
	public LanzadorPartida() { // se lanza la partida
		boolean mec1;

    	setSize(1920,1080);
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        

        this.add(p, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.WEST);
        this.add(p4, BorderLayout.EAST);

    	
        p.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        p4.setVisible(true);
        



     
        
        // Alvaro: he puesto los paneles públicos para poder editarlos desde el backend si es necesario
        logicaJuego.crearArrayCiudades();
        logicaJuego.crearBotonesCiudades();
        logicaJuego.empezarPartida(3);
        logicaJuego.crearVacunas(p4.vacunas, p4);
        logicaJuego.BotonesDesarollar_curar(p4);
        p3.generarBrotesCirculos(logicaJuego.dp.getBrotes_maximos(), 0);
              
        if (CargarGuardada == true)  {
        	controlDatos.cargarPartida(controlDatos.con);
        }
        setVisible(true);
	}
	
//	public void CargarPartidaGurdada () {
//		setSize(1920,1080);
//    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//        setLayout(new BorderLayout());
//        
//        this.add(p, BorderLayout.CENTER);
//        this.add(p2, BorderLayout.SOUTH);
//        this.add(p3, BorderLayout.WEST);
//        this.add(p4, BorderLayout.EAST);
//
//
//        // Alvaro: he puesto los paneles públicos para poder editarlos desde el backend si es necesario
//        logicaJuego.crearArrayCiudades();
//        logicaJuego.crearBotonesCiudades();
//        logicaJuego.empezarPartida(3);
//        
//        logicaJuego.crearVacunas(p4.vacunas, p4);
//        logicaJuego.BotonesDesarollar_curar(p4);
//      
//        
//        p3.generarBrotesCirculos(logicaJuego.dp.getBrotes_maximos(), 0);
//               
//        setVisible(true);
//	}

	public static boolean isCargarGuardada() { // esta guardada cargar?
		return CargarGuardada;
	}

	public static void setCargarGuardada(boolean cargarGuardada) { // cargar
		CargarGuardada = cargarGuardada;
	}
	




	public static void test() { // marcos
		// TODO Auto-generated method stub
        if(mec == true) {
            JFrame marco = (JFrame) SwingUtilities.getRoot(LanzadorPartida.p);
            marco.getContentPane().removeAll();
            marco.getContentPane().add(new hasGanado());
            marco.setSize(1920, 1080);
            marco.setVisible(true);

        }else if(mecmec == true) {
            JFrame marco = (JFrame) SwingUtilities.getRoot(LanzadorPartida.p);
            marco.getContentPane().removeAll();
            marco.getContentPane().add(new hasPerdido());
            marco.setSize(1920, 1080);
            marco.setVisible(true);

        }
		
	}


	
}
