package ejerciciosArray;

public class Arrays1 {

	public static void main(String[] args) {
		int[] numeros = { 5, 59, 23, 64, 23, 6, 3, 12};
		int suma = 0;
		
		
		for(int i = 0; i < numeros.length; i++) {
			if(i % 2 == 0) {
				suma += numeros[i];
			}
		}
		
		System.out.println(suma);

	}

}
