package ejerciciosMatrices;

public class Ejercicio6 {
	public static void main(String[] args) {
		int[][] matriz = {{1,3,5},{0,2,7}};
		imprimir(matriz);

	}
	private static void imprimir(int[][] matriz) {
		for(int y = matriz[0].length-1; y >= 0; y--) {
			for(int x = matriz.length-1; x >= 0; x--) {
				System.out.print(matriz[x][y] + " ");
			}
		}
		
	}
}
