package Clases;

import javax.swing.*;
import java.awt.*;

public class VacunaBoton extends JRadioButton {
	private Vacuna vacuna;

	public VacunaBoton() {
		super();

	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}



}
