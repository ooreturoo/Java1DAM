package ejerciciosArray;

public class Arrays_12 {
	public static void ordenar(int[] numeros) {
		for(int i = 0; i < numeros. length; i++) {
			for(int j = 0; j < numeros.length-1; j++) {
				if(numeros[j] > numeros[j+1]) {
					int aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] numeros = {32, 34, 65, 4, 33, 97, 70, 2};
		ordenar(numeros);
		for(int num : numeros) {
			System.out.println(num);
		}
	}
}
