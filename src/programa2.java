import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class programa2 {
	//Variables
	public static String nombreCiudad = "";
	public static int[] coords = new int[3];
	public static String[] ciudades = new String[4];

public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Poner linea");
	String linea = scan.nextLine();
	
	String[] frasePartes = linea.split(";");
	
	//Poner coordenadas a la array
	String[] c = new String[2];
	c = frasePartes[2].split(",");
	for (int i = 0; i < c.length; i++) {
		coords[i+1] = Integer.parseInt(c[i]);
		System.out.println(c[i]);
	}
	coords[0] = Integer.parseInt(frasePartes[1]);
	
	
	//Poner nombreCiudad y ciudades
	nombreCiudad = frasePartes[0];
	ciudades = frasePartes[3].split(",");
	
	System.out.println("Silco actua en " + nombreCiudad + " con los números "
			+ coords[0] + "," + coords[1] + "," + coords[2] + ", y cuyas ciudades"
					+ " colindantes son " + frasePartes[3]);
}
    
private static void reiniciarArrays() {
	for (int i = 0; i < ciudades.length; i++) {
		ciudades[i] = null;
	}
	
	for (int i = 0; i < coords.length; i++) {
		coords[i] = 0;
	}
}

}//Fin clase