package programa;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Clases.controlDatos;


public class parametros {
	private static String fileName = controlDatos.getFicheroXML();
	private static String fileName2 = "parametros_2.xml";
	
	/*private static String porcentaje_vacuna;
	private static String brotes_maximos;
	private static String propagacion_turno;
	private static String infeccion_inicial;*/


	public static void main(String[] args) {
		//Un cop haver fet la funcio que llegeix y escriu(esciure un nou parametros2.xml) s'ha de fer que llegeixo el xml y ho cargo a datosPartida.java (afegir nous camps)
		
		//leerXML(); Funciona
		//EscribirXML(); Funciona
		//cargarXML(); Funciona
	}

	public static void leerXML() {

		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

			NodeList nodeList = doc.getElementsByTagName("dificultad");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					
					String id = element.getAttribute("id");
					String porcentaje_vacuna = element.getElementsByTagName("Porcentaje_vacuna").item(0)
							.getTextContent();
					String brotes_maximos = element.getElementsByTagName("Brotes_maximos").item(0).getTextContent();
					String propagacion_turno = element.getElementsByTagName("Propagacion_turno").item(0)
							.getTextContent();
					String infeccion_inicial = element.getElementsByTagName("Infeccion_inicial").item(0)
							.getTextContent();

					System.out.println("----------------------");
					System.out.println("-Dificultad --> " + id);
					System.out.println();
					System.out.println("-% de desarollo por accion --> " + porcentaje_vacuna);
					System.out.println("-Brotes maximos antes de derrota --> " + brotes_maximos);
					System.out.println("-Propagacion a ciudades por turno --> " + propagacion_turno);
					System.out.println("-Ciudades infectadas al inicio --> " + infeccion_inicial);
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	public static void cargarXML(int porcentaje, int brotes, int ronda, int inicio) {
		Scanner scan = new Scanner(System.in);
		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();


			NodeList nodeList = doc.getElementsByTagName("dificultad");
			
			System.out.println("Eliga que dificultad quiere usar Facil/Normal/Dificil");
			String eleccion = scan.nextLine();
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					
					String id = element.getAttribute("id");
					if (eleccion.equals(id)) {
					porcentaje = Integer.parseInt(element.getElementsByTagName("Porcentaje_vacuna").item(0)
							.getTextContent());
					brotes = Integer.parseInt(element.getElementsByTagName("Brotes_maximos").item(0).getTextContent());

					ronda = Integer.parseInt(element.getElementsByTagName("Propagacion_turno").item(0)
							.getTextContent());
					inicio = Integer.parseInt(element.getElementsByTagName("Infeccion_inicial").item(0)
							.getTextContent());
					}
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void EscribirXML() {
		
			Scanner scan_string = new Scanner(System.in);

			System.out.println("Eliga la dificultad que quiere configurar");
			String dificultad = scan_string.nextLine();
			
			System.out.println("Configure el porcentaje de vacuna por accion");
			String p_vacuna = scan_string.nextLine();
			
			System.out.println("Configure el numero maximo de brotes por partida");
			String brotes_max = scan_string.nextLine();

			System.out.println("Configure el numero de ciudades infectadas por ronda");
			String propagcion = scan_string.nextLine();
			
			System.out.println("Configure el numero de ciudades infectadas al inicio de la partida");
			String infeccion_i = scan_string.nextLine();
			
		
		 try {
	            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	            Document doc = docBuilder.newDocument();
	            Element rootElement = doc.createElement("Parametros");
	            doc.appendChild(rootElement);

	            Element item = doc.createElement("Dificultad");
	            rootElement.appendChild(item);

	            item.setAttribute("id", dificultad);
	            
	            Element porcentaje_vacuna = doc.createElement("porcentaje_vacuna");
	            porcentaje_vacuna.appendChild(doc.createTextNode(p_vacuna));
	            item.appendChild(porcentaje_vacuna);
	            
	            Element brotes_maximos = doc.createElement("brotes_maximos");
	            brotes_maximos.appendChild(doc.createTextNode(brotes_max));
	            item.appendChild(brotes_maximos);
	            
	            Element propagacion_turno = doc.createElement("propagacion_turno");
	            propagacion_turno.appendChild(doc.createTextNode(propagcion));
	            item.appendChild(propagacion_turno);

	          
	            Element infeccion_inicial = doc.createElement("infeccion_inicial");
	            infeccion_inicial.appendChild(doc.createTextNode(infeccion_i));
	            item.appendChild(infeccion_inicial);
	            
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(fileName2);

	            transformer.transform(source, result);

	            System.out.println("XML " + fileName2 + " creado y guardado :)");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		
	}
	

	

}
