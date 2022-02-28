package ejercicios3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio8_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double resultado;
		System.out.println("Introduce el primer coeficiente: ");
		int a = Integer.parseInt(reader.readLine());
		System.out.println("Introduce el siguiente coeficiente: ");
		int b = Integer.parseInt(reader.readLine());
		System.out.println("Introduce el ultimo coeficiente: ");
		int c = Integer.parseInt(reader.readLine());
		
		
		resultado = Math.pow(b, 2) - (4 * a * c);
		
		if(resultado < 0){
			System.out.println("No tiene solución.");
		}else if(resultado == 0) {
			System.out.println("Solo tiene una solución.");
		}else {
			System.out.println("Tiene dos soluciones.");
		}
		
		
	}
}
