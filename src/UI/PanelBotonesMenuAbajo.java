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

    public PanelBotonesMenuAbajo() {
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("img/tierraR.gif");
        ImageIcon iconoguardar = new ImageIcon("img/guardar.png");
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



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
