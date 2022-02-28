package ejerciciosMatrices;

public class Ejercicio_10 {

	public static void main(String[] args) {
		int[][] matriz = {{1,3,1},{7,2,7},{7,2,7},{1,3,1}};
		boolean simetrica = simetrica(matriz);
		System.out.println(simetrica);
		

	}
	private static boolean simetrica(int[][] matriz) {
		int yContraria = matriz[0].length-1;
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length  && x != yContraria; y++) {
				if(matriz[x][y] != matriz[x][yContraria]) {
					return false;
				}
				yContraria--;
			}
			yContraria = matriz[0].length-1;
		}
		return true;
		
	}

}
