package ejerciciosMatrices;

public class Ejercicio_16 {
	public static void main(String[] args) {
		int[][] matriz = {{1,2,3,4,5},{6,7,8,9,0},{3,2,1,4,5},{9,5,8,6,7},{0,9,8,5,4}};
		int[][] matrizPares = new int[matriz.length][matriz[0].length];
		

		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[0].length; j++) {
				matrizPares[i][j] = cambiarMatriz(matriz, i, j);
				System.out.print(matrizPares[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	private static int cambiarMatriz(int[][] matriz, int i, int j) {
		int contadorPares = 0;
		for(int x = i-1; x <= i+1; x++) {
			if(x < 0 || x >= matriz.length) {
				continue;
			}
			for(int y = j-1; y <= j+1; y++) {
				if(y < 0 || y >= matriz[0].length) {
					continue;
				}
				if(matriz[x][y] % 2 == 0 && !(x == i && y == j)) {
					contadorPares++;
				}
			}
			
		}
		
		
		
		return contadorPares;
	}
}
