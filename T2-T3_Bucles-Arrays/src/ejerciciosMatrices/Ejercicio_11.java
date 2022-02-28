package ejerciciosMatrices;

public class Ejercicio_11 {
	public static void main(String[] args) {
		int[][] matriz = {{5,8,9,0},{4,7,5,2},{1,7,3,2}};
		int[][] matriz2 = {{2,3,7,1},{2,5,7,4},{0,9,8,5}};
		boolean inversa = inversa(matriz, matriz2);
		System.out.println(inversa);
	}
	
	private static boolean inversa(int[][] matriz, int[][] matriz2) {
		int xInversa = matriz.length-1;
		int yInversa = matriz[0].length-1;
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				if(matriz[x][y] != matriz2[xInversa][yInversa]) {
					return false;
				}
				yInversa--;
			}
			yInversa = matriz[0].length-1;
			xInversa--;
		}
		
		return true;
	}
}
