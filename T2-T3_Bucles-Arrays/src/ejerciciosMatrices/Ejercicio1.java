package ejerciciosMatrices;

public class Ejercicio1 {

	public static void main(String[] args) {
		int[][] matriz = {{4,65,-6,3,7},{34,6,22,45,6}};
		boolean negativo = comprobarNegativo(matriz);
		System.out.println(negativo);

	}
	
	private static boolean comprobarNegativo(int[][] matriz) {
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				if(matriz[x][y] < 0) {
					return true;
				}
			}
		}
		return false;
	}

}
