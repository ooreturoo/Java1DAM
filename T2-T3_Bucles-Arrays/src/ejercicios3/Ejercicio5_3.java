package ejercicios3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio5_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduce un número: ");
		int num = Integer.parseInt(reader.readLine());
		boolean primo = true;
		
		for(int i = 2; i <= num/2 && primo; i++) {
			if(num % i == 0) {
				primo = false;
			}
		}
		
		if(primo) {
			System.out.println(num + " es un número primo.");
		}else {
			System.out.println(num + " no es un número primo.");
		}
	}
}
