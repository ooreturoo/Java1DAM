package r1_Ejercicio1;

import Leer.Leer;

public class Principal {
	public static void main(String[] args) {
		Rectangulo rectangulo = new Rectangulo();
		
		rectangulo.setAncho(Leer.lecturaInt("Introduce el ancho del rectangulo (1-20)"));
		rectangulo.setLongitud(Leer.lecturaInt("Introduce la longitud del rectangulo (1-20)"));
		
		System.out.println("El area del rectangulo es: " + rectangulo.areaRectangulo());
		System.out.println("El perimetro del rectangulo es: " + rectangulo.perimetroRectangulo());
	}
}
