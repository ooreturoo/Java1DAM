package ejerciciosArray;

public class Arrays9A {
	public static void main(String[] args) {
		int[] numeros = {6, 34, 78, 3, 95, 57};
		ordenarArray(numeros);
		
		for(int i = 0; i < numeros.length; i++) {
			System.out.printf("%2d ",numeros[i]);
		}
	}
	
	private static void ordenarArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length-1-i; j++) {
				if(array[j] > array[j+1]) {
					int aux = array[j];
					array[j] = array[j+1];
					array[j+1] = aux;
				}
			}
		}
	}
}
