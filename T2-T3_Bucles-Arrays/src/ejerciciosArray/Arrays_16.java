package ejerciciosArray;

import Leer.Leer;

public class Arrays_16 {
	public static void main(String[] args) {
		int[][] numeros = new int[Leer.lecturaInt("¿Hasta qué número quieres calcular las tablas de multiplicar?", 0, true)][10];
		for(int i = 0; i < numeros.length; i++) {
			for(int j= 0; j < numeros[0].length; j++) {
				numeros[i][j] = (j+1) * (i+1);
			}
		}
		
		for(int i = 0; i < numeros.length; i++) {
			for(int j= 0; j < numeros[0].length; j++) {
				System.out.print(numeros[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
