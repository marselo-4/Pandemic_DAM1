package programa;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class BinEnfermedades {
	public static ArrayList<Ciudades> ciudades = new ArrayList<>();	


	public static void main(String[] args) {

		
		String nombreFichero = "CCP.bin";
		
		try {
			//Creamos este objeto para poder abrir un fichero de tipo binario
			FileInputStream fileInputStream = new FileInputStream(nombreFichero);
			//Creamos este objeto para poder traducir el c�digo binario a Java
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			do {
				//Leemos un dato de tipo String
				String instrucciones = dataInputStream.readUTF();
				System.out.println(instrucciones);
				
				for (int i = 0; i < 4; i++) {
					int codEnfermedad = dataInputStream.readInt();
					System.out.println(codEnfermedad);
					
					String nombreEnfermedad = dataInputStream.readUTF();
					System.out.println(nombreEnfermedad);

					String colorEnfermedad = dataInputStream.readUTF();
					System.out.println(colorEnfermedad);
					System.out.println("--------------");
				}
				
				int coordenadaX = dataInputStream.readInt();
				System.out.println(coordenadaX);
				
				int coordenadaY = dataInputStream.readInt();
				System.out.println(coordenadaY);
				
				
	
			} while (true);
		//Cuando el programa acabe, saltar� esta excepci�n	
		}catch(EOFException e1) {
			System.out.println("Fichero le�do correctamente");
		} catch (FileNotFoundException e) {
			System.out.println("Ficheor no encontrado " + e);
		} catch (IOException e) {
			System.out.println("Ha habido un error de lectura " + e);
		}
		
		//--------------------------------------------------------------------------------------
		
		String linea = "";

		
	}

}

//Explicacion del fichero: Este fichero contiene los datos de las 4 enfermedades y los datos del tamaño
//del mapa para el que estan ajustadas las coordenadas. Los datos de las enfermedades están ordenados: 
//codigoEnfermedad (int), nombreEnfermedad(String) y colorEnfermeda (String) para las 4 enfermedades.
//Después están las cordenadas x y que son dos (int)




