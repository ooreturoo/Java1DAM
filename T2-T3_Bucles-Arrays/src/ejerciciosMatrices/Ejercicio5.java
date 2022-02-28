package ejerciciosMatrices;

public class Ejercicio5 {
	public static void main(String[] args) {
		int[][] matriz = {{1,3,5},{2,7,3}};
		imprimir(matriz);

	}
	private static void imprimir(int[][] matriz) {
		for(int y = 0; y < matriz[0].length; y++) {
			for(int x = 0; x < matriz.length; x++) {
				System.out.print(matriz[x][y] + " ");
			}
			System.out.println();
		}
		
	}
}
