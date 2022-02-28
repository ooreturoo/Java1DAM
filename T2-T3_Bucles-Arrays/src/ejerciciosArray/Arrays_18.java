package ejerciciosArray;

public class Arrays_18 {
	
	public static void main(String[] args) {
		int[][] original = new int[5][5];
		int num = 64;
		for(int i = 0; i < original.length; i++) {
			for(int j= 0; j < original[i].length; j++) {
				original[i][j] = num++ ;
			}
		}
		
		int[][] copia = copiarEspejo(original);
		
		imprimir(copia);
	}
	
	public static int[][] copiarEspejo(int[][] array){
		int[][] copia = new int[array.length][array[0].length];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0 ; j < array[0].length; j++) {
				copia[i][j] = array[array.length-1-i][array[0].length-1-j];
			}
			
		}
		
		return copia;
	}
	
	public static void imprimir(int[][] copia) {
		for(int i = 0; i < copia.length; i++) {
			for(int j= 0; j < copia[0].length; j++) {
				System.out.print(copia[i][j] + " ");
			}
			System.out.println();
		}
	}
}
