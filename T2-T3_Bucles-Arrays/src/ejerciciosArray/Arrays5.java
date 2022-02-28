package ejerciciosArray;

import Leer.Leer;

public class Arrays5 {
	private static final int nAleatorios = 1000;
	
	public static void crearArray(int longitud) {
		int[] numeros = new int[longitud];
		for(int i = 0; i < longitud; i++) {
			numeros[i] = (int) Math.round(Math.random()*nAleatorios);
			System.out.println(numeros[i]);
		}
	}
	
	public static void main(String[] args) {
		int tama�o = Leer.lecturaInt("Introduce el tama�o del array.", 0, true);
		crearArray(tama�o);
	}
}
