package r3_Ejercicio8;

//import java.util.StringTokenizer;

import Leer.Leer;

public class CantidadPalabras {
	public static void main(String[] args) {
		//StringTokenizer
		String texto = Leer.lecturaString("Introduce el texto donde desea contar las palabras.").strip();
		int contadorPalabras = 0;
		int comienzo = 0;
		boolean finalTexto = false;
		while(!finalTexto) {
			int ultimo = texto.indexOf(' ', comienzo);
			if (ultimo != -1) {
				String palabras = texto.substring(comienzo, ultimo);
				if(!palabras.isEmpty()) {
					contadorPalabras++;
				}
				comienzo = ultimo + 1;
			}else {
				contadorPalabras++;
				finalTexto = true;
				
			}			
		}
		
		System.out.printf("Contiene %d palabras", contadorPalabras);
	}
}
