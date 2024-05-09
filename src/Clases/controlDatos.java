
package Clases;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Backend.TxtCiudades;
import Backend.logicaJuego;
import Backend.parametros;
import UI.LanzadorPartida;
import UI.PanelBotonesMenuAbajo;
import UI.PanelJuegoDerecha;
import UI.PanelJuegoIzquierda;
import UI.PanelMapa;
import UI.Puntuaciones;

public class controlDatos {

	private static String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe"; // casa cambiar ip a
																			// jdbc:oracle:thin:@oracle.ilerna.com:1521:xe
	private static String USER = "DAM1_2324_ALE_LUJAN";
	private static String PWD = "Lujan1234.";
	private String ficheroTxt;
	private String ficheroBin;
	private static String ficheroXML = "parametros.xml";

	public static void main(String[] args) throws SQLException {
		Connection con = conectarBaseDatos();

		if (con != null) {

			//guardarPartida(con);
			cargarPartida(con);
			//cargarRecordNormal(con);
			
			con.close();
		}

	}

	public static Connection conectarBaseDatos() {
		Connection con = null;

		System.out.println("Intentando conectarse a la base de datos");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}

		System.out.println("Conectados a la base de datos");

		return con;
	}

	public static void cargarCiudades() {

	}

	public static void cargarVacunas() {

	}

	public static void cargarVirus() {

	}

	public static void cargarPartida(Connection con) {
		String sql = "SELECT p.NPartida, p.NombreJ, p.dificultad, p.Rondas , p.Fecha , p.Acciones_restantes, p.Brotes, p.Azul.nombre, p.Azul.color, p.Azul.porcentage, p.Rojo.nombre, p.Rojo.color, p.Rojo.porcentage, p.Amarillo.nombre, p.Amarillo.color, p.Amarillo.porcentage, p.Verde.nombre, p.Verde.color, p.Verde.porcentage, c.nombre, c.enfermedad, c.infeccion, c.CordX, c.CordY, c.Colindantes "
				+ "FROM PartidasGuardadas p, TABLE(p.lista_ciudades) c " + "WHERE p.NPartida = (SELECT MAX(NPartida) FROM PartidasGuardadas) ORDER BY FECHA DESC";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					
					int Npartida = rs.getInt("Npartida");
										
					String NombreJ = rs.getString("NombreJ");
					
					String Dificultad = rs.getString("dificultad");
					parametros.setEleccion(Dificultad);
					
					int Rondas = rs.getInt("Rondas");
					logicaJuego.dp.setRondas(Rondas);
					String RondasStr = String.valueOf(Rondas);
					//Álvaro: he hardcodeado "Turno: " nada importante
					PanelBotonesMenuAbajo.lblTurno.setText("Turno: " + RondasStr);
					
					
					String Fecha = rs.getString("Fecha");
					
					int Acciones_restantes = rs.getInt("Acciones_restantes");
					logicaJuego.dp.setAcciones(Acciones_restantes);
					//Álvaro: he puesto que las acciones se actualizen en la UI
					PanelBotonesMenuAbajo.lblAcciones.setText("Acciones: " + Acciones_restantes);
					
					int Brotes = rs.getInt("Brotes");
					logicaJuego.dp.setBrotes(Brotes);
					//Alvaro: Aquí estaba puesto esto--> PanelBotonesMenuAbajo.lblTurno.setText(BrotesStr); || Supongo que estabas demasiado quemado ya xd (lo he arreglado)
					logicaJuego.dp.cargarDatos();
					LanzadorPartida.p3.generarBrotesCirculos(logicaJuego.dp.getBrotes_maximos(), Brotes);
					
					//He asignado los valores de las vacunas a los objetos e interfaz
					String nombreA = rs.getString("Azul.nombre");
					String colorA = rs.getString("AZUL.color");
					int porcentageA = rs.getInt("AZUL.porcentage");
					PanelJuegoDerecha.radioAzul.getVacuna().setNombre(nombreA);;
					PanelJuegoDerecha.radioAzul.getVacuna().setColor(colorA);
					PanelJuegoDerecha.radioAzul.getVacuna().setPorcentaje(porcentageA);
					PanelJuegoDerecha.labelAzul.setText(porcentageA + "%");

					String nombreR = rs.getString("Rojo.nombre");
					String colorR = rs.getString("ROJO.color");
					int porcentageR = rs.getInt("ROJO.porcentage");
					PanelJuegoDerecha.radioRojo.getVacuna().setNombre(nombreR);;
					PanelJuegoDerecha.radioRojo.getVacuna().setColor(colorR);
					PanelJuegoDerecha.radioRojo.getVacuna().setPorcentaje(porcentageR);
					PanelJuegoDerecha.labelRojo.setText(porcentageR + "%");

					String nombreAM = rs.getString("Amarillo.nombre");
					String colorAM = rs.getString("Amarillo.color");
					int porcentageAM = rs.getInt("Amarillo.porcentage");
					PanelJuegoDerecha.radioAmarillo.getVacuna().setNombre(nombreAM);;
					PanelJuegoDerecha.radioAmarillo.getVacuna().setColor(colorAM);
					PanelJuegoDerecha.radioAmarillo.getVacuna().setPorcentaje(porcentageAM);
					PanelJuegoDerecha.labelAmarillo.setText(porcentageAM + "%");

					String nombreV = rs.getString("Verde.nombre");
					String colorV = rs.getString("Verde.color");
					int porcentageV = rs.getInt("Verde.porcentage");
					PanelJuegoDerecha.radioVerde.getVacuna().setNombre(nombreV);;
					PanelJuegoDerecha.radioVerde.getVacuna().setColor(colorV);
					PanelJuegoDerecha.radioVerde.getVacuna().setPorcentaje(porcentageV);
					PanelJuegoDerecha.labelVerde.setText(porcentageV + "%");
			

						String nombre = rs.getString("nombre");
						//Álvaro: literal el error en enfermedad era que tenias "c.enfermedad" :(
						String enfermedad = rs.getString("enfermedad");
						int infeccion = rs.getInt("infeccion");
						int[] XY = new int[2];
						//EL C. || c.CordX c.CordY
						XY[0] = rs.getInt("CordX");
						XY[1] = rs.getInt("CordY");
						//Álvaro: literal el error en enfermedad era que tenias "c.colindantes" :(
						
//						Cambio el insert para que las colindantes se guarden con ; entre medias por esto:
//						Colindante de Hong Kong : Ho
//						Colindante de Hong Kong : Chi
//						Colindante de Hong Kong : Minh
//						(Es solo una ciudad)
						String colindantes = rs.getString("colindantes");
						String[] ciudadesC = colindantes.split(";");

						
						updatearCiudadesBackendUI(nombre, enfermedad, infeccion, XY, ciudadesC);
						
						
						//Para que es el for????
//						for (int i = 0; i < 48; i++) {
//							if (logicaJuego.dp.ciudades.get(i).getNombre().equals(nombre)) {
//								logicaJuego.dp.ciudades.get(i).setInfeccion(infeccion);
//							}
//						}

						

					

					// Ciudades cd = new Ciudades();

					/* C.add(cd); */ }
			} else {
				System.out.println("No he encontrado nada");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//He creado esta funcion para updatear las ciudades más fácilmente
	public static void updatearCiudadesBackendUI(String nombre, String enfermedad, int infeccion, int[] coords, String[] colindantes) {
		int posicionCiudad = -1;
		
		//Le quito el ultimo char a el nombre pq se ha colado un espacio al final
		nombre = nombre.substring(0, nombre.length() - 1);
		
		for (int j = 0; j < logicaJuego.dp.ciudades.size(); j++) {
			if (logicaJuego.dp.ciudades.get(j).getNombre().equals(nombre)) {
				posicionCiudad = j;
			}
		}
		
		
		//Set valores
		logicaJuego.dp.ciudades.get(posicionCiudad).setNombre(nombre);			
		logicaJuego.dp.ciudades.get(posicionCiudad).setEnfermedad(enfermedad);
		logicaJuego.dp.ciudades.get(posicionCiudad).setInfeccion(infeccion);
		
		//Updatear imagenes de las ciudades
		switch (enfermedad) {
		case "Alfa": // azul
			switch (infeccion) {
			case 0:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_azul0);
				break;
			case 1:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_azul1);
				break;
			case 2:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_azul2);
				break;
			case 3:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_azul3);
				break;
			}
			break;
		case "Beta": // roja
			switch (infeccion) {
			case 0:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_roja0);
				break;
			case 1:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_roja1);
				break;
			case 2:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_roja2);
				break;
			case 3:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_roja3);
				break;
			}

			break;
		case "Gama": // verde
			switch (infeccion) {
			case 0:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_verde0);
				break;
			case 1:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_verde1);
				break;
			case 2:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_verde2);
				break;
			case 3:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_verde3);
				break;
			}

			break;
		case "Delta": // amarillo
			switch (infeccion) {
			case 0:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_amarilla0);
				break;
			case 1:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_amarilla1);
				break;
			case 2:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_amarilla2);
				break;
			case 3:
				PanelMapa.botonesCiudadesArray.get(posicionCiudad).setIcon(PanelMapa.ciudad_amarilla3);
				break;
			}

			break;

		default:
			break;
		}
		
	}

	public static void guardarPartida(Connection con) {

		String NombreJ = "BAZOKA GOD";
		String dificultad = parametros.getEleccion();
		int rondas = logicaJuego.dp.getRondas();
		int acciones_restantes = logicaJuego.dp.getAcciones();
		//No era logicaJuego.dp.getBrotes() || Es lo de abajo
		int brotes = PanelJuegoIzquierda.circulosActuales;

		String nombreAzul = PanelJuegoDerecha.radioAzul.getVacuna().getNombre();
		String colorAzul = PanelJuegoDerecha.radioAzul.getVacuna().getColor();
		int porcentageAzul = PanelJuegoDerecha.radioAzul.getVacuna().getPorcentaje();

		String nombreRojo = PanelJuegoDerecha.radioRojo.getVacuna().getNombre();
		int porcentageRojo = PanelJuegoDerecha.radioRojo.getVacuna().getPorcentaje();
		String colorRojo = PanelJuegoDerecha.radioRojo.getVacuna().getColor();

		String nombreAmarillo = PanelJuegoDerecha.radioAmarillo.getVacuna().getNombre();
		int porcentageAmarillo = PanelJuegoDerecha.radioAmarillo.getVacuna().getPorcentaje();
		String colorAmarillo = PanelJuegoDerecha.radioAmarillo.getVacuna().getColor();
		
		//Álvaro: tenías puesto radioRojo en lugar de radioVerde :D
		String nombreVerde = PanelJuegoDerecha.radioVerde.getVacuna().getNombre();
		int porcentageVerde = PanelJuegoDerecha.radioVerde.getVacuna().getPorcentaje();
		String colorVerde = PanelJuegoDerecha.radioVerde.getVacuna().getColor();

		String ciudadesInsert = "";

		//En el for, he cambiado "String colindantesString = String.join(" ", colindantes);" Para que el primer parámetro 
		//Tenga un ; para separar las colindantes (así no se separan por espacios, por ejemplo Los Angeles quedaría separado)
		for (int i = 0; i < logicaJuego.dp.ciudades.size(); i++) {
			if (i == logicaJuego.dp.ciudades.size() - 1) {

				int[] Coord = logicaJuego.dp.ciudades.get(i).getCoords();
				String XY = Coord[0] + " , " + Coord[1];

				ArrayList<String> colindantesLista = logicaJuego.dp.ciudades.get(i).getColindantes();
				String[] colindantes = colindantesLista.toArray(new String[0]);
				String colindantesString = String.join(";", colindantes);

				String ciudadSQL = "CIUDAD('" + logicaJuego.dp.ciudades.get(i).getNombre() + " ', '"
						+ logicaJuego.dp.ciudades.get(i).getEnfermedad() + "',"
						+ logicaJuego.dp.ciudades.get(i).getInfeccion() + ", " + XY + ", '" + colindantesString + "') ";
				ciudadesInsert += ciudadSQL;
			} else {

				int[] Coord = logicaJuego.dp.ciudades.get(i).getCoords();
				String XY = Coord[0] + " , " + Coord[1];

				ArrayList<String> colindantesLista = logicaJuego.dp.ciudades.get(i).getColindantes();
				String[] colindantes = colindantesLista.toArray(new String[0]);
				String colindantesString = String.join(";", colindantes);

				String ciudadSQL = "CIUDAD('" + logicaJuego.dp.ciudades.get(i).getNombre() + " ', '"
						+ logicaJuego.dp.ciudades.get(i).getEnfermedad() + "',"
						+ logicaJuego.dp.ciudades.get(i).getInfeccion() + ", " + XY + ", '" + colindantesString
						+ "'), ";
				ciudadesInsert += ciudadSQL;
			}
		}

		String sql = "INSERT INTO PartidasGuardadas VALUES(NUM_PARTIDA.NEXTVAL, '" + NombreJ + "', '" + dificultad
				+ "', " + rondas + ", SYSDATE, " + acciones_restantes + ", " + brotes + ", VACUNA('" + nombreAzul
				+ "', '" + colorAzul + "', " + porcentageAzul + ") , VACUNA('" + nombreRojo + "', '" + colorRojo + "', "
				+ porcentageRojo + ") , VACUNA('" + nombreAmarillo + "', '" + colorAmarillo + "', " + porcentageAmarillo
				+ ") , " + "VACUNA('" + nombreVerde + "', '" + colorVerde + "', " + porcentageVerde
				+ "),  Lista_ciudades(" + ciudadesInsert + "))";
		
		

		try {
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("hola");
			System.out.println("Insert registrado correctamente");
			System.out.println(sql);
			System.out.println("hola");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
	}
	
	public static void guardarRecord(Connection con) { //Tirar esta funcion cuando se gane una partida

		String NombreJ = "bazoka";
		String dificultad = parametros.getEleccion();
		int rondas = logicaJuego.dp.getRondas();


		String sql = "INSERT INTO RANKING VALUES(NUM_PARTIDA.NEXTVAL, '" + NombreJ + "', '" + dificultad + "', " + rondas +  ")";

		try {
			Statement st = con.createStatement();
			st.execute(sql);

			System.out.println("Insert registrado correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
		
	}


	public static void cargarRecordFacil(Connection con) {
		
		String Ranking = "";
		int num = 0;
		String posicion = num + "#"; 
		
		String RankingFacil = "SELECT r.NombreJ, r.NPartida, r.dificultad, r.Rondas " + "FROM Ranking r "
				+ "WHERE r.dificultad = 'Facil' AND ROWNUM BETWEEN 1 AND 10" + "ORDER BY r.Rondas ASC";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(RankingFacil);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					

					String[] partida = new String[4];
					partida[0] = rs.getString("NombreJ");
					partida[1] = rs.getString("NPartida");
					partida[3] = rs.getString("Rondas");

				 num++;
			     posicion = num + "#";
				 String registro = posicion + " NICKNAME: " + partida[0] + "  PARTIDA: " +
		                    partida[1] + "#  " + " RONDAS: " + partida[3];

		            if (!Ranking.isEmpty()) {
		                Ranking += "\n \n"; 
		            }
		            Ranking += registro;
				}
			} else {
				System.out.println("No he encontrado nada");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 Puntuaciones.textosCajaRanking(Ranking);

	}

	public static void cargarRecordNormal(Connection con) {
		
		String Ranking = "";
		int num = 0;
		String posicion = num + "#"; 
		
		String RankingNormal = "SELECT r.NombreJ,  r.NPartida, r.dificultad, r.Rondas " + " FROM Ranking r "
				+ "WHERE r.dificultad = 'Normal' AND ROWNUM BETWEEN 1 AND 10 " + "ORDER BY r.Rondas ASC";
		
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(RankingNormal);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					
					String[] partida = new String[4];
					partida[0] = rs.getString("NombreJ");
					partida[1] = rs.getString("NPartida");
					partida[3] = rs.getString("Rondas");

				 num++;
			     posicion = num + "#";
				 String registro = posicion + " NICKNAME: " + partida[0] + "  PARTIDA: " +
		                    partida[1] + "#  " + " RONDAS: " + partida[3];

		            if (!Ranking.isEmpty()) {
		                Ranking += "\n \n";
		                
		            }
		            Ranking += registro;
				}
			} else {
				System.out.println("No he encontrado nada");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 Puntuaciones.textosCajaRanking(Ranking);

	}
	
	public static void cargarRecordDificil(Connection con) {
		
		String Ranking = "";
		int num = 0;
		String posicion = num + "#"; 

		String RankingDificil = "SELECT r.NombreJ,  r.NPartida, r.Rondas, r.dificultad " + "FROM Ranking r "
				+ "WHERE r.dificultad = 'Dificil' AND ROWNUM BETWEEN 1 AND 10"  + "ORDER BY r.Rondas ASC";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(RankingDificil);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {

					String[] partida = new String[4];
					partida[0] = rs.getString("NombreJ");
					partida[1] = rs.getString("NPartida");
					partida[3] = rs.getString("Rondas");

				 num++;
			     posicion = num + "#";
				 String registro = posicion + " NICKNAME: " + partida[0] + "  PARTIDA: " +
		                    partida[1] + "#  " + " RONDAS: " + partida[3];

		            if (!Ranking.isEmpty()) {
		                Ranking += "\n \n"; 
		            }
		            Ranking += registro;
				}
			} else {
				System.out.println("No he encontrado nada");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 Puntuaciones.textosCajaRanking(Ranking);

	}
	
	


	public String getUrl() {
		return URL;
	}

	public void setUrl(String url) {
		this.URL = url;
	}

	public String getUser() {
		return USER;
	}

	public void setUser(String user) {
		this.USER = user;
	}

	public String getPassword() {
		return PWD;
	}

	public void setPassword(String password) {
		this.PWD = password;
	}

	public String getFicheroTxt() {
		return ficheroTxt;
	}

	public void setFicheroTxt(String ficheroTxt) {
		this.ficheroTxt = ficheroTxt;
	}

	public String getFicheroBin() {
		return ficheroBin;
	}

	public void setFicheroBin(String ficheroBin) {
		this.ficheroBin = ficheroBin;
	}

	public static String getFicheroXML() {
		return ficheroXML;
	}

	public void setFicheroXML(String ficheroXML) {
		this.ficheroXML = ficheroXML;
	}

}
