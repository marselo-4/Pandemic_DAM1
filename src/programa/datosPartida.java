package programa;

import java.util.ArrayList;

public class datosPartida {

	public static ArrayList<Ciudades> ciudades = new ArrayList<>();	
	public static ArrayList<Virus> virus = new ArrayList<>();
	public static ArrayList<Vacuna> vacuna = new ArrayList<>();
	private int brotes;
	private int rondas;
	private float pDesarrollo;
	private int acciones;
	
	public static void modificarCiudad(String nCiudad, int modificacion) {
		
	}
	
	public static void modificarVacuna(String nVacuna, int modificacion) {
		
	}
	
	public static void cargarDatos() {
		
	}

	public int getBrotes() {
		return brotes;
	}

	public void setBrotes(int brotes) {
		this.brotes = brotes;
	}

	public int getRondas() {
		return rondas;
	}

	public void setRondas(int rondas) {
		this.rondas = rondas;
	}

	public float getpDesarrollo() {
		return pDesarrollo;
	}

	public void setpDesarrollo(float pDesarrollo) {
		this.pDesarrollo = pDesarrollo;
	}

	public int getAcciones() {
		return acciones;
	}

	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}
	
}
