import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevaPartida extends JPanel implements ActionListener {

    JButton volver;
    JLabel info;
    JLabel texto;

    public NuevaPartida() {
        setLayout(new FlowLayout());
        info = new JLabel("Nueva Partida");
        texto = new JLabel("lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.");

        // Hay que poner un fondo de ventana con toda la info, no liarse

        volver = new JButton("Volver");

        volver.addActionListener(this);

        add(info);
        add(texto);
        add(volver);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volver) {
            JFrame marco = (JFrame)SwingUtilities.getWindowAncestor(this);
            marco.remove(this);
            marco.add(new PanelPrincipal());
            marco.setVisible(true);
        }
    }
}
