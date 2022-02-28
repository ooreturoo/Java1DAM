package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3_Extra {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean interruptor = true;
		boolean letrasInvalidas = false;
		int valorLetraAnterior = 0;
		int resultado = 0;
		String romanos;
		
		//Obtenemos el número romano y validamos que no haya ningun caracter equivocado.
		
		do {
			System.out.println("Introduce un número en números romanos: ");
			romanos = reader.readLine();
			for(int i = 0; i < romanos.length() && letrasInvalidas == false; i++) {
				char letra = romanos.charAt(i);
				if(letra != 'M' && letra != 'D' && letra != 'C' && letra != 'L' && letra != 'X' && letra != 'V' && letra != 'I' ) {
					System.out.println("Error al introducir el número romano");
					letrasInvalidas = true;	
				}else {
					interruptor = false;
				}
			}
			
		}while(interruptor);
		
		
		
		/*
		 * Creamos un búcle que vaya desde la última letra hacia la primera, y con un switch guarde el valor de esa letra en la variable valorLetra.
		 * Una vez comprobado el valor, entramos en un if else para que dependiendo del valor de la letra anterior recorrida guardado en la variable valorLetraAnterior,
		 * se sumará o se restara al resultado.
		 * Y como último paso cambiamos el valor de la letra anterior por la letra actual, para que en la siguiente vuelta tengamos el valor de esta como letra anterior.
		 */
		
		for(int i = romanos.length()-1;  i >= 0; i--) {
			int valorLetra = 0;
			switch (romanos.charAt(i)) {
			case 'M':
				valorLetra = 1000;
				break;
			case 'D':
				valorLetra = 500;
				break;
			case 'C':
				valorLetra = 100;
				break;
			case 'L':
				valorLetra = 50;
				break;
			case 'X':
				valorLetra = 10;
				break;
			case 'V':
				valorLetra = 5;
				break;
			case 'I':
				valorLetra = 1;
				break;
			}
			
			if(valorLetraAnterior <= valorLetra) {
				resultado += valorLetra;
			}else {
				resultado -= valorLetra;				
			}
			
			valorLetraAnterior = valorLetra;
			
		}
		
		//Por último imprimimos el resultado.
		
		System.out.println(resultado);
	}
}
