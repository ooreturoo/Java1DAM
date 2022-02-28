package ejercicios3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2_3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int base,exponente;
		
		do {
			
			System.out.println("Introduce el número base: ");
			base = Integer.parseInt(reader.readLine());
			
			System.out.println("Introduce el exponente: ");
			exponente = Integer.parseInt(reader.readLine());
			
		}while(base < 0 || exponente < 0);
		
		System.out.println(Math.pow(base, exponente));
		reader.close();
	}
}
