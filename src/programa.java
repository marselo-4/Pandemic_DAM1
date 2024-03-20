
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class programa {


public static void main(String[] args) {
	ArrayList<Ciudades> ciudades = new ArrayList<>();	
	
	Scanner scan = new Scanner(System.in);
	String linea = "";

	
	String nombreFichero = "ciudades.txt";
	//RELLENAR ARRAY
	try {
		// Creamos un objeto de tipo FileReader para abrir un fichero de lectura
		FileReader fileReader = new FileReader(nombreFichero);
		// Utilizamos el Buffered para recibir lo que hay en el fichero y transformarlo
		// en c�digo Java
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		do {
			// Leemos el contenido del fichero
			linea = bufferedReader.readLine();
			if (linea != null) {
				
				ciudades.add(asignarCiudades(linea));

			}

		} while (linea != null);
		bufferedReader.close();
		fileReader.close();
	} catch (IOException e) {
		System.out.println("Ha habido un error al intentar abrir el fichero" + e);
	}
	
	//PRINTEAR CIUDADES
	
	
	
}
    
private static Ciudades asignarCiudades(String linea) {
	//Variables

	 String nombreCiudad = "";
	int[] coords = new int[2];
	int tipoVirus = -1;

	
String[] frasePartes = linea.split(";");
	
	//Poner coordenadas a la array
	String[] c = new String[2];
	c = frasePartes[2].split(",");
	for (int i = 0; i < c.length; i++) {
		coords[i] = Integer.parseInt(c[i]);
	}
	tipoVirus = Integer.parseInt(frasePartes[1]);
	
	
	//Poner nombreCiudad y ciudades
	nombreCiudad = frasePartes[0];
	ArrayList<String> ciudades = new ArrayList<>(Arrays.asList(frasePartes[3].split(",")));
	Ciudades ci = new Ciudades(nombreCiudad, tipoVirus, coords, ciudades);
	return ci;
}

public static double calcularDistancia(String c1, String c2) {
	//ArrayList<String>
	return 0;
}


}//Fin clase