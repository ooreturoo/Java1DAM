package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4_Extra {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int hora = 0;
		int minutos = 0;
		int segundos = 0;
		int sumaHoras = 0;
		int sumaMinutos = 0;
		int sumaSegundos = 0;
		int aux = 0;
		int dias = 0;
		boolean interruptor = true;
		
		//Comenzamos introduciendo los valores y comprobando que se introduzcan números y que sea una hora válida.
		
		do {
			
			try {
				
				do {
					System.out.println("Introduce la hora base: ");
					hora = Integer.parseInt(reader.readLine());
					
					if(hora < 0 || hora > 23) {
						System.out.println("Hora introducida invalida");
					}
				}while(hora < 0 || hora > 23);
				
				do {
					System.out.println("Introduce los minutos base: ");
					minutos = Integer.parseInt(reader.readLine());
					
					if(minutos < 0 || minutos > 60) {
						System.out.println("Minutos introducidos invalidos");
					}
				} while (minutos < 0 || minutos > 60);
				
				do {
					System.out.println("Introduce los segundos base: ");
					segundos = Integer.parseInt(reader.readLine());
					
					if(segundos < 0 || segundos > 60) {
						System.out.println("Minutos introducidos invalidos");
					}else {
						interruptor = false;
					}
				} while (segundos < 0 || segundos > 60);
				
			}catch(NumberFormatException e) {
				
				System.out.println("No has introducido un valor válido");
				
			}
			
		}while(interruptor);
		
		//Devolvemos el valor al interruptor por defecto, para que se quede en el siguiente bucle si no se introducen los datos.
		interruptor = true;
		
		//Obtenemos los días, horas y segundos que el usuario quiere sumar.
	do {
			
			try {
				System.out.println("¿Cuantas horas quieres sumar?");
				sumaHoras = Integer.parseInt(reader.readLine());
				
				System.out.println("¿Cuantos minutos quieres sumar?");
				sumaMinutos = Integer.parseInt(reader.readLine());
				
				System.out.println("¿Cuantos segundos quieres sumar?");
				sumaSegundos = Integer.parseInt(reader.readLine());
				
				interruptor = false;
				
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un valor válido");
			}
			
		} while (interruptor);
		
		/*
		 * Empezamos calculando los segundos. Primero sumamos los segundos que el usuario quería sumar a los introducidos en la hora completa.
		 * Creamos un bucle para que mientras los segundos sean 60 o superiores, se repitan una serie de operaciones en las que los dividimos entre 60, guardamos el resultado
		 * y luego hacemos el resto y lo guardamos sumando el resultado anterior para obtener todos los segundos. En el caso que el bucle se vaya repitiendo, querra decir que
		 * hay más de 59 segundos, por lo tanto cada repetición sera un minuto que se sume al calculo de minutos.
		 * Una vez ajustados los segundos al rango adecuado, salimos del bucle.
		 * 
		 * Realizamos el mismo proceso para los minutos y las horas.
		 */
		segundos += sumaSegundos;
		while (segundos > 59) {
			aux = segundos / 60;
			aux += segundos % 60;
			segundos = aux;
			sumaMinutos++;
		}
		
		
		minutos += sumaMinutos;
		while (minutos > 59) {
			aux = minutos / 60;
			aux += minutos % 60;
			minutos = aux;
			sumaHoras++;
		}
		
		
		
		hora += sumaHoras;
		
		while(hora > 23){
			aux = hora / 24;
			aux += hora % 24;
			hora = aux;
			dias++;
		}
		
		//Imprimimos el resultado.
		
		
		System.out.printf("Han pasado %d dia(s), y la hora es %02d:%02d:%02d ", dias, hora, minutos, segundos);
		
	}
}
