package ejercicios3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cont = 0;
		System.out.println("Introduce un n�mero: ");
		int num = Integer.parseInt(reader.readLine());
		do {
			num = num/10;
			cont++;
			
		}while(num!=0);
//		System.out.println("Introduce un n�mero: ");
//		String num = reader.readLine();
//		
//		System.out.println("El n�mero tiene " + num.length() + " cifras");
		
		System.out.println("El n�mero tiene " + cont + " cifras");
		
		
		reader.close();

	}

}
