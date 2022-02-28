package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2_Extra {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int espejo = 0; 
		int resto;
		
		System.out.println("Introduce un número com más de dos cifras");
		int num = Integer.parseInt(reader.readLine());
		int num2 = num;
		while(num > 0) {
			resto = num % 10;
			num /= 10;
			espejo *= 10;
			espejo += resto;
			
		}
		
		
		if(num2 == espejo) {
			System.out.println("El número es capicua");
		}else {
			System.out.println("El número no es capicua");
		}
	

	}

}
