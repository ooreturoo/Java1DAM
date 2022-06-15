package ejercicio3;

import java.io.File;
import java.util.HashSet;

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

public class Ejercicio3 {

	public static void main(String[] args) {
		
		//Se obtiene la ruta del xml del que obtendremos los datos.
		File xml = new File("src/resources/Aeropuerto.xml");
		
		//Guardamos la ruta donde vamos a almacenar el nuevo XML.
		File nuevoXML = new File("src/resources/ejercicio3/compañias.xml");
		Document nuevoDoc;
		Document doc;
		
		try {
			
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
			//Creamos un HashSet para almacenar los nombres de las compañías y que no estén repetidas.
			HashSet<String> nombresCompanias = new HashSet<String>();
			nuevoDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			
			//Obtenemos la raiz del xml y sus vuelos
			Element raiz = doc.getDocumentElement();
			NodeList vuelos = raiz.getElementsByTagName(TagsXML.VUELO.getNombre());
			
			//Se crea la raiz del nuevo xml.
			Element nuevaRaiz = nuevoDoc.createElement("compañias");
			
			//Se recorren todos los vuelos.
			for(int i = 0; i < vuelos.getLength(); i++) {
				
				Element vuelo = (Element) vuelos.item(i);
				
				//Por cada vuelo se obtiene la compañía y se añade al HashSet.
				String compania = vuelo.getElementsByTagName(TagsXML.COMPANIA.getNombre()).item(0).getTextContent();
				nombresCompanias.add(compania);
				
			}
			
			/*
			 * Se recorre todo el HashSet y por cada nombre se crea un nuevo elemento donde
			 * almacenar el valor y se añade al raiz del nuevo xml.
			 */
			
			for(String nombreCompania : nombresCompanias) {
				
				Element compania = nuevoDoc.createElement(TagsXML.COMPANIA.getNombre());
				compania.setTextContent(nombreCompania);
				nuevaRaiz.appendChild(compania);
				
			}
			
			//Se añade la nueva raiz al doc del nuevo xml.
			nuevoDoc.appendChild(nuevaRaiz);
			
			//Transformamos los datos y se crea el nuevo documento xml.
			Transformer tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(nuevoDoc);
			StreamResult result = new StreamResult(nuevoXML);
			tf.transform(source, result);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
}
