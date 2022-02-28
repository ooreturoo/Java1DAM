package ejercicios2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioExtra2 {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x;
		int suma = 1;
		int num1 = 1;
	
		
		do {
			System.out.println("Introduce un número: ");
			x = Integer.parseInt(reader.readLine());
		}while(x <= 0);
		
		for(int i = 1; i < x; i++) {
			int num2 = suma;
			suma += num1;
			num1 = num2;
		}
		
		System.out.println(suma);
	}
}
