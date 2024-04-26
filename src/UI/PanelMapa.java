package UI;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelMapa extends JPanel {
    private ImageIcon icon;
    private Image scaledImage;

    public PanelMapa() {
        icon = new ImageIcon("img/mapa.jpg"); // Ruta actualizada
       scaleImage();
       AñadirBotonesCiudades();
    }

    private void scaleImage() {
        if (getWidth() > 0 && getHeight() > 0) {
            scaledImage = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (scaledImage != null) {
            g.drawImage(scaledImage, 0, 0, this);
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
        scaleImage();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }
    
    
    public  void AñadirBotonesCiudades(){
        ButtonGroup IconosCiudades = new ButtonGroup();
        
        
        JRadioButton sanFranciscoRadioButton = new JRadioButton();
        sanFranciscoRadioButton.setOpaque(false);
        sanFranciscoRadioButton.setBorderPainted(false);
        sanFranciscoRadioButton.setContentAreaFilled(false);
        sanFranciscoRadioButton.setBounds(50, 50, 150, 30);
        IconosCiudades.add(sanFranciscoRadioButton);
        add(sanFranciscoRadioButton);
         ImageIcon icono = new ImageIcon(new ImageIcon("img/iconoCiudadNaranja.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
         sanFranciscoRadioButton.setIcon(icono);


        JRadioButton chicagoRadioButton = new JRadioButton("Chicago");
        JRadioButton atlantaRadioButton = new JRadioButton("Atlanta");
        JRadioButton montrealRadioButton = new JRadioButton("Montreal");
        JRadioButton nuevaYorkRadioButton = new JRadioButton("Nueva York");
        JRadioButton washingtonRadioButton = new JRadioButton("Washington");
        JRadioButton londresRadioButton = new JRadioButton("Londres");
        JRadioButton madridRadioButton = new JRadioButton("Madrid");
        JRadioButton parisRadioButton = new JRadioButton("Paris");
        JRadioButton essenRadioButton = new JRadioButton("Essen");
        JRadioButton milanRadioButton = new JRadioButton("Milan");
        JRadioButton sanPetersburgoRadioButton = new JRadioButton("San Petersburgo");
        JRadioButton losAngelesRadioButton = new JRadioButton("Los Angeles");
        JRadioButton miamiRadioButton = new JRadioButton("Miami");
        JRadioButton mexicoDFRadioButton = new JRadioButton("Mexico DF");
        JRadioButton bogotaRadioButton = new JRadioButton("Bogota");
        JRadioButton limaRadioButton = new JRadioButton("Lima");
        JRadioButton santiagoDeChileRadioButton = new JRadioButton("Santiago de Chile");
        JRadioButton buenosAiresRadioButton = new JRadioButton("Buenos Aires");
        JRadioButton saoPauloRadioButton = new JRadioButton("Sao Paulo");
        JRadioButton lagosRadioButton = new JRadioButton("Lagos");
        JRadioButton kinsasaRadioButton = new JRadioButton("Kinsasa");
        JRadioButton jartumRadioButton = new JRadioButton("Jartum");
        JRadioButton johannesburgoRadioButton = new JRadioButton("Johannesburgo");
        JRadioButton argelRadioButton = new JRadioButton("Argel");
        JRadioButton elCairoRadioButton = new JRadioButton("El Cairo");
        JRadioButton riadRadioButton = new JRadioButton("Riad");
        JRadioButton estambulRadioButton = new JRadioButton("Estambul");
        JRadioButton bagdadRadioButton = new JRadioButton("Bagdad");
        JRadioButton moscuRadioButton = new JRadioButton("Moscu");
        JRadioButton teheranRadioButton = new JRadioButton("Teheran");
        JRadioButton karachiRadioButton = new JRadioButton("Karachi");
        JRadioButton bombayRadioButton = new JRadioButton("Bombay");
        JRadioButton nuevaDelhiRadioButton = new JRadioButton("Nueva Delhi");
        JRadioButton calcutaRadioButton = new JRadioButton("Calcuta");
        JRadioButton madrasRadioButton = new JRadioButton("Madras");
        JRadioButton yakartaRadioButton = new JRadioButton("Yakarta");
        JRadioButton bangkokRadioButton = new JRadioButton("Bangkok");
        JRadioButton hongKongRadioButton = new JRadioButton("Hong Kong");
        JRadioButton shanghaiRadioButton = new JRadioButton("Shanghai");
        JRadioButton pekinRadioButton = new JRadioButton("Pekin");
        JRadioButton seulRadioButton = new JRadioButton("Seul");
        JRadioButton tokioRadioButton = new JRadioButton("Tokio");
        JRadioButton osakaRadioButton = new JRadioButton("Osaka");
        JRadioButton taipeiRadioButton = new JRadioButton("Taipei");
        JRadioButton hoChiMinhRadioButton = new JRadioButton("Ho Chi Minh");
        JRadioButton manilaRadioButton = new JRadioButton("Manila");
        JRadioButton sidneyRadioButton = new JRadioButton("Sidney");


    	
    }
    
}
