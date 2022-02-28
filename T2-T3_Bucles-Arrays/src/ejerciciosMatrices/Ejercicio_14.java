package ejerciciosMatrices;

public class Ejercicio_14 {
	
	public static void main(String[] args) {
		int[][] matriz = {{11,12,13,14},{15,16,17,18},{19,20,21,22}};
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				System.out.print(matriz[x][y] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		matriz = transformar(matriz);
		
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				System.out.print(matriz[x][y] + " ");
			}
			System.out.println();
		}
	}
	
	private static int[][] transformar(int[][] matriz) {
		int[][] aux = new int[matriz[0].length][matriz.length];
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				aux[y][x] = matriz[x][y];
			}
		}
		return aux;
	}
}

