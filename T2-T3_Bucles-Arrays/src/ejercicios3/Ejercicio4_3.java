package ejercicios3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4_3 {

	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numAleatorio = (int) Math.round(Math.random()*100+1);
		int numIntroducido;
		int cont = 1;
		
		do {
			System.out.println("Introduce un número del 1-100");
			numIntroducido = Integer.parseInt(reader.readLine());
			if(numIntroducido > numAleatorio){
				System.out.println("El número introducido es mayor");
			}else if(numIntroducido < numAleatorio) {
				System.out.println("El número introducido es menor");
			}
			cont++;
		}while(cont <= 5 && numIntroducido != numAleatorio);
		
		
		if(numIntroducido != numAleatorio){
			System.out.println("\nHas perdido, el número aleatorio era: " + numAleatorio);
		}else {
			System.out.println("\n¡Has acertado el número!");
		}
		
	}

}
