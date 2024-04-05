package programa;
import java.util.ArrayList;

public class Ciudades {

	private String nombre;
	private int enfermedad;
	private int[] coords = new int[2];
	ArrayList<String> colindantes =  new ArrayList<>();
	
	public Ciudades(String nombre, int enfermedad, int[] coords, ArrayList<String> colindantes) {
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

	public int getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(int enfermedad) {
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
	
}
