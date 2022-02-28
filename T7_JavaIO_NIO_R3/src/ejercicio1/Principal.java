package ejercicio1;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Principal {
	public static void main(String[] args) {
		List <Persona> personas = new ArrayList<>();
		personas.add(new Persona("Pepe", 78983829, 654645342,LocalDate.of(1994, 2, 14)));
		personas.add(new Persona("Juan", 78398439, 654444342,LocalDate.of(1992, 5, 24)));
		personas.add(new Persona("Alberto", 78982214, 600940954,LocalDate.of(1988, 7, 23)));
		personas.add(new Persona("Rodolfo", 78983811, 655234642,LocalDate.of(2000, 12, 11)));
		personas.add(new Persona("Manuel", 78989809, 654644332,LocalDate.of(1976, 1, 5)));
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			doc.appendChild(doc.createElement("main"));
			
			
			
			for(int i = 0; i < personas.size(); i++) {
				
				Element e = doc.createElement("persona");
				Element nombre = doc.createElement("nombre");
				Element dni = doc.createElement("dni");
				Element telelefono = doc.createElement("telefono");
				Element fNacimiento = doc.createElement("fechaNacimiento");
				
				nombre.setTextContent(personas.get(i).getNombre());
				dni.setTextContent(Integer.toString(personas.get(i).getDni()));
				telelefono.setTextContent(Integer.toString(personas.get(i).getTelefono()));
				fNacimiento.setTextContent(personas.get(i).getFechaNacimiento().toString());
				e.appendChild(nombre);
				e.appendChild(dni);
				e.appendChild(telelefono);
				e.appendChild(fNacimiento);
				
				doc.getDocumentElement().appendChild(e);
			}
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/archivos/Personas.xml"));
			trans.transform(source, result);
			
			
			
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
	}
}
