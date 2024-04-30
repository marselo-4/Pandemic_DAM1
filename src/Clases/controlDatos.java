package Clases;

public class controlDatos {

	private String url = "jdbc:oracle:thin:@192.168.3.26:1521:xe"; // testing a casa cambiar ip a  jdbc:oracle:thin:@oracle.ilera.com:1521:xe
	private String USER = "DAM1_2324_ALE_LUJAN";
	private String password = "Lujan1234.";
	private String ficheroTxt;
	private String ficheroBin;
	private static String ficheroXML = "parametros.xml";
	
	public static void cargarCiudades() {
		
	}
	
	public static void cargarVacunas() {
		
	}
	
	public static void cargarVirus() {
		
	}
	
	public static void cargarPartida() {
	// El boto de cargar partida del menu te ha de deixar elegit entre tta la llista de guardados
		
		//setar l'estat de totes les ciutats
		
		//setear l'estat de totes les vacunes
		
		//setear el nº de brotes actius
	}
	
	public static void guardarPartida() {
		// Un boto de guardar partida sempre visible en pantalla ha d fer saltar esta funcio
		
		//Guardar l'estat de totes les ciutats
		
		//Guardar l'estat de totes les vacunes
		
		//Guardar el nº de brotes actius
		
		
	}
	
	public static void cargarRecord() {
		
	}
	
	public static void guardarRecord() {
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return USER;
	}

	public void setUser(String user) {
		this.USER = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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


/*
 * CREATE OR REPLACE TYPE VACUNA AS OBJECT (
color VARCHAR2(20),
porcentage NUMBER(3)
);

CREATE OR REPLACE TYPE CIUDAD AS OBJECT (
nombre VARCHAR2(20),
infeccion NUMBER(1)
);

CREATE TABLE PartidasGuardadas (
NPartida NUMBER(4) PRIMARY KEY,
FECHA DATE DEFAULT SYSDATE,
azul VACUNA,
rojo VACUNA,
amarillo VACUNA,
verde VACUNA
);*/
