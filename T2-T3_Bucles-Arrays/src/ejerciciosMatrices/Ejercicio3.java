package ejerciciosMatrices;

public class Ejercicio3 {

	public static void main(String[] args) {
		int[][] matriz = {{1,3,5},{0,2,7}};
		imprimir(matriz);

	}
	private static void imprimir(int[][] matriz) {
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				System.out.print(matriz[x][y] + " ");
			}
		}
		
	}
}
