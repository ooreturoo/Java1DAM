package Leer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {
	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	
	public static String lecturaString(String texto){
		System.out.println(texto);
		try {
			return READER.readLine();
		} catch (IOException e) {
			System.err.println(e);
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * @param texto Introduce el texto que quieres mostrar.
	 * @param min Introduce el número(este incluido) a partir del cual por debajo de este la comprobación no será valida.
	 * @param max Introduce el número(este no incluido) a partir del cual por encima de este la comprobación no será valida.
	 * @return Devuelve el numero introducido por el usuario.
	 */
	
	public static int lecturaInt(String texto , int min, int max){
		boolean interruptor = true;
		int num = 0;
		
		while(interruptor){
			try{		
				System.out.println(texto);
				num = Integer.parseInt(READER.readLine());
				interruptor = comprobarMinYMax(min, max, num);	
			}catch (NumberFormatException e) {
				System.out.println("No has introducido un número");
			}catch (IOException e) {
				
			}
		}
		
		
		return num;
		
	}
	
	/**
	 * 
	 * @param min Introduce el número(este incluido) a partir del cual por debajo de este la comprobación no será valida.
	 * @param max Introduce el número(este no incluido) a partir del cual por encima de este la comprobación no será valida.
	 * @return Devuelve el numero introducido por el usuario.
	 */
	public static int lecturaInt(int min, int max){
		boolean interruptor = true;
		int num = 0;
		
		while(interruptor){
			try{		
				num = Integer.parseInt(READER.readLine());
				interruptor = comprobarMinYMax(min, max, num);	
			}catch (NumberFormatException e) {
				System.out.println("No has introducido un número");
			}catch (IOException e) {
				
			}
		}
		
		
		return num;
		
	}
	
	/**
	 * 
	 * @param texto Introduce el texto que quieres mostrar.
	 * @param menorMayor Introduce el número(este incluido) mínimo o máximo segun lo que busques.
	 * @param minMax Dale valor true si quieres comprobar si el número introducido por el usuario tiene que ser mayor
	 * que @param menorMayor. En caso contrario indica False.
	 * @return
	 */
	
	public static int lecturaInt(String texto , int menorMayor, boolean minMax){
		
		boolean interruptor = true;
		int num = 0;
		
		while(interruptor){
			try{
				System.out.println(texto);
				num = Integer.parseInt(READER.readLine());
				interruptor = comprobarMinYMax(minMax, menorMayor, num);	
			}catch (NumberFormatException e) {
				System.out.println("No has introducido un número");
			}catch (IOException e) {
				
			}
		}
		
		
		return num;
		
	}
	
	public static int lecturaInt(String texto){
		boolean interruptor = true;
		int num = 0;
		
		while(interruptor){
			try{
				System.out.println(texto);
				num = Integer.parseInt(READER.readLine());
				interruptor = false;					
				
			}catch (NumberFormatException e) {
				System.out.println("No has introducido un número.");
			}catch (IOException e) {
				
			}
		}
		
		return num;
		
	}
	
	
	
	public static char lecturaChar(String texto) {
		System.out.println(texto);
		char c = ' ';
		
		try {
			c = READER.readLine().charAt(0);
			
			
		} catch (IOException e) {
		}
			
	
		
		return c;
	}
	
	/**
	 * 
	 * @param texto Introduce el texto que quieres mostrar.
	 * @param menorMayor Introduce el número mínimo o máximo(este incluido) segun lo que busques.
	 * @param minMax Dale valor true si quieres comprobar si el número introducido por el usuario tiene que ser mayor
	 * que menorMayor. En caso contrario indica False.
	 * @return Devuelve el número introducido por el usuario.
	 */	

	public static double lecturaDouble(String texto, int menorMayor, boolean minMax) {
		boolean interruptor = true;
		double num = 0;
		while(interruptor) {
			try {
				System.out.println(texto);
				num = Double.parseDouble(READER.readLine());
				interruptor = comprobarMinYMax(minMax, menorMayor, num);
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un número");
			}catch (IOException e) {
				
			}
		}
		
		return num;
		
	}
	
	/**
	 * 
	 * @param texto Introduce el texto que quieres mostrar.
	 * @param min Introduce el número(este incluido) a partir del cual por debajo de este la comprobación no será valida.
	 * @param max Introduce el número(este no incluido) a partir del cual por encima de este la comprobación no será valida.
	 * @return Devuelve el numero introducido por el usuario.
	 */

	public static double lecturaDouble(String texto, int min, int max) {
		boolean interruptor = true;
		double num = 0;
		while(interruptor) {
			try {
				System.out.println(texto);
				num = Double.parseDouble(READER.readLine());
				interruptor = comprobarMinYMax(min, max, num);
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un número");
			}catch (IOException e) {
				
			}
		}
		
		return num;
		
	}
	
	public static double lecturaDouble(String texto) {
		boolean interruptor = true;
		double num = 0;
		while(interruptor) {
			try {
				System.out.println(texto);
				num = Double.parseDouble(READER.readLine());
				interruptor = false;
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un número");
			}catch (IOException e) {
				
			}
		}
		
		return num;
		
	}
	
	public static void cerrarFlujo() {
		try {
			READER.close();
			//System.out.println("\n Se ha cerrado el flujo de datos");
		}catch(IOException e){
			System.out.println("No se ha podido cerrar el flujo de datos.");
			System.err.println(e);
		}
	}
	
	private static boolean comprobarMinYMax(boolean minMax, int menorMayor, double num) {
		if(minMax) {
			if(num >= menorMayor) {
				return false;
			}else {
				System.out.println("El número introducido no es válido");
			}
		}else {
			if(num <= menorMayor) {
				return false;
			}else {
				System.out.println("El número introducido no es válido");
			}
		}
		return true;
	}
	
	private static boolean comprobarMinYMax(int min, int max, double num) {
		if(num < max && min <= num) {
			return false;					
		}else {
			System.out.println("El número introducido no es válido");
		}
		return true;
	}
	
	
}
