package Backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Clases.CiudadBoton;
import Clases.controlDatos;
import Clases.controlPartida;
import Clases.datosPartida;
import UI.LanzadorPartida;

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
			LanzadorPartida.p.crearBotonciudad(LanzadorPartida.p, c, rutaImg, dp.ciudades.get(i).getCoords()[0], dp.ciudades.get(i).getCoords()[1], 35, 35);
		}
	}
	
	
	
}
