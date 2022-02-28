package ejerciciosArray;

public class Arrays_10A {

	public static void main(String[] args) {
		int[] array = {7, 3, 5, 1, 6, 7, 1, 18, 5, 0, -4};
		int[] valores = obtenerDuplicados(array);
		
		for(int n : valores) {
			System.out.print(n + " ");
		}
	}
	
	public static int[] obtenerDuplicados(int[] valores) {
		int cont = 0;
		int[] aux = new int[valores.length];
		
		for(int i = 0; i < valores.length-1; i++) {
			for(int j = i+1; j < valores.length; j++) {
				if(valores[i]==valores[j]) {
					aux[cont] = valores[j];
					cont++;
				}
			}
		}
		
		int[] valores2 = new int[cont];
		for(int i = 0; i < valores2.length; i++) {
			valores2[i] = aux[i];
		}
		
		return valores2;
		
	}

}
