package Clases;

public class Vacuna {
	private String nombre;
	private String color;
	private int porcentaje;
	
	public Vacuna(String nombre, String color, int porcentaje) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.porcentaje = porcentaje;
	}
	public static void desarrollarVacuna(float personaje) {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
}
