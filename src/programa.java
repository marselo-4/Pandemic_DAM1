import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		
		// Leemos el contenido del fichero
		linea = bufferedReader.readLine();
		System.out.println(getFrase(linea));
		linea = "";
		bufferedReader.close();
		fileReader.close();

	} catch (IOException e) {
		System.out.println("Ha habido un error al intentar abrir el fichero" + e);
	}
	
	
	
}
    
private static String getFrase(String linea) {
	//Variables
	 String nombreCiudad = "";
	int[] coords = new int[3];
	String[] ciudades = new String[4];
	
String[] frasePartes = linea.split(";");
	
	//Poner coordenadas a la array
	String[] c = new String[2];
	c = frasePartes[2].split(",");
	for (int i = 0; i < c.length; i++) {
		coords[i+1] = Integer.parseInt(c[i]);
	}
	coords[0] = Integer.parseInt(frasePartes[1]);
	
	
	//Poner nombreCiudad y ciudades
	nombreCiudad = frasePartes[0];
	ciudades = frasePartes[3].split(",");
	String ret = "Silco actua en " + nombreCiudad + " con los números "+ coords[0] + "," + coords[1] + "," + coords[2] + ", y cuyas ciudades" + " colindantes son " + frasePartes[3];
	return ret;
}

}//Fin clase