package UI;

import javax.swing.*;

import Backend.logicaJuego;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PanelBotonesMenuAbajo extends JPanel {

	public static JLabel lblAcciones = new JLabel();
	public static JLabel lblTurno = new JLabel();
	public static JTextArea Caja;

	public PanelBotonesMenuAbajo() {
		// setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Usar BoxLayout
		// horizontal
		
		setLayout(new BorderLayout());

		// Espacio en blanco para empujar el JLabel hacia la derecha
		add(Box.createHorizontalGlue());

		this.setBackground(new Color(20, 20, 30)); // Fondo negro azulado
		setPreferredSize(new Dimension(150, 125)); // Ajustar tamaño del panel



		agregarCajadialogo();
	}

	

public void agregarCajadialogo() {
    File fontFile = new File("fonts/DisposableDroidBB.ttf");
    Font fuentePersonalizada = null;
    
    try {
        fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        fuentePersonalizada = fuentePersonalizada.deriveFont(25f); // Modifica el tamaño
    } catch (IOException | FontFormatException e) {
        e.printStackTrace();
    }
    
    JPanel panelSuperior = new JPanel();
    panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS)); // Usar BoxLayout horizontal
    panelSuperior.setBackground(new Color(20, 20, 30));
    
    lblAcciones.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
    
    
    lblAcciones.setForeground(Color.WHITE);
    lblAcciones.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // Agregar margen a la derecha
    panelSuperior.add(lblAcciones);
    panelSuperior.add(Box.createHorizontalStrut(20)); // Espacio horizontal entre Acciones y Turno
    
    
    lblTurno.setForeground(Color.WHITE);
    panelSuperior.add(lblTurno);
    
    JPanel panelCaja = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    panelCaja.setBackground(new Color(20, 20, 30));
    Caja = new JTextArea();
    panelCaja.add(Caja);
    Caja.setEditable(false);
    Caja.setLineWrap(true);
    Caja.setWrapStyleWord(true);
    Caja.setPreferredSize(new Dimension(500, 117));
    Caja.setForeground(Color.WHITE); 
    Caja.setBackground(new Color(20, 20, 30));
    panelSuperior.add(panelCaja);
    
    JButton btnFinalizarTurno = new JButton("Finalizar turno");
    btnFinalizarTurno.setForeground(Color.WHITE);
    btnFinalizarTurno.setBackground(new Color(50, 50, 100));
    btnFinalizarTurno.setFocusPainted(false);
    btnFinalizarTurno.addActionListener(e -> {
        // Lógica para finalizar el turno
    });
    panelSuperior.add(btnFinalizarTurno);
    
    add(panelSuperior, BorderLayout.NORTH);

    if (fuentePersonalizada != null) {
        Caja.setFont(fuentePersonalizada);
        lblTurno.setFont(fuentePersonalizada);
        lblAcciones.setFont(fuentePersonalizada);
        btnFinalizarTurno.setFont(fuentePersonalizada);
    } else {
        // Fuente predeterminada en caso de que la fuente no se cargue correctamente
        Caja.setFont(new Font("Arial", Font.PLAIN, 12));
        lblAcciones.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTurno.setFont(new Font("Arial", Font.PLAIN, 12));
        btnFinalizarTurno.setFont(new Font("Arial", Font.PLAIN, 12));
    }
}


}
