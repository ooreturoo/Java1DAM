package ejercicios3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio7_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int mayor, menor, resto;
		int mcd = 0;
		int num1 = 0;
		int num2 = 0;
		boolean primo = false;
		boolean validador = true;
		
		do {
			try {
				System.out.println("Introduce un número mayor que 0: ");
				num1 = Integer.parseInt(reader.readLine());
				if(num1 > 0) {
					do {
						
						System.out.println("Introduce un segundo número mayor que 0: ");
						num2 = Integer.parseInt(reader.readLine());
						
						if(num2 > 0) {
							validador = false;
						}else {
							System.out.println("Has introducido un número igual o menor a 0");
						}	
						
					}while(validador);
					
				}else {
					System.out.println("Has introducido un número igual o menor a 0");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un número");
			}
			
		}while(validador);
		
		
		if(num1>num2) {
			mayor = num1;
			menor = num2;
		}else {
			mayor = num2;
			menor = num1;
		}
		
		do {
			resto = mayor % menor;
			if(resto == 1) {
				primo = true;
			}else if(resto == 0){
				mcd = menor;
			}
			else {
				mayor = menor;
				menor = resto;
			}
			
			
		}while(resto != 0 && primo == false);
		
		if(primo) {
			System.out.println("No tienen mcd");
		}else {
			System.out.println("El mcd es: " + mcd);	
		}
		
		reader.close();
		
	}
}
