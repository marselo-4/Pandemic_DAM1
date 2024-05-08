package Backend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Clases.CiudadBoton;
import Clases.Ciudades;
import Clases.Vacuna;
import Clases.controlDatos;
import Clases.controlPartida;
import Clases.datosPartida;
import UI.Informacion;
import UI.LanzadorPartida;
import UI.NuevaPartida;
import UI.PanelBotonesMenuAbajo;
import UI.PanelJuegoDerecha;
import UI.PanelJuegoIzquierda;
import UI.PanelMapa;
import UI.PanelPrincipal;

public class logicaJuego {
	public static controlDatos cd = new controlDatos();
	public static datosPartida dp = new datosPartida();
	public static controlPartida cp = new controlPartida();
	
	//LÓGICA GENERAL PARA LA PARTIDA

	public static void crearArrayCiudades() {
		String linea = "";
		
		String nombreFichero = "ciudades.txt";
		try {
			// Creamos un objeto de tipo FileReader para abrir un fichero de lectura
			FileReader fileReader = new FileReader(nombreFichero);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			do {
				// Leemos el contenido del fichero
				linea = bufferedReader.readLine();
				if (linea != null) {
					
					dp.ciudades.add(TxtCiudades.asignarCiudades(linea));

				}

			} while (linea != null);
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
		
	}

	public static void textosCaja(String texto) {
		// Creamos un hilo para el efecto de escritura
		new Thread(() -> {
			for (int i = 0; i <= texto.length(); i++) {
				final int index = i;
				// Actualizamos la caja de texto en el hilo de la interfaz de usuario (Swing)
				SwingUtilities.invokeLater(() -> {
					PanelBotonesMenuAbajo.Caja.setText(texto.substring(0, index));
					PanelBotonesMenuAbajo.Caja.setForeground(Color.WHITE);
				});
				try {
					// Simulamos un pequeño retraso entre cada caracter para el efecto de escritura
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public static void textosCajaColor(String texto, Color color) {
		// Creamos un hilo para el efecto de escritura
		new Thread(() -> {
			for (int i = 0; i <= texto.length(); i++) {
				final int index = i;
				// Actualizamos la caja de texto en el hilo de la interfaz de usuario (Swing)
				SwingUtilities.invokeLater(() -> {
					PanelBotonesMenuAbajo.Caja.setText(texto.substring(0, index));
					PanelBotonesMenuAbajo.Caja.setForeground(color);
				});
				try {
					// Simulamos un pequeño retraso entre cada caracter para el efecto de escritura
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}


	
	//FUNCIONES PARA CREAR Y AGREGAR FUNCIONES A LOS BOTONES
	public static void crearBotonesCiudades() {
		for (int i = 0; i < dp.ciudades.size(); i++) {
			String rutaImg = "";
			switch (dp.ciudades.get(i).getEnfermedad()) {
			case "Alfa":
				rutaImg = "img/IconoCiudadAzul.png";
				break;
			case "Beta":
				rutaImg = "img/IconoCiudadRojo.png";
				break;
			case "Gama":
				rutaImg = "img/IconoCiudadVerde.png";
				break;
			case "Delta":
				rutaImg = "img/IconoCiudadAmarillo.png";
				break;

			default:
				break;
			}
			
			CiudadBoton c = new CiudadBoton();
			c.setCiudad(dp.ciudades.get(i));
			crearBotonciudad(LanzadorPartida.p, c, rutaImg, dp.ciudades.get(i).getCoords()[0], dp.ciudades.get(i).getCoords()[1], 35, 35);
			
		}  
	}
	
    public static void crearBotonciudad(PanelMapa p,CiudadBoton Ciudad, String rutaimg, int x, int y, int w, int h) {
    	
        Ciudad.setOpaque(false);
        Ciudad.setBorderPainted(false);
        Ciudad.setContentAreaFilled(false);
        Ciudad.setBounds(x, y, w, h );
        ImageIcon icono = new ImageIcon(new ImageIcon(rutaimg).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
        Ciudad.setIcon(icono);
        PanelMapa.IconosCiudades.add(Ciudad);
        
        
        p.add(Ciudad);
        //System.out.println("Botón " + rutaimg + "se intentó crear en " + p);
        Ciudad.addActionListener(p);
        PanelMapa.botonesCiudadesArray.add(Ciudad);
    }
	
    //VACUNAS
    public static void crearVacunas(ButtonGroup vacunas, PanelJuegoDerecha p) {

    	Vacuna v = new Vacuna("Alfa", "azul", 0);
    	Vacuna v2 = new Vacuna("Beta", "verde", 0);
    	Vacuna v3 = new Vacuna("Gamma", "rojo", 0);
    	Vacuna v4 = new Vacuna("Delta", "amarillo", 0);
    	
    	PanelJuegoDerecha.radioAzul.setVacuna(v);
    	PanelJuegoDerecha.radioAzul.setOpaque(false);
        PanelJuegoDerecha.radioAzul.setContentAreaFilled(false);
        PanelJuegoDerecha.radioAzul.setBorderPainted(false);
        PanelJuegoDerecha.radioAzul.setFocusPainted(true);
        PanelJuegoDerecha.radioAzul.setForeground(Color.black);
        PanelJuegoDerecha.radioAzul.setPreferredSize(new Dimension(100, 100));
        vacunas.add(PanelJuegoDerecha.radioAzul);
        
        PanelJuegoDerecha.radioAzul.addActionListener(p);
        PanelJuegoDerecha.radioAzul.addItemListener(p);
        PanelJuegoDerecha.radioAzul.setIcon(PanelJuegoDerecha.icono_azul);
        p.add(PanelJuegoDerecha.radioAzul);
        p.add(PanelJuegoDerecha.labelAzul);
        PanelJuegoDerecha.labelAzul.setForeground(Color.white);

        PanelJuegoDerecha.radioVerde.setVacuna(v2);
        PanelJuegoDerecha.radioVerde.setOpaque(false);
        PanelJuegoDerecha.radioVerde.setContentAreaFilled(false);
        PanelJuegoDerecha.radioVerde.setBorderPainted(false);
        PanelJuegoDerecha.radioVerde.setFocusPainted(true);
        PanelJuegoDerecha.radioVerde.setForeground(Color.black);
        PanelJuegoDerecha.radioVerde.setPreferredSize(new Dimension(100, 100));
        vacunas.add(PanelJuegoDerecha.radioVerde);
        PanelJuegoDerecha.radioVerde.addActionListener(p);
        PanelJuegoDerecha.radioVerde.addItemListener(p);
        PanelJuegoDerecha.radioVerde.setIcon(PanelJuegoDerecha.icono_verde);
        p.add(PanelJuegoDerecha.radioVerde);
        p.add(PanelJuegoDerecha.labelVerde);
        PanelJuegoDerecha.labelVerde.setForeground(Color.white);

        PanelJuegoDerecha.radioRojo.setVacuna(v3);
        PanelJuegoDerecha.radioRojo.setOpaque(false);
        PanelJuegoDerecha.radioRojo.setContentAreaFilled(false);
        PanelJuegoDerecha.radioRojo.setBorderPainted(false);
        PanelJuegoDerecha.radioRojo.setFocusPainted(true);
        PanelJuegoDerecha.radioRojo.setForeground(Color.black);
        PanelJuegoDerecha.radioRojo.setPreferredSize(new Dimension(100, 100));
        vacunas.add(PanelJuegoDerecha.radioRojo);
        PanelJuegoDerecha.radioRojo.addActionListener(p);
        PanelJuegoDerecha.radioRojo.addItemListener(p);
        PanelJuegoDerecha.radioRojo.setIcon(PanelJuegoDerecha.icono_rojo);
        p.add(PanelJuegoDerecha.radioRojo);
        p.add(PanelJuegoDerecha.labelRojo);
        PanelJuegoDerecha.labelRojo.setForeground(Color.white);

        PanelJuegoDerecha.radioAmarillo.setVacuna(v4);   
        PanelJuegoDerecha.radioAmarillo.setOpaque(false);
        PanelJuegoDerecha.radioAmarillo.setContentAreaFilled(false);
        PanelJuegoDerecha.radioAmarillo.setBorderPainted(false);
        PanelJuegoDerecha.radioAmarillo.setFocusPainted(true);
        PanelJuegoDerecha.radioAmarillo.setForeground(Color.black);
        PanelJuegoDerecha.radioAmarillo.setPreferredSize(new Dimension(100, 100));
        vacunas.add(PanelJuegoDerecha.radioAmarillo);
        PanelJuegoDerecha.radioAmarillo.addActionListener(p);
        PanelJuegoDerecha.radioAmarillo.addItemListener(p);
        PanelJuegoDerecha.radioAmarillo.setIcon(PanelJuegoDerecha.icono_amarillo);
        p.add(PanelJuegoDerecha.radioAmarillo);
        p.add(PanelJuegoDerecha.labelAmarillo);
        PanelJuegoDerecha.labelAmarillo.setForeground(Color.white);

    }

	public static void BotonesDesarollar_curar(PanelJuegoDerecha p) {
		
		PanelJuegoDerecha.curarCiudad.setOpaque(false);
		PanelJuegoDerecha.curarCiudad.setBorderPainted(false);
		PanelJuegoDerecha.curarCiudad.setContentAreaFilled(false);
		PanelJuegoDerecha.curarCiudad.setBounds(500, 550, 85, 85); // Desplaza el botón curarCiudad hacia abajo

		ImageIcon curarCiudadimg = new ImageIcon(
		new ImageIcon("img/cur_ciudad.png").getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));
		PanelJuegoDerecha.curarCiudad.setIcon(curarCiudadimg);
		PanelJuegoDerecha.curarCiudad.setFocusPainted(false);
		p.add(PanelJuegoDerecha.curarCiudad);

		
		PanelJuegoDerecha.DesarollarVacuna.setBorderPainted(false);
		PanelJuegoDerecha.DesarollarVacuna.addActionListener(p);
		PanelJuegoDerecha.DesarollarVacuna.setOpaque(false);
		PanelJuegoDerecha.DesarollarVacuna.setContentAreaFilled(false);
		PanelJuegoDerecha.DesarollarVacuna.setFocusPainted(false);
		PanelJuegoDerecha.DesarollarVacuna.setBounds(500, 650, 85, 85); // Desplaza el botón DesarollarVacuna hacia abajo
		ImageIcon desvacunaimg = new ImageIcon(
		new ImageIcon("img/des_vacuna.png").getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH));
		PanelJuegoDerecha.DesarollarVacuna.setIcon(desvacunaimg);
		p.add(PanelJuegoDerecha.DesarollarVacuna);

	}

	public static void animateJLabel(JLabel label, int percentage, int sumar, Vacuna v, Runnable callback) {
    int resultado_final = percentage + sumar;
    
    if (resultado_final > 100) {
        resultado_final = 100;
    }

    final int finalResultado = resultado_final;

    new Thread(() -> {
        for (int i = percentage; i <= finalResultado; i++) {
            final int currentPercentage = i; // Almacenar el valor actual de i

            try {
                SwingUtilities.invokeLater(() -> {
                    label.setText(currentPercentage + "%"); // Acceder a la variable final dentro del lambda
                    if (currentPercentage == 100) {
                        label.setForeground(Color.GREEN); // Cambiar el color del texto a verde cuando el porcentaje es 100
                    }
                });
                
                Thread.sleep(50); // Pausa de 50 milisegundos entre cada actualización
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Actualizar el porcentaje en la instancia de Vacuna al final de la animación
        v.setPorcentaje(finalResultado);
        
        // Ejecutar la función de retrollamada después de la animación
        if (callback != null) {
            callback.run();
        }
    }).start();
}

	//GAMEPLAY
public static void empezarPartida(int dificultad){
    Random rand = new Random();
    int numCiudadesInfectadas = 0;
    
    dp.cargarDatos();

    
    
    // Definir el tamaño del array según la dificultad
    int[] ciudadesInfectadasComienzo = new int[dp.getPropagacion_inicio()];
    
    for (int i = 0; i < dp.getPropagacion_inicio(); i++) {
        int r = rand.nextInt(0, dp.ciudades.size());
        ciudadesInfectadasComienzo[i] = r;
    }
    
    // Poner acciones en 4
    dp.setAcciones(4);
    PanelBotonesMenuAbajo.lblAcciones.setText("Acciones: " + dp.getAcciones());
    
    // Turno en 1
    dp.setRondas(1);
    PanelBotonesMenuAbajo.lblTurno.setText("Turno: " + dp.getRondas());
    
    
    for (int i = 0; i < ciudadesInfectadasComienzo.length; i++) {
        
        String enfermedad = PanelMapa.botonesCiudadesArray.get(ciudadesInfectadasComienzo[i]).getCiudad().getEnfermedad();
        switch (enfermedad) {
        case "Alfa":
            PanelMapa.botonesCiudadesArray.get(ciudadesInfectadasComienzo[i]).setIcon(PanelMapa.ciudad_azul1);
            dp.ciudades.get(ciudadesInfectadasComienzo[i]).setInfeccion(1);
            break;
        case "Beta":
            PanelMapa.botonesCiudadesArray.get(ciudadesInfectadasComienzo[i]).setIcon(PanelMapa.ciudad_roja1);
            dp.ciudades.get(ciudadesInfectadasComienzo[i]).setInfeccion(1);
            break;
        case "Gama":
            PanelMapa.botonesCiudadesArray.get(ciudadesInfectadasComienzo[i]).setIcon(PanelMapa.ciudad_verde1);
            dp.ciudades.get(ciudadesInfectadasComienzo[i]).setInfeccion(1);
            break;
        case "Delta":
            PanelMapa.botonesCiudadesArray.get(ciudadesInfectadasComienzo[i]).setIcon(PanelMapa.ciudad_amarilla1);
            dp.ciudades.get(ciudadesInfectadasComienzo[i]).setInfeccion(1);
            break;
        default:
            break;
    }
    }
}

public static void nuevoTurno(){
	ArrayList<Ciudades> menores3 = new ArrayList<>();
	
	//Poner acciones a 4
    dp.setAcciones(4);
    PanelBotonesMenuAbajo.lblAcciones.setText("Acciones: " + dp.getAcciones());
    
	//Sumar turno
    dp.setRondas(dp.getRondas() + 1);
    PanelBotonesMenuAbajo.lblTurno.setText("Turno: " + dp.getRondas());
	
    //Subir de nivel las ciudades menores de 3
    boolean broteHecho = false;
	for (int i = 0; i < dp.ciudades.size(); i++) {
		if (dp.ciudades.get(i).getInfeccion() < 3 && dp.ciudades.get(i).getInfeccion() != 0) {
			
			switch (dp.ciudades.get(i).getEnfermedad()) {
			case "Alfa": //azul
				switch (dp.ciudades.get(i).getInfeccion()) {
				case 0:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_azul1);
					break;
				case 1:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_azul2);
					break;
				case 2:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_azul3);
					break;
				}
				break;
			case "Beta": //roja
				switch (dp.ciudades.get(i).getInfeccion()) {
				case 0:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_roja1);
					break;
				case 1:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_roja2);
					break;
				case 2:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_roja3);
					break;
				}
				
				break;
			case "Gama": // verde
				switch (dp.ciudades.get(i).getInfeccion()) {
				case 0:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_verde1);
					break;
				case 1:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_verde2);
					break;
				case 2:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_verde3);
					break;
				}
				
				break;
			case "Delta": //amarillo
				switch (dp.ciudades.get(i).getInfeccion()) {
				case 0:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_amarilla1);
					break;
				case 1:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_amarilla2);
					break;
				case 2:
					PanelMapa.botonesCiudadesArray.get(i).setIcon(PanelMapa.ciudad_amarilla3);
					break;
				}
				
				break;

			default:
				break;
			}
			
			dp.ciudades.get(i).setInfeccion(dp.ciudades.get(i).getInfeccion() + 1);
			
		}else if (dp.ciudades.get(i).getInfeccion() == 3) {
			System.out.println("Ciudad lvl 3");
			//Crear un array de ciudades colindantes
			ArrayList<Ciudades> colindantes = new ArrayList<>();
			ArrayList<Integer> posicionesColindantes = new ArrayList<>();
			System.out.println("Numero de colindantes: " + dp.ciudades.get(i).getColindantes().size());
			for (int j = 0; j < dp.ciudades.get(i).getColindantes().size(); j++) {
				String ciudadC = dp.ciudades.get(i).getColindantes().get(j);
				System.out.println("ciudadC SIZE: " + ciudadC);
				
				for (int k = 0; k < dp.ciudades.size(); k++) {
					if (dp.ciudades.get(k).getNombre().equals(ciudadC)) {
						System.out.println("Ciudad encontrada");
						colindantes.add(dp.ciudades.get(k));
						System.out.println(dp.ciudades.get(k).getNombre());
						posicionesColindantes.add(k);
						System.out.println(k);
					}
					
				}
			}
			
			
			for (int j = 0; j < colindantes.size(); j++) {
				
				switch (colindantes.get(j).getEnfermedad()) {
				case "Alfa": //azul
					switch (colindantes.get(j).getInfeccion()) {
					case 0:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_azul1);
						break;
					case 1:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_azul2);
						break;
					case 2:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_azul3);
						break;
					}
					break;
				case "Beta": //roja
					switch (colindantes.get(j).getInfeccion()) {
					case 0:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_roja1);
						break;
					case 1:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_roja2);
						break;
					case 2:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_roja3);
						break;
					}
					
					break;
				case "Gama": // verde
					switch (colindantes.get(j).getInfeccion()) {
					case 0:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_verde1);
						break;
					case 1:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_verde2);
						break;
					case 2:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_verde3);
						break;
					}
					
					break;
				case "Delta": //amarillo
					switch (colindantes.get(j).getInfeccion()) {
					case 0:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_amarilla1);
						break;
					case 1:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_amarilla2);
						break;
					case 2:
						PanelMapa.botonesCiudadesArray.get(posicionesColindantes.get(j)).setIcon(PanelMapa.ciudad_amarilla3);
						break;
					}
					
					break;
				}
				
				colindantes.get(j).setInfeccion(colindantes.get(j).getInfeccion()+1);
				broteHecho = true;
			}
			
			

		}
	}
	
    if (PanelJuegoIzquierda.circulosActuales < PanelJuegoIzquierda.circulosMaximos && broteHecho) {
    	LanzadorPartida.p3.setNumeroCirculosActuales(PanelJuegoIzquierda.circulosActuales + 1);
    	if (PanelJuegoIzquierda.circulosActuales == PanelJuegoIzquierda.circulosMaximos) {
        	cambiarPantalla();
    	}
    } 
	
	
	
}

public static void cambiarImagenCiudad(CiudadBoton c, int nivInfeccion, String id) {
	switch (id) {
	case "Alfa":
		if (nivInfeccion == 1) {
			
		}else {
			
		}
		break;
	case "Beta":
		
		break;

	default:
		break;
	}
}

public static void nuevoBrote() {
	
}


public static boolean updateAP(int cost) {

	if (dp.getAcciones() >= cost) {
		logicaJuego.dp.setAcciones(logicaJuego.dp.getAcciones() - cost);
		String s = "Acciones: " + logicaJuego.dp.getAcciones();
		System.out.println(dp.getAcciones());
		PanelBotonesMenuAbajo.lblAcciones.setText(s);
		return true;
	}else {
		System.out.println(dp.getAcciones());
		logicaJuego.textosCaja("No tienes suficientes acciones!!!");
		return false;
	}


}


public static void cambiarPantalla() {
    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LanzadorPartida.p);
    frame.remove(LanzadorPartida.p);
    frame.remove(LanzadorPartida.p2);
    frame.remove(LanzadorPartida.p3);
    frame.remove(LanzadorPartida.p4);
    
    
    frame.add(new Informacion());
    frame.repaint();
    frame.revalidate();
    frame.setVisible(true);

}


   }

