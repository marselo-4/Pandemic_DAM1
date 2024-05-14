package UI;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Nickname extends JPanel  {
    private static String NombreJ = "";
    private BufferedImage fondo;
    private JTextArea textArea;

    public Nickname() {
    	setSize(1920,1080);
        try {
            fondo = ImageIO.read(new File("src/assets/Nickname.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setPreferredSize(new Dimension(fondo.getWidth(), fondo.getHeight()));

        // Establece el layout a null para poder posicionar manualmente los componentes
        setLayout(null);

        // Crea y configura el JTextArea
        textArea = new JTextArea();
        textArea.setBounds(400, 520, 1100, 200); // Establece la posición y tamaño de la JTextArea
        textArea.setOpaque(false);
        
        Color colorpandemic = new Color(254, 185, 30);
        
        textArea.setForeground(colorpandemic); 

        File fontFile = new File("fonts/DisposableDroidBB.ttf");
        Font fuentePersonalizada = null;
        try {
            fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            fuentePersonalizada = fuentePersonalizada.deriveFont(150f); 
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        textArea.setFont(fuentePersonalizada);
       
        add(textArea);

        // Crea y configura el botón "Guardar"
        JButton guardarButton = new JButton();
        guardarButton.setBounds(700, 700, 500, 300); // Establece la posición y tamaño del botón

        // Cargar imagen del botón
        ImageIcon iconoBoton = new ImageIcon("src/assets/BtnOK.png");
        guardarButton.setIcon(iconoBoton);
        guardarButton.setBorderPainted(false);
        guardarButton.setContentAreaFilled(false);
        guardarButton.setFocusPainted(false);
        guardarButton.setOpaque(false);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Cargar el archivo de sonido
                    File soundFile = new File("src/assets/gfx/selec.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    
                    // Obtener un clip de sonido
                    Clip clip = AudioSystem.getClip();
                    
                    // Abrir el flujo de audio y cargar datos
                    clip.open(audioIn);
                    
                    // Reproducir el sonido
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    e1.printStackTrace();
                }
            	if (e.getSource() == guardarButton) {
            		 NombreJ = textArea.getText();
                     System.out.println(NombreJ);
                     Component component = (Component) e.getSource();
                     JFrame marco = (JFrame) SwingUtilities.getRoot(component);
                     marco.getContentPane().remove(Nickname.this);
                     marco.getContentPane().add(new NuevaPartida());
                     marco.setSize(1920, 1080);
                     marco.setVisible(true);
            }
            }

         
        });
        add(guardarButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, null);
    }

    public static String getNombreJ() {
        return NombreJ;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Nickname");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Nickname panel = new Nickname();
            frame.add(panel);

            frame.pack();
            frame.setLocationRelativeTo(null); // Centrar el frame
            frame.setVisible(true);
        });
    }
}
