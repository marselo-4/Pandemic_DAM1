import javax.swing.*;
import java.awt.*;

public class Marco extends JFrame {

    public PanelPrincipal lamina;
    public Marco(){

        GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (screen.isFullScreenSupported()) {
            setResizable(true);
            screen.setFullScreenWindow(this);
        } else {
            setSize(800, 600);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pandemic");
        ImageIcon icono = new ImageIcon("src/assets/icon.png");
        setIconImage(icono.getImage());
        lamina = new PanelPrincipal();
        add(lamina);

        setVisible(true);
    }
}
