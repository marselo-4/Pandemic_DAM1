package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Backend.logicaJuego;
import Clases.controlDatos;
import Clases.datosPartida;

public class LanzadorPartida extends JPanel {
	public static boolean CargarGuardada = false;
	public static PanelMapa p = new PanelMapa();
	public static PanelBotonesMenuAbajo p2 = new PanelBotonesMenuAbajo();
	public static PanelJuegoIzquierda p3 = new PanelJuegoIzquierda();
	public static PanelJuegoDerecha p4 = new PanelJuegoDerecha();
	public static hasGanado p5 = new hasGanado();
	public static hasPerdido p6 = new hasPerdido();
	public static boolean mec = false;
	public static boolean mecmec = false;


	
	public LanzadorPartida() { 
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
        



     
        
        //Álvaro: he puesto los paneles públicos para poder editarlos desde el backend si es necesario
        logicaJuego.crearArrayCiudades();
        logicaJuego.crearBotonesCiudades();
        logicaJuego.empezarPartida(3);
        logicaJuego.crearVacunas(p4.vacunas, p4);
        logicaJuego.BotonesDesarollar_curar(p4);
        p3.generarBrotesCirculos(logicaJuego.dp.getBrotes_maximos(), 0);
              
        if (CargarGuardada == true)  {
        	controlDatos.cargarPartida(controlDatos.conectarBaseDatos());
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
//        //Álvaro: he puesto los paneles públicos para poder editarlos desde el backend si es necesario
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

	public static boolean isCargarGuardada() {
		return CargarGuardada;
	}

	public static void setCargarGuardada(boolean cargarGuardada) {
		CargarGuardada = cargarGuardada;
	}
	
}



	public static void test() {
		// TODO Auto-generated method stub
        if(mec == true) {
        	LanzadorPartida lanzadorPartida = new LanzadorPartida();
			lanzadorPartida.remove(p);
			lanzadorPartida.add(p5);
        	p5.setVisible(true);
        }else if(mecmec == true) {
        	LanzadorPartida lanzadorPartida = new LanzadorPartida();
        	lanzadorPartida.remove(p);
        	lanzadorPartida.add(p6);
            p6.setVisible(true);
        }
		
	}


	
}
