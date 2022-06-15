package ejercicio2;


import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import tags.TagsXML;

public class Ejercicio2 {

	public static void main(String[] args) {
		//Se obtiene la dirección del xml que vamos a leer.
		File xml = new File("src/resources/Aeropuerto.xml");
		//Guardamos la ruta donde vamos a almacenar el nuevo archivo.
		File nuevoXML = new File("src/resources/ejercicio2/Aeropuerto.xml");
		
		Document nuevoDoc;
		Document doc;
		
		try {
			//Se obtiene el documento.
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
			//Se crea el nuevo documento correspodiente al nuevo xml.
			nuevoDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			//Se obtiene la raiz y los vuelos del documento.
			Element raiz = doc.getDocumentElement();
			NodeList vuelos = raiz.getElementsByTagName(TagsXML.VUELO.getNombre());
			
			//Se crea una nueva raiz y se le da el atributo del viejo doc.
			Element nuevaRaiz = nuevoDoc.createElement(TagsXML.AEROPUERTO.getNombre());
			nuevaRaiz.setAttribute(TagsXML.CODIGO.getNombre(), raiz.getAttribute(TagsXML.CODIGO.getNombre()));
			
			//Reccorremos todos los vuelos.
			for(int i = 0; i < vuelos.getLength(); i++) {
				
				//Obtenemos cada vuelo.
				Element vuelo = (Element) vuelos.item(i);
				
				//Se obtiene el nuevo id de cada vuelo
				String identificador = identificadorOrdenado(vuelo);
				
				
				//Se crea las demás etiquetas copiando su texto del viejo documento.
				Element compania = nuevoDoc.createElement(TagsXML.COMPANIA.getNombre());
				compania.setTextContent(vuelo.getElementsByTagName(TagsXML.COMPANIA.getNombre()).item(0).getTextContent());
				
				Element horaSalida = nuevoDoc.createElement(TagsXML.HORA_SALIDA.getNombre());
				horaSalida.setTextContent(vuelo.getElementsByTagName(TagsXML.HORA_SALIDA.getNombre()).item(0).getTextContent());
				
				Element destino = nuevoDoc.createElement(TagsXML.DESTINO.getNombre());
				destino.setTextContent(vuelo.getElementsByTagName(TagsXML.DESTINO.getNombre()).item(0).getTextContent());
				
				/*
				 * Se crea el nuevo vuelo y se le asignas todas los elementos anteriormente creados
				 * y todos los atributos.
				 */
				Element nuevoVuelo = nuevoDoc.createElement(TagsXML.VUELO.getNombre());
				nuevoVuelo.setAttribute(TagsXML.ID.getNombre(), identificador);
				nuevoVuelo.setAttribute(TagsXML.CODIGO.getNombre(), vuelo.getAttribute(TagsXML.CODIGO.getNombre()));
				nuevoVuelo.appendChild(compania);
				nuevoVuelo.appendChild(horaSalida);
				nuevoVuelo.appendChild(destino);
				
				//Añadimos cada vuelo al elemento raiz.
				nuevaRaiz.appendChild(nuevoVuelo);
				
			}
			
			//Añadimos la raiz al nuevo documento.
			nuevoDoc.appendChild(nuevaRaiz);
			
			
			
			//Transformamos los datos y generamos el documento xml.
			Transformer tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(nuevoDoc);
			StreamResult result = new StreamResult(nuevoXML);
			tf.transform(source, result);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	/**
	 * Se encarga de obtener el identificador del vuelo, darle el nuevo
	 * orden solicitado y devolverlo.
	 * @param vuelo
	 * @return
	 */
	private static String identificadorOrdenado(Element vuelo) {
		
		String id = vuelo.getAttribute(TagsXML.ID.getNombre());
		StringBuilder idFinal = new StringBuilder();
		/*
		 * Se crea el patrón que corresponderá con el id de cada vuelo dividiendolos
		 * en grupos para luego añadirlos en el StringBuilder en el orden deseado.
		 */
		Pattern patron = Pattern.compile("^(\\d)(\\d{2})(\\d{2})(\\d{3})$");
		Matcher m = patron.matcher(id);
		if(m.matches()) {
			
			idFinal.append(m.group(3));
			idFinal.append(m.group(4));
			idFinal.append(m.group(1));
			idFinal.append(m.group(2));
			
		}
		
		return idFinal.toString();
		
	}
	
}
