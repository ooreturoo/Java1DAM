package ejerciciosMatrices;

public class Ejercicio_13 {
	public static void main(String[] args) {
		int[][] matriz = {{11,12,13,14},{15,16,17,18},{19,20,21,22},{23,24,25,26}};
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz.length; y++) {
				System.out.print(matriz[x][y] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		matriz = cuadrada(matriz);
		
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz.length; y++) {
				System.out.print(matriz[x][y] + " ");
			}
			System.out.println();
		}
		
	}
	private static int[][] cuadrada(int[][] matriz) {
		boolean cuadrada = true;
		int[][] aux = new int[matriz.length][matriz.length];
		for(int x = 0; x < matriz.length; x++) {
			if(matriz.length != matriz[x].length) {
				cuadrada = false;
			}
		}
		
		int ejeX = matriz.length-1;
		int ejeY = matriz.length-1;
		if(cuadrada) {
			for(int x = 0; x < matriz.length; x++) {
				for(int y = 0; y < matriz.length; y++) {
					aux[x][y] = matriz[ejeY][ejeX];
					ejeY--;
				}
				ejeY = matriz.length-1;
				ejeX--;
			}
			return  aux;
		}else {
			System.out.println("La matriz no es cuadrada.");
			return matriz;
		}
		
	}
}
