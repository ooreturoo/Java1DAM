package ejerciciosJavaIO_NIO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ejercicio4 {
	public static void main(String[] args) {
		//Guarda la dirección relativa que se le asigna.
		Path path = Paths.get("src/ejerciciosJavaIO_NIO/archivos/salidaEj3NIO.txt");
		
		/*
		 * Captura las excepciones y abre el flujo de datos dentro del try, para que una vez acabado el proceso lo cierre.
		 * Crea una variable para leer lo introducido por consola.
		 */
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			//Comprueba si el archivo indicado anteriormente en el directorio existe. Si no es así lo crea.
			if(Files.notExists(path)) {
				Files.createFile(path);				
			}
			
			String textoIntroducido = null;
			
			do {
				System.out.println("Introduce el texto para el documento. Escribe fin para terminar");
				//Guarda el texto introducido por consola.
				textoIntroducido = reader.readLine();
				//Comprueba que el texto introducido no es la palabra fin, puesto que esta serviría para salir del búcle y terminar de escribir.
				if(!textoIntroducido.equals("fin")) {
					////Escribe la información en el documento, sobreescribiendola si ya tiene.
					Files.writeString(path,textoIntroducido, StandardOpenOption.APPEND);
				}
			}while(!textoIntroducido.equals("fin"));
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
