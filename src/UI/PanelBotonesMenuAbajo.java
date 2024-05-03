package UI;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PanelBotonesMenuAbajo extends JPanel implements ActionListener {

    private static JTextPane Caja;
    public JButton acciones;

    public PanelBotonesMenuAbajo() {
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("img/tierraR.gif");
        ImageIcon iconoguardar = new ImageIcon("img/guardar.png");
        displayAcciones(); // MIRAR
        JLabel lbl = new JLabel(icon);
        lbl.setPreferredSize(new Dimension(150, 100));
        add(lbl, BorderLayout.EAST);
        JButton lbl2 = new JButton(iconoguardar);
        add(lbl2, BorderLayout.WEST);
        lbl2.setContentAreaFilled(false);
        lbl2.setBorderPainted(false);
        lbl2.setFocusPainted(false);
        lbl2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Falta implementar la lógica de guardar partida.
            	
                System.out.println("Se ha guardado la partida");
            }
        });
        this.setBackground(new Color(0, 0, 0));
        setPreferredSize(new Dimension(150, 125));

        agregarCajadialogo();
    }
    
    

    public void agregarCajadialogo() {
        File fontFile = new File("fonts/DisposableDroidBB.ttf");
        Font fuentePersonalizada = null;

        try {
            fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            fuentePersonalizada = fuentePersonalizada.deriveFont(25f);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JPanel panelCaja = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelCaja.setBackground(new Color(0, 0, 0));
        Caja = new JTextPane();
        panelCaja.add(Caja);
        Caja.setEditable(false);
        Caja.setPreferredSize(new Dimension(700, 117));
        Caja.setForeground(Color.WHITE);
        Caja.setBackground(new Color(0));
        panelCaja.setAlignmentX(CENTER_ALIGNMENT);
        add(panelCaja, BorderLayout.CENTER);

        if (fuentePersonalizada != null) {
            Caja.setFont(fuentePersonalizada);
        } else {
            Caja.setFont(new Font("Arial", Font.PLAIN, 12));
        }

        // Centrar el texto horizontalmente
        StyledDocument doc = Caja.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    public static void textosCaja(String texto) {
        new Thread(() -> {
            for (int i = 0; i <= texto.length(); i++) {
                final int index = i;
                SwingUtilities.invokeLater(() -> {
                    Caja.setText(texto.substring(0, index));
                });
                try {
                    TimeUnit.MILLISECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    public void displayAcciones() { // REVISAR
    	
    	String source = "src/images/imagen1.jpg";// Mu he inventat
    	acciones = new JButton();
    	int accionesRestantes = 3;
    	
    	if(accionesRestantes == 3) {
    		source = "src/images/imagen4";// Mu he inventat
    	}else if (accionesRestantes == 2) {
    		source = "src/images/imagen3";// Mu he inventat
    	}else if (accionesRestantes == 1) {
    		source = "src/images/imagen2";// Mu he inventat
    	}else if (accionesRestantes == 0) {
    		source = "src/images/imagen1";// Mu he inventat
    	}
    	acciones.setIcon(new ImageIcon(new ImageIcon(source).getImage().getScaledInstance(300, 30, java.awt.Image.SCALE_SMOOTH)));
        acciones.setPreferredSize(new Dimension(100, 100));
    	add(acciones, BorderLayout.EAST);
    	

    	
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
