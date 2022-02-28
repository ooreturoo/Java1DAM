package ejerciciosArray;

public class Arrays_17 {
	public static void main(String[] args) {
		int[][] original = new int[5][5];
		int[][] copia;
		
		for(int i = 0; i < original.length; i++) {
			for(int j= 0; j < original[0].length; j++) {
				original[i][j] = (int) (Math.random()*50);
			}
		}
		
		
		//copia = original.clone();
		
		copia = new int[original.length][original[0].length];
		
		for(int i = 0; i < original.length; i++) {
			for(int j= 0; j < original[0].length; j++) {
				copia[i][j] = original[i][j];
			}
		}
		

		for(int i = 0; i < copia.length; i++) {
			for(int j= 0; j < copia[0].length; j++) {
				System.out.print(copia[i][j] + " ");
			}
		}
	}
}
