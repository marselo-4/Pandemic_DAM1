package UI;

import javax.swing.*;
import java.awt.*;
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

		// Añadir borde verde chillón
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 20), 2));

		agregarCajadialogo();
	}

	

	public void agregarCajadialogo() {
		Font fuentePersonalizada = new Font("DisposableDroid BB", Font.PLAIN, 30);
		JPanel panelCaja = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Usa FlowLayout centrado sin espacios
		panelCaja.setBackground(new Color(20, 20, 30));
		Caja = new JTextArea();
		panelCaja.add(Caja);
		Caja.setEditable(false);
		Caja.setPreferredSize(new Dimension(700, 117));
		Caja.setFont(fuentePersonalizada);

		Caja.setBackground(Color.white);
		Caja.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(panelCaja, BorderLayout.CENTER);

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
