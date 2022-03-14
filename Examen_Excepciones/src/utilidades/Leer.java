package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {

	//Constante encargada de guardar el texto que se enviará si el número introducido no es válido.
	private static final String NUMERO_INVALIDO = "El dato introducido no está comprendido entre los valores válidos.";
	
	//Constante encargada de guardar el texto que se enviará si el tipo introducido no es un número.
	private static final String ERROR_TIPO_NUM = "El valor introducido no es un número.";
	
	private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
	/**
	 * Obtiene un número introducido por el usuario por consola comprendido entre los valores
	 * obtenidos por parámetros.
	 * @param texto Recibe el texto a mostrar al usuario antes de que introduzca el número.
	 * @return
	 */
	public static int lecturaInt(String texto) {
		boolean numeroValido = false;
		int numero = 0;
		while(!numeroValido) {
			System.out.println(texto);
			try {
				numero = Integer.parseInt(READER.readLine());
				numeroValido = true;
			} catch (NumberFormatException e) {
				
				System.out.println(ERROR_TIPO_NUM + "\n");
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		return numero;
		
	}
	
	public static int lecturaInt(String texto, int numMin, int numMax) {
		boolean numeroValido = false;
		int numero = 0;
		while(!numeroValido) {
			System.out.println(texto);
			try {
				numero = Integer.parseInt(READER.readLine());
				if(numMin <= numero && numMax > numero) {
					numeroValido = true;
				}else {
					System.out.println(NUMERO_INVALIDO + "\n");
				}
			} catch (NumberFormatException e) {
				System.out.println(ERROR_TIPO_NUM + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return numero;
		
	}


	public static String lecturaString(String texto) {
		System.out.println(texto);
		String textoIntroducido = null;
		try {
			textoIntroducido = READER.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return textoIntroducido;
	}
	
	
}
