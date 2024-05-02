	package UI;
	
	import java.awt.*;
	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.ItemEvent;
	import java.awt.event.ItemListener;
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
		
	
	
	    private ImageIcon icon;
	    private Image scaledImage;
	    public static ButtonGroup IconosCiudades = new ButtonGroup();
	
	
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
	            
	        } 
	    }
  
	}
