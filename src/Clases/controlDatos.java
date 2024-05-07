
package Clases;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Backend.TxtCiudades;
import Backend.logicaJuego;
import UI.PanelJuegoDerecha;

public class controlDatos {

	private static String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe"; //casa cambiar ip a  jdbc:oracle:thin:@oracle.ilerna.com:1521:xe
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
		
	// El boto de cargar partida del menu te ha de deixar elegit entre tta la llista de guardados
		
		//setar l'estat de totes les ciutats
		
		//setear l'estat de totes les vacunes
		
		//setear el nº de brotes actius
		
		
		String sql = "SELECT p.NPartida, p.NombreJ, p.dificultad, p.Rondas , p.Fecha , p.Acciones_restantes, p.Brotes, p.Azul.color, p.Azul.porcentage, p.Rojo.color, p.Rojo.porcentage, p.Amarillo.color, p.Amarillo.porcentage, p.Verde.color, p.Verde.porcentage, c.nombre, c.infeccion "
				+ "FROM PartidasGuardadas p, TABLE(p.lista_ciudades) c "
				+ "where npartida = 5";
		

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					int Npartida = rs.getInt("Npartida");
					String NombreJ = rs.getString("NombreJ");
					String Dificultad = rs.getString("dificultad");
					int Rondas = rs.getInt("Rondas");
					String Fecha = rs.getString("Fecha");
					int Acciones_restantes = rs.getInt("Acciones_restantes");
					int Brotes = rs.getInt("Brotes");
				
					
					String colorA = rs.getString("AZUL.color");
					int porcentageA = rs.getInt("AZUL.porcentage");
				
					PanelJuegoDerecha.radioAzul.getVacuna().setPorcentaje(porcentageA);
					PanelJuegoDerecha.labelAzul.setText(porcentageA + "%");
					
					String colorR = rs.getString("ROJO.color");
					int porcentageR = rs.getInt("ROJO.porcentage");
					
					PanelJuegoDerecha.radioRojo.getVacuna().setPorcentaje(porcentageR);
					PanelJuegoDerecha.labelRojo.setText(porcentageR + "%");

					
					String colorAM = rs.getString("Amarillo.color");
					int porcentageAM = rs.getInt("Amarillo.porcentage");
					
					PanelJuegoDerecha.radioAmarillo.getVacuna().setPorcentaje(porcentageAM);
					PanelJuegoDerecha.labelAmarillo.setText(porcentageAM + "%");


					String colorV = rs.getString("Verde.color");
					int porcentageV = rs.getInt("Verde.porcentage");
					
					PanelJuegoDerecha.radioVerde.getVacuna().setPorcentaje(porcentageV);;
					PanelJuegoDerecha.labelVerde.setText(porcentageV + "%");

					while (rs.next()) {
						
						
					}
					
					


					//Ciudades cd = new Ciudades();

					/*C.add(cd);*/				}
			} else {
				System.out.println("No he encontrado nada");
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
	public void crarCiudadesCargado() {
		
		for (int i = 0; i < logicaJuego.dp.ciudades.size(); i++) {
		}
	}
	
	public static void guardarPartida(Connection con) {

		
		
		//int Npartida = 0; //No repetir xq peta x unique constraint
		String NombreJ = "test_selectJava2";  // Se ha de fer que salto una pantalla de introduzca nombre y gurardarho en esta variable
		String dificultad = "Dificil"; // Se ha de treure del xml
		int rondas = 10; //Contador de rondes
		//String Fecha = "03/05/2024";
		int acciones_restantes = 4; // Contador de accions
		int brotes = 7; // Contador de brotes
		
		String nombreVacuna = "Azul"; //Objecte vacuna
		String nombreVacuna2 = "Rojo"; //Objecte vacuna
		String nombreVacuna3 = "Amarillo"; //Objecte vacuna
		String nombreVacuna4 = "Verde"; //Objecte vacuna
		int porcentageVacuna = 50; //Objecte vacuna
		
		String nombreCiudad = "Milan"; //Objecte ciutat
		int infeccionCiudad = 3;  //Objecte ciutat
		
		String ciudadesInsert = "";
		logicaJuego.crearArrayCiudades();
		
		for (int i = 0; i < logicaJuego.dp.ciudades.size(); i++) {
			if (i == logicaJuego.dp.ciudades.size() -1) {
				String ciudadSQL = "CIUDAD('" + logicaJuego.dp.ciudades.get(i).getNombre() +" ', "+logicaJuego.dp.ciudades.get(i).getEnfermedad()+" )";
				ciudadesInsert += ciudadSQL;
			}else {
				String ciudadSQL = "CIUDAD('" + logicaJuego.dp.ciudades.get(i).getNombre() +"', "+logicaJuego.dp.ciudades.get(i).getInfeccion()+" ), ";
				ciudadesInsert += ciudadSQL;
			}	
		}
		
		

		
		String sql = "INSERT INTO PartidasGuardadas VALUES( NUM_PARTIDA.NEXTVAL  , '" + NombreJ + "',  '" + dificultad + "', "  +  rondas + ", SYSDATE , "  +  acciones_restantes + ",  "  +  brotes + ", VACUNA('"  +  nombreVacuna + "', "  +  
		porcentageVacuna + "), VACUNA('"  +  nombreVacuna2 + "', "  +  porcentageVacuna + ") , VACUNA('"  +  nombreVacuna3 + "', "  +  porcentageVacuna + ") , VACUNA('"  +  nombreVacuna4 + "', "  +  porcentageVacuna + ") , "
				+ "Lista_ciudades(" + ciudadesInsert +"))";

			
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Insert registrado correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
}
	
	public static void cargarRecord() {
		
	}
	
	public static void guardarRecord() {
		
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

	public  void setFicheroXML(String ficheroXML) {
		this.ficheroXML = ficheroXML;
	}

}

