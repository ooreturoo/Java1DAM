package ejerciciosMatrices;

public class Ejercicio7 {
	public static void main(String[] args) {
		int[][] matriz1 = {{4,65,-6,3,7},{34,6,22,45,6}};
		int[][] matriz2 = {{4,65,-6,3,7},{34,6,22,45,6}};
		boolean sonIguales = sonIguales(matriz1, matriz2);
		System.out.println(sonIguales);

	}
	
	private static boolean sonIguales(int[][] matriz1, int[][] matriz2) {
		boolean iguales = true;
		if(matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length) {
			for(int x = 0; x < matriz1.length && iguales; x++) {
				for(int y = 0; y < matriz1[0].length && iguales; y++) {
					if(matriz1[x][y] != matriz2[x][y]) {
						iguales = false;
					}
				}
			}
		}else {
			iguales = false;
		}
		
		return iguales;
		
		
	}
}
