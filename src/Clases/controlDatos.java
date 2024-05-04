
package Clases;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class controlDatos {

	private static String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe"; //casa cambiar ip a  jdbc:oracle:thin:@oracle.ilerna.com:1521:xe
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
		
		
		String sql = "SELECT p.NPartida, p.NombreJ, p.dificultad, p.Rondas , p.Fecha , p.Acciones_restantes, p.Brotes, p.Azul.color, p.Azul.porcentage,  c.nombre, c.infeccion "
				+ "FROM PartidasGuardadas p, TABLE(p.lista_ciudades) c "
				+ "where npartida = 3";
		
		ArrayList<Ciudades> C = new ArrayList<Ciudades>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					int Npartida = rs.getInt("Npartida");
					String NombreJ = rs.getString("NombreJ");
					int Rondas = rs.getInt("Rondas");
					String Fecha = rs.getString("Fecha");
					int Acciones_restantes = rs.getInt("Acciones_restantes");
					int Brotes = rs.getInt("Brotes");
					
					
					Struct Vacuna = (Struct) rs.getObject("Azul");
					Object[] valoresVacuna = Vacuna.getAttributes();
					String color = (String) valoresVacuna[0];
					int porcentage = (int) valoresVacuna[1];
					
				
					Struct Ciudad = (Struct) rs.getObject("Lista_ciudades");
					Object[] valoresCiudad = Vacuna.getAttributes();
					String nombre = (String) valoresCiudad[0];
					int infeccion = (int) valoresCiudad[1];
					
					
					System.out.println(Vacuna.toString());
					System.out.println(Ciudad.toString());


					//Ciudades cd = new Ciudades();

					/*C.add(cd);*/				}
			} else {
				System.out.println("No he encontrado nada");
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
	
	
	public static void guardarPartida(Connection con) {
		// Un boto de guardar partida sempre visible en pantalla ha d fer saltar esta funcio
		
		//Guardar l'estat de totes les ciutats
		
		//Guardar l'estat de totes les vacunes
		
		//Guardar el nº de brotes actius
		
		
		//int Npartida = 0; //No repetir xq peta x unique constraint
		String NombreJ = "test_selectJava";
		String dificultad = "Normal";
		int rondas = 10;
		//String Fecha = "03/05/2024";
		int acciones_restantes = 1;
		int brotes = 3;
		String nombreVacuna = "Azul";
		String nombreVacuna2 = "Rojo";
		String nombreVacuna3 = "Amarillo";
		String nombreVacuna4 = "Verde";
		int porcentageVacuna = 50;
		String nombreCiudad = "Chicago";
		int infeccionCiudad = 1; 
		

		String sql = "INSERT INTO PartidasGuardadas VALUES( NUM_PARTIDA.NEXTVAL  , '" + NombreJ + "',  '" + dificultad + "', "  +  rondas + ", SYSDATE , "  +  acciones_restantes + ",  "  +  brotes + ", VACUNA('"  +  nombreVacuna + "', "  +  
		porcentageVacuna + "), VACUNA('"  +  nombreVacuna2 + "', "  +  porcentageVacuna + ") , VACUNA('"  +  nombreVacuna3 + "', "  +  porcentageVacuna + ") , VACUNA('"  +  nombreVacuna4 + "', "  +  porcentageVacuna + ") , "
				+ "Lista_ciudades(CIUDAD('"  +  nombreCiudad + "', "  +  infeccionCiudad + ")))";

			
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

