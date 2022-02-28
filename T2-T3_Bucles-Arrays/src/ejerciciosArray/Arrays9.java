package ejerciciosArray;

public class Arrays9 {
	public static void ordenarArray(int[] elementos, boolean reverse) {
		for(int i = 0; i < elementos. length; i++) {
			for(int j = 0; j < elementos.length-1 -i; j++) {
				if(reverse) {
					if(elementos[j] < elementos[j+1]) {
						int aux = elementos[j];
						elementos[j] = elementos[j+1];
						elementos[j+1] = aux;
					}
				}else {
					if(elementos[j] > elementos[j+1]) {
						int aux = elementos[j];
						elementos[j] = elementos[j+1];
						elementos[j+1] = aux;
					}
				}
			}
		}
		
			
	}
	
	public static void main(String[] args) {
		int[] numeros = {6, 34, 78, 3, 95, 57};
		ordenarArray(numeros, true);
		
		for(int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
	}
}
