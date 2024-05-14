package Clases;
import java.util.ArrayList;

public class Ciudades {

	private String nombre;
	private String enfermedad;
	private int infeccion;
	private int[] coords = new int[2];
	ArrayList<String> colindantes =  new ArrayList<>();
	
	public Ciudades(String nombre, String enfermedad, int[] coords, ArrayList<String> colindantes) {
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.coords = coords;
		this.colindantes = colindantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public int[] getCoords() {
		return coords;
	}

	public void setCoords(int[] coords) {
		this.coords = coords;
	}

	public ArrayList<String> getColindantes() {
		return colindantes;
	}

	public void setColindantes(ArrayList<String> colindantes) {
		this.colindantes = colindantes;
	}
	
	public int getInfeccion() {
		return infeccion;
	}

	public void setInfeccion(int infeccion) {
		this.infeccion = infeccion;
	}

	
}
