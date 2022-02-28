package ejerciciosMatrices;

public class Ejercicio9 {

	public static void main(String[] args) {
		int[][] matriz = {{1,3,5},{0,2,7},{0,2,7},{1,3,5}};
		boolean simetrica = simetrica(matriz);
		System.out.println(simetrica);
		

	}
	private static boolean simetrica(int[][] matriz) {
		int xContraria = matriz.length-1;
		for(int x = 0; x < matriz.length && x != xContraria; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				if(matriz[x][y] != matriz[xContraria][y]) {
					return false;
				}
			}
			xContraria--;
		}
		return true;
		
	}

}
