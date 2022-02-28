package ejercicios1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio4 {

	public static void main(String[] args) {
		int edad;
		BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
		
		
		try {
			
			do {
			System.out.println("Introduce una edad");
			edad = Integer.parseInt(reader.readLine());
			}while(edad > 100 || edad < 0);
			
			if(edad >= 0 && edad <= 12) {
				System.out.println("Es un niño");
			}else if(edad >= 13 && edad <= 17) {
				System.out.println("Es un adolescente");
			}else if(edad >= 18 && edad <= 29) {
				System.out.println("Es un adulto");
			}else {
				System.out.println("Es un anciano");
			}
			
		} catch (Exception e) {
			System.out.println("Error al rellenar el campo");
		}
		
		
		
	}

}
