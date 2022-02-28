package r3_Ejercicio7;

import Leer.Leer;

public class VocalesAlFinal {
	public static void main(String[] args) {
		String texto = Leer.lecturaString("Introduce la frase o palabra.");
		
		System.out.println(moverVocales(texto));
		
	}
	
	private static String moverVocales(String texto) {
		StringBuffer resultado = new StringBuffer(texto.length());
		StringBuffer vocales = new StringBuffer(texto.length());
		
		char[] cadena = texto.toCharArray();
		
		for(int i = 0; i < texto.length(); i++) {
			if(texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u') {
				vocales.append(texto.charAt(i));
				cadena[i] = ' ';
			}
		}
		
		resultado.append(String.valueOf(cadena).replace(" ", ""));
		resultado.append(vocales);
		return resultado.toString();
	}
}
