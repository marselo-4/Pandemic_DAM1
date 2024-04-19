package programa;

import java.util.ArrayList;

public class datosPartida {

	public static ArrayList<Ciudades> ciudades = new ArrayList<>();	
	public static ArrayList<Virus> virus = new ArrayList<>();
	public static ArrayList<Vacuna> vacuna = new ArrayList<>();
	private int brotes;
	
	private static int brotes_maximos;
	private static int pDesarrollo;
	private static int propagacion_ronda;
	private static int propagacion_inicio;
	
	private int rondas;
	private int acciones;
	
	public static void modificarCiudad(String nCiudad, int modificacion) {
		
	}
	
	public static void modificarVacuna(String nVacuna, int modificacion) {
		
	}
	
	public static void cargarDatos() {
		
		parametros.cargarXML(pDesarrollo, brotes_maximos, propagacion_ronda, propagacion_inicio);
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

	public static float getpDesarrollo() {
		return pDesarrollo;
	}

	public void setpDesarrollo(int pDesarrollo) {
		this.pDesarrollo = pDesarrollo;
	}

	public int getAcciones() {
		return acciones;
	}

	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}

	public static int getBrotes_maximos() {
		return brotes_maximos;
	}

	public void setBrotes_maximos(int brotes_maximos) {
		this.brotes_maximos = brotes_maximos;
	}

	public static int getPropagacion_ronda() {
		return propagacion_ronda;
	}

	public void setPropagacion_ronda(int propagacion_ronda) {
		this.propagacion_ronda = propagacion_ronda;
	}

	public static int getPropagacion_inicio() {
		return propagacion_inicio;
	}

	public void setPropagacion_inicio(int propagacion_inicio) {
		this.propagacion_inicio = propagacion_inicio;
	}
	
}
