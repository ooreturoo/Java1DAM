package r3_Ejercicio4;

import Leer.Leer;

public class PalabraEscondida {
	public static void main(String[] args) {
		String cadena = Leer.lecturaString("Introduce la cadena en la que buscar la palabra oculta.");
		String palabra = Leer.lecturaString("Introduce la palabra que quieres buscar.");
		
		if(buscarPalabra(cadena, palabra).equalsIgnoreCase(palabra)) {
			System.out.println("Palabra encontrada.");
		}else {
			System.out.println("Palabra no encontrada.");
		}
		
	}
	
	private static String buscarPalabra(String cadena, String palabraBuscar) {
		int charABuscar = 0;
		char[] palabraEncontrada = new char[palabraBuscar.length()];
		for(int i = 0; i < cadena.length(); i++) {
			if(Character.toUpperCase(palabraBuscar.charAt(charABuscar)) == Character.toUpperCase(cadena.charAt(i))) {
				palabraEncontrada[charABuscar] = cadena.charAt(i);
				charABuscar++;
			}
		}
		
		return String.valueOf(palabraEncontrada);
		
		
	}
}
