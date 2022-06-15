package ejercicio4;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
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

public class Ejercicio4 {

	private static final String CODIGO_A = "MAD";
	private static final String DIR_CONTINENTES = "src/resources/ejercicio4/";
	private static final String EXTENSION = ".xml";
	
	public static void main(String[] args) {
		
		//Se obtiene la dirección del xml que vamos a leer.
		File xml = new File("src/resources/Aeropuerto.xml");
		
		HashMap<String, Set<Element>> continentes = new HashMap<String, Set<Element>>();
		
		Document doc;
		
		
		try {
			//Se obtiene el documento.
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);

			//Se obtiene la raiz y los vuelos del documento.
			Element raiz = doc.getDocumentElement();
			NodeList vuelos = raiz.getElementsByTagName(TagsXML.VUELO.getNombre());
			
			//Reccorremos todos los vuelos.
			for(int i = 0; i < vuelos.getLength(); i++) {
				//Obtenemos cada vuelo.
				Element vuelo = (Element) vuelos.item(i);
				añadirVuelosMismoCont(continentes, vuelo);
				
			}
			
			for(String idContinente : continentes.keySet()) {
				//Se crea el nuevo documento correspodiente al nuevo xml.
				Document nuevoDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				File continenteXML = new File(DIR_CONTINENTES + "Continente" + idContinente + EXTENSION);
				//Se crea una nueva raiz y se le da el atributo del viejo doc.
				Element nuevaRaiz = nuevoDoc.createElement(TagsXML.AEROPUERTO.getNombre());
				nuevaRaiz.setAttribute(TagsXML.CODIGO.getNombre(), CODIGO_A);
				
				for(Element vuelo : continentes.get(idContinente)) {
					
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
					nuevoVuelo.setAttribute(TagsXML.ID.getNombre(), vuelo.getAttribute(TagsXML.ID.getNombre()));
					nuevoVuelo.setAttribute(TagsXML.CODIGO.getNombre(), vuelo.getAttribute(TagsXML.CODIGO.getNombre()));
					nuevoVuelo.appendChild(compania);
					nuevoVuelo.appendChild(horaSalida);
					nuevoVuelo.appendChild(destino);
					
					nuevaRaiz.appendChild(nuevoVuelo);
					
				}
				
				nuevoDoc.appendChild(nuevaRaiz);
				
				//Transformamos los datos y generamos el documento xml.
				Transformer tf = TransformerFactory.newInstance().newTransformer();
				tf.setOutputProperty(OutputKeys.INDENT, "yes");
				DOMSource source = new DOMSource(nuevoDoc);
				StreamResult result = new StreamResult(continenteXML);
				tf.transform(source, result);
				
				
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	/**
	 * Obtiene el número del identificador que corresponde al continente y lo devuelve.
	 * @param id
	 * @return
	 */
	private static String obtenerNumContinente(String id) {
		
		// Se crea el patron y se obtiene de cada continente el número correspondiente.
		
		Pattern patron = Pattern.compile("^(\\d)(?:\\d*)");
		Matcher m = patron.matcher(id);
		String numCont = "";
		if (m.matches()) {
			
			numCont = m.group(1);
			
		}
		
		return numCont;
		
	}
	
	/**
	 * Obtiene el mapa que almacena los continentes y sus vuelos y el vuelo que se quiere almacenar.
	 * Si el id del continente de ese vuelo ya ha sido guardado anteriormente se añadera a la lista correspondiente
	 * a ese continente. Si no existe creará una nueva lista vinculada la id del continente para almacenar los vuelos
	 * correspondientes.
	 * @param continentes
	 * @param vuelo
	 */
	private static void añadirVuelosMismoCont(HashMap<String, Set<Element>> continentes , Element vuelo) {
		
		String id = vuelo.getAttribute(TagsXML.ID.getNombre());
		String idContinente = obtenerNumContinente(id);
		
		if(continentes.get(idContinente) == null) {
			
			continentes.put(idContinente, new HashSet<Element>());
			continentes.get(idContinente).add(vuelo);
			
		}else {
			
			continentes.get(idContinente).add(vuelo);
			
		}
		
		
	}

	
}
