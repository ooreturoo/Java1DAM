package r3_Ejercicio_12;

import Leer.Leer;

public class ComprobarEmail {
	public static void main(String[] args) {
		String email = Leer.lecturaString("Introduce un email.");
		
		boolean emailCorrecto = false;
		if(email.isEmpty()) {
			System.out.println("No has introducido nada.");
		}else {
			if(Character.isLetter(email.charAt(0))&& email.contains("@")) {
				
				if(comprobarCaracteres(email.substring(0,email.indexOf('@'))) && comprobarCaracteres(email.substring(email.indexOf('@')+1))) {
					
					String organizacion = email.substring(email.indexOf('@')+1);
					
					if(organizacion.contains(".") && Character.isLetter(organizacion.charAt(0))) {
						
						String fin = organizacion.substring(organizacion.indexOf('.')+1);
						
						if(fin.length() >= 2) {
							
							for(int i = 0; i < fin.length(); i++) {
								
								if(Character.isLetter(fin.charAt(i))) {
									emailCorrecto = true;
								}
							}
						}		
					}
				}	
			}
		}
		
		
		if(emailCorrecto) {
			System.out.println("El email es correcto.");
		}else {
			System.out.println("El email es incorrecto.");
		}
		
	}
	
	
	
	
	private static boolean comprobarCaracteres(String subString) {
		for(int i = 0; i < subString.length(); i++) {
			if(!Character.isLetter(subString.charAt(i)) && !Character.isDigit(subString.charAt(i)) && subString.charAt(i) != '.') {
				return false;
			}
		}
		return true;
	}
}
