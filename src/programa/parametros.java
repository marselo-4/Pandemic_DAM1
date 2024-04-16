package programa;

import java.io.File;

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


public class parametros {
	private static String fileName = "parametros.xml";

	public static void main(String[] args) {

		
		//modificarXML();  //No executar si executes te borre el xml y el fa de 0 amb el codi que li dones.
		imprimirXMLconsola();
	}

	public static void imprimirXMLconsola() {

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
					System.out.println("-% de desarollo por accion --> " + porcentaje_vacuna);
					System.out.println("-Brotes maximos antes de derrota --> " + brotes_maximos);
					System.out.println("-Propagacion a ciudades por turno --> " + propagacion_turno);
					System.out.println("-Ciudades infectadas al inicio --> " + infeccion_inicial);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modificarXML() {
		
		 try {
	            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	            Document doc = docBuilder.newDocument();
	            Element rootElement = doc.createElement("parametros");
	            doc.appendChild(rootElement);

	            Element item = doc.createElement("dificultad");
	            rootElement.appendChild(item);

	            Element name = doc.createElement("name");
	            name.appendChild(doc.createTextNode("Product ABC"));
	            item.appendChild(name);

	    
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(fileName);

	            transformer.transform(source, result);

	            System.out.println("XML file saved successfully.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		
	}

}
