package ejerciciosMatrices;

public class Ejercicio8 {

	public static void main(String[] args) {
		int[][] matriz1 = {{4,65,-6,3,7},{34,6,22,45,6}};
		int[][] matriz2 = {{4,65,-6,3,7},{34,6,22,45,6}};
		
		int suma[][] = sumados(matriz1, matriz2);
		
		for(int x = 0; x < suma.length; x++) {
			for(int y = 0; y < suma[0].length; y++) {
				System.out.print(suma[x][y] + " ");;
			}
		}
		

	}
	
	private static int[][] sumados(int[][] matriz1, int[][] matriz2) {
		int[][] suma = new int[matriz1.length][matriz1[0].length];
		for(int x = 0; x < matriz1.length; x++) {
			for(int y = 0; y < matriz1[0].length; y++) {
				suma[x][y] = matriz1[x][y] + matriz2[x][y];
			}
		}
		return suma;
	}

}
