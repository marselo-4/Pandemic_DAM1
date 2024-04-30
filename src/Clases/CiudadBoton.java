package Clases;

import javax.swing.*;
import java.awt.*;

public class CiudadBoton extends JRadioButton {
	private String color;
    
    public CiudadBoton(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
    
    


}
