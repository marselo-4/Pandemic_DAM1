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
    ButtonGroup IconosCiudades = new ButtonGroup();


    public PanelMapa() {
        icon = new ImageIcon("img/mapa.jpg");  //Ruta actualizada
       scaleImage();
       AñadirBotonesCiudades();
       setLayout(null);
     
       JRadioButton SanFrancisco = new JRadioButton(); 
       crearBotonciudad(SanFrancisco, "img/IconoCiudadAzul.png",  100, 295,  35,  35);

       JRadioButton Chicago = new JRadioButton(); 
       crearBotonciudad(Chicago, "img/IconoCiudadAzul.png",  269,  279,  35,  35);

       JRadioButton Atlanta = new JRadioButton(); 
       crearBotonciudad(Atlanta, "img/IconoCiudadAzul.png",  270,  315,  35,  35);

       JRadioButton Montreal = new JRadioButton(); 
       crearBotonciudad(Montreal, "img/IconoCiudadAzul.png",  350,  230,  35,  35);

       JRadioButton NuevaYork = new JRadioButton(); 
       crearBotonciudad(NuevaYork, "img/IconoCiudadAzul.png",  350,  280,  35,  35);

       JRadioButton Washington = new JRadioButton(); 
       crearBotonciudad(Washington, "img/IconoCiudadAzul.png",  310,  300,  35,  35);

       JRadioButton Londres = new JRadioButton(); 
       crearBotonciudad(Londres, "img/IconoCiudadAzul.png",  700,  220,  35,  35);

       JRadioButton Madrid = new JRadioButton(); 
       crearBotonciudad(Madrid, "img/IconoCiudadAzul.png",  687,  290,  35,  35);

      JRadioButton Paris = new JRadioButton(); 
       crearBotonciudad(Paris, "img/IconoCiudadAzul.png",  727,  250,  35,  35);

       JRadioButton Essen = new JRadioButton(); 
      crearBotonciudad(Essen, "img/IconoCiudadAzul.png",  740,  225,  35,  35);

      JRadioButton Milan = new JRadioButton(); 
       crearBotonciudad(Milan, "img/IconoCiudadAzul.png",  755,  255,  35,  35);

       JRadioButton SanPetersburgo = new JRadioButton(); 
       crearBotonciudad(SanPetersburgo, "img/IconoCiudadAzul.png",  835,  200,  35,  35);

       JRadioButton LosAngeles = new JRadioButton(); 
       crearBotonciudad(LosAngeles, "img/IconoCiudadAmarillo.png",  110,  325,  35,  35);

       JRadioButton Miami = new JRadioButton(); 
       crearBotonciudad(Miami, "img/IconoCiudadAmarillo.png",  290,  370,  35,  35);

       JRadioButton MexicoDF = new JRadioButton(); 
       crearBotonciudad(MexicoDF, "img/IconoCiudadAmarillo.png",  180,  410,  35,  35);

       JRadioButton Bogota = new JRadioButton(); 
       crearBotonciudad(Bogota, "img/IconoCiudadAmarillo.png",  305,  490,  35,  35);

       JRadioButton Lima = new JRadioButton(); 
       crearBotonciudad(Lima, "img/IconoCiudadAmarillo.png",  290,  575,  35,  35);

       JRadioButton Santiago = new JRadioButton(); 
       crearBotonciudad(Santiago, "img/IconoCiudadAmarillo.png",  345,  685,  35,  35);

       JRadioButton BuenosAires = new JRadioButton(); 
       crearBotonciudad(BuenosAires, "img/IconoCiudadAmarillo.png",  410,  720,  35,  35);

       JRadioButton SaoPaulo = new JRadioButton(); 
       crearBotonciudad(SaoPaulo, "img/IconoCiudadAmarillo.png",  460,  650,  35,  35);

       JRadioButton Lagos = new JRadioButton(); 
       crearBotonciudad(Lagos, "img/IconoCiudadAmarillo.png",  665,  305,  35,  35);

       JRadioButton Kinsasa = new JRadioButton(); 
       crearBotonciudad(Kinsasa, "img/IconoCiudadAmarillo.png",  795,  540,  35,  35);

       JRadioButton Jartum = new JRadioButton(); 
       crearBotonciudad(Jartum, "img/IconoCiudadAmarillo.png",  875,  430,  35,  35);

       JRadioButton Johannesburgo = new JRadioButton(); 
       crearBotonciudad(Johannesburgo, "img/IconoCiudadAmarillo.png",  840,  655,  35,  35);

//        JRadioButton Argel = new JRadioButton(); 
//        crearBotonciudad(Argel, "img/IconoCiudadVerde.png",  730,  330, 35,  35);
// 
//        JRadioButton ElCairo = new JRadioButton(); 
//        crearBotonciudad(ElCairo, "img/IconoCiudadVerde.png",  820,  350,  35,  35);
// 
//        JRadioButton Riad = new JRadioButton(); 
//        crearBotonciudad(Riad, "img/IconoCiudadVerde.png",  895,  895,  35,  35);
// 
//        JRadioButton Estambul = new JRadioButton(); 
//        crearBotonciudad(Estambul, "img/IconoCiudadVerde.png",  830,  294,  35,  35);
// 
//        JRadioButton Bagdad = new JRadioButton(); 
//        crearBotonciudad(Bagdad, "img/IconoCiudadVerde.png",  880,  320,  35,  35);
// 
//        JRadioButton Moscu = new JRadioButton(); 
//        crearBotonciudad(Moscu, "img/IconoCiudadVerde.png",  890,  320,  35,  35);
// 
//        JRadioButton Teheran = new JRadioButton(); 
//        crearBotonciudad(Teheran, "img/IconoCiudadVerde.png",  920,  310,  35,  35);
// 
//        JRadioButton Karachi = new JRadioButton(); 
//        crearBotonciudad(Karachi, "img/IconoCiudadVerde.png",  980,  355,  35,  35);
// 
//        JRadioButton Bombay = new JRadioButton(); 
//        crearBotonciudad(Bombay, "img/IconoCiudadVerde.png",  1005,  395,  35,  35);
//       
//        JRadioButton NuevaDelhi = new JRadioButton(); 
//        crearBotonciudad(NuevaDelhi, "img/IconoCiudadVerde.png",  1025,  395,  35,  35);
// 
//        JRadioButton Calcuta = new JRadioButton(); 
//        crearBotonciudad(Calcuta, "img/IconoCiudadVerde.png",  1070,  370,  35,  35);
// 
//        JRadioButton Madras = new JRadioButton(); 
//        crearBotonciudad(Madras, "img/IconoCiudadVerde.png",  1035,  410,  35,  35);
// 
//        JRadioButton Yakarta = new JRadioButton(); 
//        crearBotonciudad(Yakarta, "img/IconoCiudadRojo.png",  1150,  525,  35,  35);
// 
//        JRadioButton Bangkok = new JRadioButton(); 
//        crearBotonciudad(Bangkok, "img/IconoCiudadRojo.png",  1120,  415,  35,  35);
// 
//        JRadioButton HongKong = new JRadioButton(); 
//        crearBotonciudad(HongKong, "img/IconoCiudadRojo.png",  1165,  370,  35,  35);
// 
//        JRadioButton Shanghai = new JRadioButton(); 
//        crearBotonciudad(Shanghai, "img/IconoCiudadRojo.png",  1195,  355,  35,  35);
// 
//        JRadioButton Pekin = new JRadioButton(); 
//        crearBotonciudad(Pekin, "img/IconoCiudadRojo.png",  1175,  300,  35,  35);
// 
//        JRadioButton Seul = new JRadioButton(); 
//        crearBotonciudad(Seul, "img/IconoCiudadRojo.png",  1225,  297,  35,  35);
// 
//        JRadioButton Tokio = new JRadioButton(); 
//        crearBotonciudad(Tokio, "img/IconoCiudadRojo.png",  1280,  290,  35,  35);
// 
//        JRadioButton Osaka = new JRadioButton(); 
//        crearBotonciudad(Osaka, "img/IconoCiudadRojo.png",  1255,  320,  35,  35);
// 
//        JRadioButton Taipei = new JRadioButton(); 
//        crearBotonciudad(Taipei, "img/IconoCiudadRojo.png",  1205,  375,  35,  35);
// 
//        JRadioButton HoChiMinh = new JRadioButton(); 
//        crearBotonciudad(HoChiMinh, "img/IconoCiudadRojo.png",  1148,  429,  35,  35);
// 
//        JRadioButton Manila = new JRadioButton(); 
//        crearBotonciudad(Manila, "img/IconoCiudadRojo.png",  1200,  420,  35,  35);
// 
//        JRadioButton Sidney = new JRadioButton(); 
//        crearBotonciudad(Sidney, "img/IconoCiudadRojo.png",  1320,  645,  35,  35);       
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
    
    
    
    public void crearBotonciudad(JRadioButton Ciudad, String rutaimg, int x, int y, int w, int h) {
        Ciudad.setOpaque(false);
        Ciudad.setBorderPainted(false);
        Ciudad.setContentAreaFilled(false);
        Ciudad.setBounds(x, y, w, h );
        ImageIcon icono = new ImageIcon(new ImageIcon(rutaimg).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
        Ciudad.setIcon(icono);
        IconosCiudades.add(Ciudad);
        add(Ciudad);
    }
    
    public  void AñadirBotonesCiudades(){
        ButtonGroup IconosCiudades = new ButtonGroup();
        
        
        JRadioButton sanFranciscoRadioButton = new JRadioButton();
        sanFranciscoRadioButton.setOpaque(false);
        sanFranciscoRadioButton.setBorderPainted(false);
        sanFranciscoRadioButton.setContentAreaFilled(false);
        sanFranciscoRadioButton.setBounds(235, 315, 100, 100 );
        ImageIcon icono = new ImageIcon(new ImageIcon("img/iconoCiudadNaranja.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        sanFranciscoRadioButton.setIcon(icono);
        IconosCiudades.add(sanFranciscoRadioButton);
        add(sanFranciscoRadioButton);
 

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
