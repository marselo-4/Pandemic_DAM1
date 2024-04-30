package UI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PanelBotonesMenuAbajo extends JPanel {

	private static JTextArea Caja;

	public PanelBotonesMenuAbajo() {
		// setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Usar BoxLayout
		// horizontal
		
		setLayout(new BorderLayout());

		// Espacio en blanco para empujar el JLabel hacia la derecha
		add(Box.createHorizontalGlue());

		ImageIcon icon = new ImageIcon("img/tierraR.gif");

		JLabel lbl = new JLabel(icon);

		// Establecer tamaño del JLabel
		lbl.setPreferredSize(new Dimension(150, 100));

		// Añadir el JLabel al panel
		add(lbl, BorderLayout.EAST);

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
    
    JPanel panelCaja = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    panelCaja.setBackground(new Color(20, 20, 30));
    Caja = new JTextArea();
    panelCaja.add(Caja);
    Caja.setEditable(false);
    Caja.setLineWrap(true);
    Caja.setWrapStyleWord(true);
    Caja.setPreferredSize(new Dimension(700, 117));
    Caja.setForeground(Color.WHITE); 
    Caja.setBackground(new Color(20, 20, 30));
    add(panelCaja, BorderLayout.CENTER);

    if (fuentePersonalizada != null) {
        Caja.setFont(fuentePersonalizada);
    } else {
        // Fuente predeterminada en caso de que la fuente no se cargue correctamente
        Caja.setFont(new Font("Arial", Font.PLAIN, 12));
    }
   
}


	public static void textosCaja(String texto) {
		// Creamos un hilo para el efecto de escritura
		new Thread(() -> {
			for (int i = 0; i <= texto.length(); i++) {
				final int index = i;
				// Actualizamos la caja de texto en el hilo de la interfaz de usuario (Swing)
				SwingUtilities.invokeLater(() -> {
					Caja.setText(texto.substring(0, index));
				});
				try {
					// Simulamos un pequeño retraso entre cada caracter para el efecto de escritura
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
