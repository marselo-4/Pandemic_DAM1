package Backend;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;

import Clases.CiudadBoton;
import Clases.controlDatos;
import Clases.controlPartida;
import Clases.datosPartida;
import UI.LanzadorPartida;
import UI.PanelMapa;

public class logicaJuego {
	public static controlDatos cd = new controlDatos();
	public static datosPartida dp = new datosPartida();
	public static controlPartida cp = new controlPartida();

	public static void crearArrayCiudades() {
		String linea = "";
		
		String nombreFichero = "ciudades.txt";
		try {
			// Creamos un objeto de tipo FileReader para abrir un fichero de lectura
			FileReader fileReader = new FileReader(nombreFichero);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			do {
				// Leemos el contenido del fichero
				linea = bufferedReader.readLine();
				if (linea != null) {
					
					dp.ciudades.add(TxtCiudades.asignarCiudades(linea));

				}

			} while (linea != null);
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
		
	}

	
	public static void crearBotonesCiudades() {
		for (int i = 0; i < dp.ciudades.size(); i++) {
			String rutaImg = "";
			System.out.println(dp.ciudades.get(i).getEnfermedad());
			switch (dp.ciudades.get(i).getEnfermedad()) {
			case "Alfa":
				rutaImg = "img/IconoCiudadAzul.png";
				break;
			case "Beta":
				rutaImg = "img/IconoCiudadRojo.png";
				break;
			case "Gama":
				rutaImg = "img/IconoCiudadVerde.png";
				break;
			case "Delta":
				rutaImg = "img/IconoCiudadAmarillo.png";
				break;

			default:
				break;
			}
			
			CiudadBoton c = new CiudadBoton();
			crearBotonciudad(LanzadorPartida.p, c, rutaImg, dp.ciudades.get(i).getCoords()[0], dp.ciudades.get(i).getCoords()[1], 35, 35);
		}
	}
	
    public static void crearBotonciudad(PanelMapa p,CiudadBoton Ciudad, String rutaimg, int x, int y, int w, int h) {
    	
        Ciudad.setOpaque(false);
        Ciudad.setBorderPainted(false);
        Ciudad.setContentAreaFilled(false);
        Ciudad.setBounds(x, y, w, h );
        ImageIcon icono = new ImageIcon(new ImageIcon(rutaimg).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
        Ciudad.setIcon(icono);
        PanelMapa.IconosCiudades.add(Ciudad);
        
        
        p.add(Ciudad);
        //System.out.println("Botón " + rutaimg + "se intentó crear en " + p);
        Ciudad.addActionListener(p);
    }
	
}
