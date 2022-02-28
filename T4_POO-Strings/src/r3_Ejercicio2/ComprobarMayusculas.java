package r3_Ejercicio2;

import Leer.Leer;

public class ComprobarMayusculas {
	public static void main(String[] args) {
		String cadena = Leer.lecturaString("Introduce una cadena");
		int mayusculas = 0;
		int minusculas = 0;
		int numeros = 0;
		
		
		for(int i = 0; i < cadena.length(); i++) {
			if(Character.isUpperCase(cadena.charAt(i))) {
				mayusculas++;
			}else if(Character.isDigit(cadena.charAt(i))) {
				numeros++;
			}else if(Character.isLowerCase(cadena.charAt(i))) {
				minusculas++;
			}
		}
		
		System.out.println("Hay " + mayusculas + " en la cadena.");
		System.out.println("Hay " + minusculas + " en la cadena.");
		System.out.println("Hay " + numeros + " en la cadena.");
		
		
		
	}
	
}
