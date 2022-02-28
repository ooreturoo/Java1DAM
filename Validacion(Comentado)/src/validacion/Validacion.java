package validacion;

import java.util.Scanner;

public class Validacion {
	public static void main(String[] args) {
		
    	Scanner scan = new Scanner(System.in);//Creo el objeto Scanner y lo guardo en una variable.
    	
    	int num1 = 0; //Creo e instancio la variable para poder acceder a ella fuera del bloque try-catch.
    	boolean repetir = true; //Creo una variable que servira de condicion para que el while se repita o pare.
    	
    	do { 
    		/*
    		 *Empezamos un bloque do-while para que se repita al menos una vez, aunque funcionaria igual con solo el while, 
    		 *ya que la variable booleane comienza siendo true. 
    		 */
			
    		try { //Intenta completar este bloque, si no puede saltara al catch.
    			
				System.out.println("Introduce un número");
				num1 = Integer.parseInt(scan.nextLine()); //Intenta convertir el texto introducido a un numero entero, si falla salta al catch (scan.nexInt no funcionaria).
				repetir = false; //Si el numero fue correcto, nuestro interruptor cambia a falso y el while termina.
				
			} catch (Exception e) {
				
				System.out.println("Error al introducir el número. Vuelve a introducirlo.");
				
			}
    		
		} while (repetir);//Si repetir es verdadero continua el bucle.Si es falso para.
    
    	scan.close(); //Cerramos scanner.
		System.out.println(num1);

	}
}
