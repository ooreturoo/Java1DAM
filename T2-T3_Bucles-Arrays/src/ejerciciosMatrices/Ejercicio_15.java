package ejerciciosMatrices;

public class Ejercicio_15 {
	public static void main(String[] args) {
		int[][] matriz = {{11,12,13,14},{15,16,17,18},{19,20,21,22}};
		casilla(matriz, 2, 3);
	}
	
	private static void casilla(int[][] matriz, int x, int y) {
		System.out.println("Casilla nº " + (x+1) * (y+1));
		System.out.println("Valor = " + matriz[x][y]);
	}
	
}
