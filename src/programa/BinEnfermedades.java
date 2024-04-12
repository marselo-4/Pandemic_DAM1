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
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class BinEnfermedades {

	public BinEnfermedades() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//Obrir el fitxer bin y llegirt la primera linea String per veure les instruccions
		
		
		//Despres printear totes les ciutats amb la seva enfermetat corresponent.
		
		
		
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
		
		String nombreFichero3 = "ciudades.txt";

		try {
			// Creamos un objeto de tipo FileReader para abrir un fichero de lectura
			FileReader fileReader = new FileReader(nombreFichero);
			// Utilizamos el Buffered para recibir lo que hay en el fichero y transformarlo
			// en c�digo Java
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linea = null;
			do {
				// Leemos el contenido del fichero
				linea = bufferedReader.readLine();
				
				// Si no ha acabado de leer el fichero, printamos el valor de l�nea
				if (linea != null) {
					System.out.println(linea);
				}
			} while (linea != null);

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String nombreFichero2 = "ciudades-enfermedades.bin";
		
		try {
			//Lo utilizamos para crear el fichero a partir del nombre
			FileOutputStream fileOutputStream = new FileOutputStream(nombreFichero2);
			//Este objeto traduce todos los datos de Java a binario
			DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
			
//			dataOutputStream.writeUTF();
//			
//			
//			dataOutputStream.writeInt();
//			
//	
//			dataOutputStream.writeFloat();
			
			dataOutputStream.close();
			fileOutputStream.close();
		//Capturamos el error cuando el fichero indicado no exista
		} catch (FileNotFoundException e1) {
			System.out.println("Fichero no encontrado " + e1);
		//Capturamos el error si ha habido un error de escrtura
		} catch (IOException e) {
			System.out.println("Error en la escritura del fichero " + e);
		//Capturamos el error si en el scanner nos env�an una letra en vez de un n�mero en el nextInt()
		} catch (InputMismatchException e2) {
			System.out.println("Ha habido al leer los datos del usuario");
		//Capturamos cualquier otra excepci�n
		} catch (Exception e3) {
			System.out.println("Ha habido un error no controlado " + e3);
		}
		
	}

}

//Explicacion del fichero: Este fichero contiene los datos de las 4 enfermedades y los datos del tamaño
//del mapa para el que estan ajustadas las coordenadas. Los datos de las enfermedades están ordenados: 
//codigoEnfermedad (int), nombreEnfermedad(String) y colorEnfermeda (String) para las 4 enfermedades.
//Después están las cordenadas x y que son dos (int)







