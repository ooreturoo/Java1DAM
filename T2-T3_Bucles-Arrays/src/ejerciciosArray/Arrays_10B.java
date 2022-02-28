package ejerciciosArray;

public class Arrays_10B {

	public static void main(String[] args) {
		int[] array = {7, 3, 5, 1, 6, 7, 1, 18, 5, 0, -4};
		array = capicua(array);
		for(int n : array) {
			System.out.print(n + " ");
		}

	}
	
	private static int[] capicua(int[] array) {
		int[] aux = new int[(array.length*2-1)];
		int cont = 0;
		for(int i = 0; i < aux.length; i++) {
			if(i < array.length-1) {
				aux[i] = array[cont];
				cont++;
			}else {
				aux[i] = array[cont];
				cont--;
			}
		}
		return aux;
	}

}
