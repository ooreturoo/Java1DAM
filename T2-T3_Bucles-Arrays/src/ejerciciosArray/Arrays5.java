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
		int tamaño = Leer.lecturaInt("Introduce el tamaño del array.", 0, true);
		crearArray(tamaño);
	}
}
