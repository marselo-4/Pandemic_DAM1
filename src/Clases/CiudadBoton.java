package Clases;

import javax.swing.*;
import java.awt.*;

public class CiudadBoton extends JRadioButton {
	private Ciudades ciudad;

	public CiudadBoton(Ciudades ciudad) {
		super();
		this.ciudad = ciudad;
	}

	public Ciudades getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudades ciudad) {
		this.ciudad = ciudad;
	}

}
