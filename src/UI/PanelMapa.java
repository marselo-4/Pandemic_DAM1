	package UI;
	
	import java.awt.*;
	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.ItemEvent;
	import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
	import javax.swing.ImageIcon;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;

import Backend.TxtCiudades;
import Backend.logicaJuego;
import Clases.CiudadBoton;
import Clases.Ciudades;
	
	public class PanelMapa extends JPanel implements ActionListener {
		public static ImageIcon ciudad_azul0 = new ImageIcon(new ImageIcon("img/IconoCiudadAzul.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_azul1 = new ImageIcon(new ImageIcon("img/IconoCiudadAzul1.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_azul2 = new ImageIcon(new ImageIcon("img/IconoCiudadAzul2.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_azul3 = new ImageIcon(new ImageIcon("img/IconoCiudadAzul3.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
	
		public static ImageIcon ciudad_verde0 = new ImageIcon(new ImageIcon("img/iconoCiudadVerde.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_verde1 = new ImageIcon(new ImageIcon("img/iconoCiudadVerde1.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_verde2 = new ImageIcon(new ImageIcon("img/iconoCiudadVerde2.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_verde3 = new ImageIcon(new ImageIcon("img/iconoCiudadVerde3.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));

		public static ImageIcon ciudad_roja0 = new ImageIcon(new ImageIcon("img/IconoCiudadRojo.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_roja1 = new ImageIcon(new ImageIcon("img/IconoCiudadRojo1.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_roja2 = new ImageIcon(new ImageIcon("img/IconoCiudadRojo2.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_roja3 = new ImageIcon(new ImageIcon("img/IconoCiudadRojo3.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		
		public static ImageIcon ciudad_amarilla0 = new ImageIcon(new ImageIcon("img/IconoCiudadAmarillo.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_amarilla1 = new ImageIcon(new ImageIcon("img/IconoCiudadAmarillo1.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_amarilla2 = new ImageIcon(new ImageIcon("img/IconoCiudadAmarillo2.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
		public static ImageIcon ciudad_amarilla3 = new ImageIcon(new ImageIcon("img/IconoCiudadAmarillo3.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));		
		
		
	    private ImageIcon icon;
	    private Image scaledImage;
	    public static ButtonGroup IconosCiudades = new ButtonGroup();
	    public static ArrayList<CiudadBoton> botonesCiudadesArray = new ArrayList<>();
	
	
	    public PanelMapa() { // testea botones si funcionan todos con print
	        icon = new ImageIcon("img/mapa.jpg");  //Ruta actualizada
	       scaleImage();
	       setLayout(null);
	       setDoubleBuffered(true);
	       

       
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
	    

	    
//	    private static Ciudades linkearCiudad(String nombre) {
//	    	for (int i = 0; i < array.length; i++) {
//				
//			}
//			return null;
//	    	
//	    }
	    
	    public void actionPerformed(ActionEvent e) {
	    	CiudadBoton selectedButton = (CiudadBoton) e.getSource();
	
	    	if (e.getSource() instanceof CiudadBoton) {
	    		logicaJuego.textosCaja("Ciudad " + selectedButton.getCiudad().getNombre() + " seleccionada. Su nivel de infeccion es "
	    				+ selectedButton.getCiudad().getInfeccion()); 
	        } 
	    }
  
	}
