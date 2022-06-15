package ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import tags.TagsXML;

public class Ejercicio1 {

	public static void main(String[] args) {
		//Se obtiene la dirección del xml que vamos a leer.
		File xml = new File("src/resources/Aeropuerto.xml");
		//Guardamos la ruta donde vamos a almacenar el registro.
		File registro = new File("src/resources/ejercicio1/registro.txt");
		
		//Utilizamos el try-with-resources para crear el printwriter y que lo cierre automáticamente.
		try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(registro)))) {
			
			//Obtenemos el xml, el elemento raiz y los vuelos.
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
			Element raiz = doc.getDocumentElement();
			NodeList vuelos = raiz.getElementsByTagName(TagsXML.VUELO.getNombre());
			
			//Recorremos todos los vuelos del xml
			for(int i = 0; i < vuelos.getLength(); i++) {
				
				//Obtenemos cada vuelo.
				Element vuelo = (Element) vuelos.item(i);
				
				//Por cada vuelo se obtiene una línea de registro y se escribe en el nuevo documento.
				writer.println(obtenerRegistro(vuelo));
				
			}
			
		} catch (SAXException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Obiene cada etiqueta del vuelo y obteniendo su valor crea un registro
	 * y lo devuelve.
	 * @param vuelo
	 * @return
	 */
	private static String obtenerRegistro(Element vuelo) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(vuelo.getAttribute(TagsXML.ID.getNombre()));
		sb.append(":");
		sb.append(vuelo.getAttribute(TagsXML.CODIGO.getNombre()));
		sb.append(":");
		sb.append(vuelo.getElementsByTagName(TagsXML.COMPANIA.getNombre()).item(0).getTextContent());
		sb.append(":");
		sb.append(vuelo.getElementsByTagName(TagsXML.HORA_SALIDA.getNombre()).item(0).getTextContent());
		sb.append(":");
		sb.append(vuelo.getElementsByTagName(TagsXML.DESTINO.getNombre()).item(0).getTextContent());
		
		return sb.toString();
		
	}
	
}
