import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class programa {


public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Poner linea");
	String linea = scan.nextLine();
	System.out.println(getFrase(linea));
	
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