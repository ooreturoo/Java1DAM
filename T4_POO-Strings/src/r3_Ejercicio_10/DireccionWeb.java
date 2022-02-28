package r3_Ejercicio_10;

import Leer.Leer;

public class DireccionWeb {
	public static void main(String[] args) {
		boolean direccionValida;
		String web = Leer.lecturaString("Introduce la direccion web.").strip().toLowerCase();
		
		if(web.isEmpty()) {
			direccionValida = false;
		}else if(web.startsWith("http://www.") && (web.endsWith(".com") || web.endsWith(".es"))) {
			if(!web.contains(" ") && Character.isLetter(web.indexOf('.' + 1))) {
				direccionValida = true;
			}else {
				direccionValida = false;
			}
		}else {
			direccionValida = false;
		}
		
		if(direccionValida) {
			System.out.println("Es una dirección web válida.");
		}else {
			System.out.println("Es una dirección web inválida.");
		}
	}
}
