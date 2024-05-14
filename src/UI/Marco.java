package UI;
import javax.swing.*;
import java.awt.*;

public class Marco extends JFrame {

    public PanelPrincipal lamina; // lamina
    public Marco(){

    	setSize(1920,1080);
    	Toolkit.getDefaultToolkit().getScreenSize();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pandemic");
        ImageIcon icono = new ImageIcon("src/assets/icon.png");
        setIconImage(icono.getImage());
        lamina = new PanelPrincipal();
        add(lamina);

        setVisible(true);
        
        
    }
}
