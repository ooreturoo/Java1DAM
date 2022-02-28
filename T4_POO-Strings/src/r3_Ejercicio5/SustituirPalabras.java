package r3_Ejercicio5;

import Leer.Leer;

public class SustituirPalabras {
	public static void main(String[] args) {
		String cadena = Leer.lecturaString("Introduce el texto.");
		String palabra = Leer.lecturaString("Introduce la palabra a sustituir");
		String nuevaPalabra = Leer.lecturaString("Introduce la nueva palabra");
		
		String cadena1 = cadena.replace(palabra, nuevaPalabra);
		
		cadena = cadena1;
		
		System.out.println(cadena);
		
		
	}
}
