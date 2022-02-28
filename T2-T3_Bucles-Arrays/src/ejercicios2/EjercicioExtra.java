package ejercicios2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioExtra {
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num1, num2;
		boolean interruptor = true;
		int cont = 2;
		
		do {
			System.out.println("Introduce el primer número: ");
			num1 = Integer.parseInt(reader.readLine());
			System.out.println("Introduce el segundo número: ");
			num2 = Integer.parseInt(reader.readLine());
			
		} while (num1 < 0 || num2 < 0);
		
		while(interruptor && cont != num1+1){
			if(num1 % cont == 0) {
				if(num2 % cont == 0) {
					interruptor = false;
				}
			}
			cont++;
		}
		
		if(interruptor == false) {
			System.out.println("Los números " + num1 + " y " + num2 + " no son primos entre sí.");
		}else {
			System.out.println("Los números " + num1 + " y " + num2 + " son primos entre sí.");
		}
		
		reader.close();
	}
}
