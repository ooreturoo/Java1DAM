package ejerciciosMatrices;

public class Ejercicio2 {

	public static void main(String[] args) {
		int[][] matriz = {{4,65,-6,3,7},{34,6,22,45,6}};
		int suma = sumar(matriz);
		System.out.println(suma);

	}
	private static int sumar(int[][] matriz) {
		int suma = 0;
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				suma += matriz[x][y];
			}
		}
		return suma;
	}


}
