package ejerciciosArray;

import Leer.Leer;

public class Arrays_15 {
	public static void main(String[] args) {
		Integer[] primos = new Integer[Leer.lecturaInt("Introduce el número hasta el que quieres averiguar los números primos", 0, true)];
		boolean primo;
		for(int i = 2; i < primos.length; i++) {
			primo = true;
			for(int j = 2; j < i/2 && primo; j++) {
				if(i % j == 0) {
					primo = false;
				}
			}
			if(primo) {
				primos[i] = 0;
			}
			
		}
		System.out.print("Numeros primos: ");
		for(int i = 0; i < primos.length; i++) {
			if (primos[i] != null) {
				System.out.print(i + " ");
			}
		}
	}
}
