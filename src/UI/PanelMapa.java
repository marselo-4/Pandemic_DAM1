package UI;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Clases.CiudadBoton;

public class PanelMapa extends JPanel implements ActionListener, ItemListener {
	


    private ImageIcon icon;
    private Image scaledImage;
    ButtonGroup IconosCiudades = new ButtonGroup();


    public PanelMapa() { // testea botones si funcionan todos con print
        icon = new ImageIcon("img/mapa.jpg");  //Ruta actualizada
       scaleImage();
       setLayout(null);
     
       CiudadBoton SanFrancisco = new CiudadBoton("Azul"); 
       crearBotonciudad(SanFrancisco, "img/IconoCiudadAzul.png",  100, 295,  35,  35);

       CiudadBoton Chicago = new CiudadBoton("Azul"); 
       crearBotonciudad(Chicago, "img/IconoCiudadAzul.png",  269,  279,  35,  35);

       CiudadBoton Atlanta = new CiudadBoton("Azul"); 
       crearBotonciudad(Atlanta, "img/IconoCiudadAzul.png",  270,  315,  35,  35);

       CiudadBoton Montreal = new CiudadBoton("Azul"); 
       crearBotonciudad(Montreal, "img/IconoCiudadAzul.png",  350,  230,  35,  35);

       CiudadBoton NuevaYork = new CiudadBoton("Azul"); 
       crearBotonciudad(NuevaYork, "img/IconoCiudadAzul.png",  350,  280,  35,  35);

       CiudadBoton Washington = new CiudadBoton("Azul"); 
       crearBotonciudad(Washington, "img/IconoCiudadAzul.png",  310,  300,  35,  35);

       CiudadBoton Londres = new CiudadBoton("Azul"); 
       crearBotonciudad(Londres, "img/IconoCiudadAzul.png",  700,  220,  35,  35);

       CiudadBoton Madrid = new CiudadBoton("Azul"); 
       crearBotonciudad(Madrid, "img/IconoCiudadAzul.png",  687,  290,  35,  35);

       CiudadBoton Paris = new CiudadBoton("Azul"); 
       crearBotonciudad(Paris, "img/IconoCiudadAzul.png",  727,  250,  35,  35);

       CiudadBoton Essen = new CiudadBoton("Azul"); 
      crearBotonciudad(Essen, "img/IconoCiudadAzul.png",  740,  225,  35,  35);

      CiudadBoton Milan = new CiudadBoton("Azul"); 
       crearBotonciudad(Milan, "img/IconoCiudadAzul.png",  755,  255,  35,  35);

       CiudadBoton SanPetersburgo = new CiudadBoton("Azul"); 
       crearBotonciudad(SanPetersburgo, "img/IconoCiudadAzul.png",  835,  200,  35,  35);

       CiudadBoton LosAngeles = new CiudadBoton("Amarillo"); 
       crearBotonciudad(LosAngeles, "img/IconoCiudadAmarillo.png",  110,  325,  35,  35);

       CiudadBoton Miami = new CiudadBoton("Amarillo"); 
       crearBotonciudad(Miami, "img/IconoCiudadAmarillo.png",  290,  370,  35,  35);

       CiudadBoton MexicoDF = new CiudadBoton("Amarillo"); 
       crearBotonciudad(MexicoDF, "img/IconoCiudadAmarillo.png",  180,  410,  35,  35);

       CiudadBoton Bogota = new CiudadBoton("Amarillo"); 
       crearBotonciudad(Bogota, "img/IconoCiudadAmarillo.png",  305,  490,  35,  35);

       CiudadBoton Lima = new CiudadBoton("Amarillo"); 
       crearBotonciudad(Lima, "img/IconoCiudadAmarillo.png",  290,  575,  35,  35);

       CiudadBoton Santiago = new CiudadBoton("Amarillo"); 
       crearBotonciudad(Santiago, "img/IconoCiudadAmarillo.png",  345,  685,  35,  35);

       CiudadBoton BuenosAires = new CiudadBoton("Amarillo"); 
       crearBotonciudad(BuenosAires, "img/IconoCiudadAmarillo.png",  410,  720,  35,  35);

       CiudadBoton SaoPaulo = new CiudadBoton("Amarillo"); 
       crearBotonciudad(SaoPaulo, "img/IconoCiudadAmarillo.png",  460,  650,  35,  35);

       CiudadBoton Lagos = new CiudadBoton("Amarillo"); 
       crearBotonciudad(Lagos, "img/IconoCiudadAmarillo.png",  665,  305,  35,  35);

       CiudadBoton Kinsasa = new CiudadBoton("Amarillo"); 
       crearBotonciudad(Kinsasa, "img/IconoCiudadAmarillo.png",  795,  540,  35,  35);

       CiudadBoton Jartum = new CiudadBoton("Amarillo"); 
       crearBotonciudad(Jartum, "img/IconoCiudadAmarillo.png",  875,  430,  35,  35);

       CiudadBoton Johannesburgo = new CiudadBoton("Amarillo"); 
       crearBotonciudad(Johannesburgo, "img/IconoCiudadAmarillo.png",  840,  655,  35,  35);

       CiudadBoton Argel = new CiudadBoton("Verde"); 
        crearBotonciudad(Argel, "img/IconoCiudadVerde.png",  725,  330, 35,  35);
 
        CiudadBoton ElCairo = new CiudadBoton("Verde"); 
        crearBotonciudad(ElCairo, "img/IconoCiudadVerde.png",  855,  365,  35,  35);
 
        CiudadBoton Riad = new CiudadBoton("Verde"); 
        crearBotonciudad(Riad, "img/IconoCiudadVerde.png",  945,  385,  35,  35);
 
        CiudadBoton Estambul = new CiudadBoton("Verde"); 
        crearBotonciudad(Estambul, "img/IconoCiudadVerde.png",  835,  290,  35,  35);
 
        CiudadBoton Bagdad = new CiudadBoton("Verde"); 
        crearBotonciudad(Bagdad, "img/IconoCiudadVerde.png",  925,  340,  35,  35);
 
        CiudadBoton Moscu = new CiudadBoton("Verde"); 
        crearBotonciudad(Moscu, "img/IconoCiudadVerde.png",  895,  215,  35,  35);
 
        CiudadBoton Teheran = new CiudadBoton("Verde"); 
        crearBotonciudad(Teheran, "img/IconoCiudadVerde.png",  965,  325,  35,  35);
 
        CiudadBoton Karachi = new CiudadBoton("Verde"); 
        crearBotonciudad(Karachi, "img/IconoCiudadVerde.png",  1050,  375,  35,  35);
 
        CiudadBoton Bombay = new CiudadBoton("Verde"); 
        crearBotonciudad(Bombay, "img/IconoCiudadVerde.png",  1100,  415,  35,  35);
       
        CiudadBoton NuevaDelhi = new CiudadBoton("Verde"); 
        crearBotonciudad(NuevaDelhi, "img/IconoCiudadVerde.png",  1120,  370,  35,  35);
 
        CiudadBoton Calcuta = new CiudadBoton("Verde"); 
        crearBotonciudad(Calcuta, "img/IconoCiudadVerde.png",  1160,  405,  35,  35);
 
        CiudadBoton Madras = new CiudadBoton("Verde"); 
        crearBotonciudad(Madras, "img/IconoCiudadVerde.png",  1130,  450,  35,  35);
 
        CiudadBoton Yakarta = new CiudadBoton("Rojo"); 
        crearBotonciudad(Yakarta, "img/IconoCiudadRojo.png",  1285,  565,  35,  35);
 
        CiudadBoton Bangkok = new CiudadBoton("Rojo"); 
        crearBotonciudad(Bangkok, "img/IconoCiudadRojo.png",  1245,  450,  35,  35);
 
        CiudadBoton HongKong = new CiudadBoton("Rojo"); 
        crearBotonciudad(HongKong, "img/IconoCiudadRojo.png",  1315,  395,  35,  35);
 
        CiudadBoton Shanghai = new CiudadBoton("Rojo"); 
        crearBotonciudad(Shanghai, "img/IconoCiudadRojo.png",  1325,  350,  35,  35);
 
        CiudadBoton Pekin = new CiudadBoton("Rojo"); 
        crearBotonciudad(Pekin, "img/IconoCiudadRojo.png",  1290,  295,  35,  35);
 
        CiudadBoton Seul = new CiudadBoton("Rojo"); 
        crearBotonciudad(Seul, "img/IconoCiudadRojo.png",  1350,  320,  35,  35);
 
        CiudadBoton Tokio = new CiudadBoton("Rojo"); 
        crearBotonciudad(Tokio, "img/IconoCiudadRojo.png",  1415,  315,  35,  35);
 
        CiudadBoton Osaka = new CiudadBoton("Rojo"); 
        crearBotonciudad(Osaka, "img/IconoCiudadRojo.png",  1390,  330,  35,  35);
 
        CiudadBoton Taipei = new CiudadBoton("Rojo"); 
        crearBotonciudad(Taipei, "img/IconoCiudadRojo.png",  1350,  375,  35,  35);
 
        CiudadBoton HoChiMinh = new CiudadBoton("Rojo"); 
        crearBotonciudad(HoChiMinh, "img/IconoCiudadRojo.png",  1280,  450,  35,  35);
 
        CiudadBoton Manila = new CiudadBoton("Rojo"); 
        crearBotonciudad(Manila, "img/IconoCiudadRojo.png",  1350,  440,  35,  35);
 
        CiudadBoton Sidney = new CiudadBoton("Rojo"); 
        crearBotonciudad(Sidney, "img/IconoCiudadRojo.png",  1480,  710,  35,  35);       
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
    
    public void crearBotonciudad(CiudadBoton Ciudad, String rutaimg, int x, int y, int w, int h) {

        Ciudad.setOpaque(false);
        Ciudad.setBorderPainted(false);
        Ciudad.setContentAreaFilled(false);
        Ciudad.setBounds(x, y, w, h );
        ImageIcon icono = new ImageIcon(new ImageIcon(rutaimg).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
        Ciudad.setIcon(icono);
        IconosCiudades.add(Ciudad);
        add(Ciudad);
        Ciudad.addItemListener(this);
        Ciudad.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent e) {
    	CiudadBoton selectedButton = (CiudadBoton) e.getSource();
    	ImageIcon iconoVerde = new ImageIcon("img/IconoCiudadVerde.png");
    	ImageIcon iconoAzul = new ImageIcon("img/IconoCiudadAzul.png");
    	ImageIcon iconoRojo = new ImageIcon("img/IconoCiudadRojo.png");
    	ImageIcon iconoOAmarillo = new ImageIcon("img/IconoCiudadAmarillo.png");

    	ImageIcon imagenEscaladaVerde = new ImageIcon(new ImageIcon("img/IconoCiudadVerde.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    	ImageIcon imagenEscaladaAzul = new ImageIcon(new ImageIcon("img/IconoCiudadAzul.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    	ImageIcon imagenEscaladaRojo = new ImageIcon(new ImageIcon("img/IconoCiudadRojo.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    	ImageIcon imagenEscaladaAmarillo = new ImageIcon(new ImageIcon("img/IconoCiudadAmarillo.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

    	if (e.getSource() instanceof CiudadBoton) {
            if (selectedButton.getColor().equals("Azul")) {
            	selectedButton.setIcon(imagenEscaladaAzul);
            	selectedButton.setSize(50,50);
			}else if (selectedButton.getColor().equals("Rojo")) {
            	selectedButton.setIcon(imagenEscaladaRojo);
            	selectedButton.setSize(50,50);
			}else if (selectedButton.getColor().equals("Verde")) {
            	selectedButton.setIcon(imagenEscaladaVerde);
            	selectedButton.setSize(50,50);
			}else if (selectedButton.getColor().equals("Amarillo")) {
            	selectedButton.setIcon(imagenEscaladaAmarillo);
            	selectedButton.setSize(50,50);
			}
        } 
    }


    
    public void itemStateChanged(ItemEvent e) {
    	CiudadBoton selectedButton = (CiudadBoton) e.getSource();
    	ImageIcon iconoVerde = new ImageIcon("img/IconoCiudadVerde.png");
    	ImageIcon iconoAzul = new ImageIcon("img/IconoCiudadAzul.png");
    	ImageIcon iconoRojo = new ImageIcon("img/IconoCiudadRojo.png");
    	ImageIcon iconoOAmarillo = new ImageIcon("img/IconoCiudadAmarillo.png");

    	ImageIcon imagenEscaladaVerde = new ImageIcon(new ImageIcon("img/IconoCiudadVerde.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
    	ImageIcon imagenEscaladaAzul = new ImageIcon(new ImageIcon("img/IconoCiudadAzul.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
    	ImageIcon imagenEscaladaRojo = new ImageIcon(new ImageIcon("img/IconoCiudadRojo.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
    	ImageIcon imagenEscaladaAmarillo = new ImageIcon(new ImageIcon("img/IconoCiudadAmarillo.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));

    	if (e.getSource() instanceof CiudadBoton) {
            if (selectedButton.getColor().equals("Azul")) {
            	selectedButton.setIcon(imagenEscaladaAzul);
            	selectedButton.setSize(35,35);
			}else if (selectedButton.getColor().equals("Rojo")) {
            	selectedButton.setIcon(imagenEscaladaRojo);
            	selectedButton.setSize(35,35);
			}else if (selectedButton.getColor().equals("Verde")) {
            	selectedButton.setIcon(imagenEscaladaVerde);
            	selectedButton.setSize(35,35);
			}else if (selectedButton.getColor().equals("Amarillo")) {
            	selectedButton.setIcon(imagenEscaladaAmarillo);
            	selectedButton.setSize(35,35);
			}
        } 

    }
}
