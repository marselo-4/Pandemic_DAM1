package Clases;

import javax.swing.*;
import java.awt.*;

public class CiudadBoton extends JRadioButton {
	private Ciudades ciudad;
	boolean haBrotado = false;


	public CiudadBoton() {
		super();

	}

	public Ciudades getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudades ciudad) {
		this.ciudad = ciudad;
	}
	
	public void linkearCiudad() {
		
	}
	
	public boolean getHaBrotado() {
		return haBrotado;
	}

	public void setHaBrotado(boolean haBrotado) {
		this.haBrotado = haBrotado;
	}

}
