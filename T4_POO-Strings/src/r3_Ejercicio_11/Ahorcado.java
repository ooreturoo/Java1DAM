package r3_Ejercicio_11;

import Leer.Leer;

public class Ahorcado {

	
	public static void main(String[] args) {
		String palabraOculta = "elefante";
		char[] letrasAdivinada = new char[palabraOculta.length()];
		for(int i = 0; i < letrasAdivinada.length; i++) {
			letrasAdivinada[i] = '-';
		}
		
		boolean palabraAdivinada = false;
		
		int fallos = 0;
		while(!palabraAdivinada && fallos != 7) {
			
			String partesAdivinadas = String.valueOf(letrasAdivinada);
			
			if(String.valueOf(letrasAdivinada).equals(palabraOculta)) {
				
				System.out.println(partesAdivinadas);
				System.out.println("¡Enhorabuena, has acertado! La palabra era " + partesAdivinadas + ".");
				palabraAdivinada = true;
				
			}else {
				
				System.out.print(String.valueOf(partesAdivinadas));
				System.out.println("\tFallos: " + fallos);
				char letra = Leer.lecturaChar("Introduce una letra de la palabra.");
				
				if(palabraOculta.indexOf(letra) != -1) {
					
					for(int i = 0; i < letrasAdivinada.length; i++) {
						
						if(palabraOculta.charAt(i) == letra) {
							letrasAdivinada[i] = letra;
						}
						
					}
					
				}else {
					
					fallos++;
					
				}
			}
		}	
		
		if(fallos == 7) {
			System.out.print("Fallos: " + fallos);
			System.out.println("\tHas perdido. Has llegado a los 7 fallos");
		}
	}
	
}
