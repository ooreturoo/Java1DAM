package r3_Ejercicio3;

import Leer.Leer;

public class Palindromo {
	public static void main(String[] args) {
		String palindromo = Leer.lecturaString("Introduce una palabara o frase para saber si es polindromo");
		
		if(palindromo.isEmpty()) {
			System.out.println("La cadena está vacía");
		}else {
			
			String sinEspacios = palindromo.replace(" ", "");
			String alReves = reverse(sinEspacios);
			
			if(sinEspacios.equals(alReves)) {
				System.out.println("Es un palindromo");
			}else {
				System.out.println("No es un palindromo");
			}
		}
	}
	
	private static String reverse(String voltear) {
		char[] caracters = new char[voltear.length()];
		
		for(int i = 0; i < voltear.length(); i++) {
			caracters[voltear.length()-1-i] = voltear.charAt(i);
		}
		
		return String.valueOf(caracters);
	}
}
