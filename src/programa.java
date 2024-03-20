
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class programa {
	public static ArrayList<Ciudades> ciudades = new ArrayList<>();	

public static void main(String[] args) {
		
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
	
	for (int i = 0; i < ciudades.size(); i++) {
		Ciudades ciu = ciudades.get(i);
		
		System.out.println("La ciudad " + ciu.getNombre() + " está en las coords " + ciu.getCoords()[0] + "," + ciu.getCoords()[1] + " y sus colindantes son:");
		
		for (int j = 0; j < ciu.getColindantes().size(); j++) {
			String colindante = ciu.getColindantes().get(j);		
			int posicionArraylist = buscarCiudad(colindante);
			System.out.println(ciu.getNombre() + " está a "+ calcularDistancia(ciu, ciudades.get(posicionArraylist)) +"km "
					+ "de distancia de " + colindante);
		}
	}
	
	
}
    
private static Ciudades asignarCiudades(String linea) {
	//Variables

	 String nombreCiudad = "";
	int[] coords = new int[2];
	int tipoVirus = -1;

	
String[] frasePartes = linea.split(";");
	
	//Poner coordenadas a la array
	String[] a = new String[2];
	a = frasePartes[2].split(",");
	for (int i = 0; i < a.length; i++) {
		coords[i] = Integer.parseInt(a[i]);
	}
	tipoVirus = Integer.parseInt(frasePartes[1]);
	
	
	//Poner nombreCiudad y ciudades
	nombreCiudad = frasePartes[0];
	ArrayList<String> ciudades = new ArrayList<>(Arrays.asList(frasePartes[3].split(",")));
	return new Ciudades(nombreCiudad, tipoVirus, coords, ciudades);
}

private static int buscarCiudad(String nombre) {
    int pos = -1;
    for (int i = 0; i < ciudades.size(); i++) {
        if (ciudades.get(i).getNombre().equals(nombre)) {
            pos = i;
            break;
        }
    }
    return pos;
}

public static double calcularDistancia(Ciudades ciudadMain, Ciudades colindante) {
	double longitud = 0;
	double altura = 0;
	double distancia = 0;
	//obtener longitud y altura del triangulo
	longitud = ciudadMain.getCoords()[0] - colindante.getCoords()[0];
	if (longitud < 0) {
		longitud = longitud*-1;
	}
	
	altura = ciudadMain.getCoords()[1] - colindante.getCoords()[1];
	if (altura < 0) {
		altura = altura * -1;
	}

	//hacer pitágoras
	altura = altura*altura;
	longitud = longitud*longitud;
	
	distancia = altura + longitud;
	distancia = Math.sqrt(distancia);
	distancia = Math.round(distancia * 100.0) / 100.0;
	
return distancia;
}


}//Fin clase