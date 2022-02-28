package ejercicios2;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio9_2 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int suma = 0;
		int num = 0;
		do {
			try {
				System.out.println("Introduce un número positivo para averiguar si es perfecto:");
				num = Integer.parseInt(reader.readLine());
				if(num > 0) {					
					break;
				}else {
					System.out.println("Número no válido");
				}
			} catch (Exception e) {
				System.out.println("Lo que has introducido no es un número");
			}
			
		}while(true);
		
		for(int i = 1; i <= num/2; i++) {
			if(num % i == 0) {
				suma += i;
			}
		}
		
		if(suma == num) {
			System.out.println(num + " es un número perfecto");
		}else {
			System.out.println(num + " no es un número perfecto");
		}
		
	
	}
}
