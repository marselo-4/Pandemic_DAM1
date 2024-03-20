
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class programa {


public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String linea = "";

	
	String nombreFichero = "ciudades.txt";
	
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
				getFrase(linea);

			}

		} while (linea != null);
		bufferedReader.close();
		fileReader.close();
	} catch (IOException e) {
		System.out.println("Ha habido un error al intentar abrir el fichero" + e);
	}
	
	
	
}
    
private static void getFrase(String linea) {
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

}

}//Fin clase