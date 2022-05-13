package main;

import java.util.HashMap;

import clases.DatosUsuario;

public class Principal {

	public static void main(String[] args) {
		
		DatosUsuario usuario1 = new DatosUsuario("ReTuR", "Sergio", "sergiomm50@gmail.com");
		DatosUsuario usuario2 = new DatosUsuario("Pepe356", "Jose Antonio", "elcallejero@gmail.com");
		DatosUsuario usuario3 = new DatosUsuario("66Germn66", "Luisa", "retirada542@gmail.com");
		DatosUsuario usuario4 = new DatosUsuario("Jjrios", "Jose", "rataroja@gmail.com");
		DatosUsuario usuario5 = new DatosUsuario("RutaRoja", "María", "almacenamiento@gmail.com");
		DatosUsuario usuario6 = new DatosUsuario("Benzema543", "Antonio", "pobrerico@gmail.com");

		HashMap<String, DatosUsuario> almacenamiento = new HashMap<String, DatosUsuario>();
		
		almacenamiento.put(usuario1.getUsuario(), usuario1);
		almacenamiento.put(usuario2.getUsuario(), usuario2);
		almacenamiento.put(usuario3.getUsuario(), usuario3);
		almacenamiento.put(usuario4.getUsuario(), usuario4);
		almacenamiento.put(usuario5.getUsuario(), usuario5);
		almacenamiento.put(usuario6.getUsuario(), usuario6);
		
		almacenamiento.keySet().stream().filter( u -> u.matches(".*(\\d+).*")).forEach(System.out::println);
		
		
	}
	


}
