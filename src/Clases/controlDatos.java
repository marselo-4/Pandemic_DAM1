
package Clases;

import java.sql.*;
import java.sql.SQLException;

public class controlDatos {

	private static String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe"; // testing a casa cambiar ip a  jdbc:oracle:thin:@oracle.ilera.com:1521:xe
	private static String USER = "DAM1_2324_ALE_LUJAN";
	private static String PWD = "Lujan1234.";
	private String ficheroTxt;
	private String ficheroBin;
	private static String ficheroXML = "parametros.xml";
	
	public static void main(String[] args) throws SQLException {
		Connection con = conectarBaseDatos();

		if (con != null) {
			guardarPartida(con);
			//select(con);
			con.close();
		}

	}
	
	private static Connection conectarBaseDatos() {
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
		
		
		
	}
	
	public static void guardarPartida(Connection con) {
		// Un boto de guardar partida sempre visible en pantalla ha d fer saltar esta funcio
		
		//Guardar l'estat de totes les ciutats
		
		//Guardar l'estat de totes les vacunes
		
		//Guardar el nº de brotes actius
		
		String sql = "INSERT INTO PartidasGuardadas VALUES( 69, 'Juan', 10, null, 2, 9 , VACUNA('Azul', 30),  VACUNA('Rojo', 40), VACUNA('Amarillo', 20), VACUNA('Verde', 10), Lista_ciudades(CIUDAD('San Francisco', 3), CIUDAD('Atlanta', 1)))";
				
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

