package ejerciciosJavaIO_NIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Leer.Leer;

public class Ejercicio8 {
	private static final String PATH = "src/ejerciciosJavaIO_NIO/archivos/"; //Establece la direccion de un directorio por defecto.
	public static void main(String[] args) {
		Path path = Paths.get(PATH + Leer.lecturaString("Introduce la dirección del archivo"));
		String exRegular = "^([A-Z]{1}[a-z]+\\s{1}){3}([1-9][0-9]?)$" ;
		boolean documentoValido = true;
		
		if(Files.exists(path)) {
			try(BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
				String linea;
				do {
					linea = reader.readLine();
					if(linea != null) {
						if(!linea.matches(exRegular)) {
							documentoValido = false;
						}
					}
				}while(linea != null); 
				
			} catch (IOException e) {
				System.out.println("Error");
			}
			
			if(documentoValido) {
				System.out.println("El archivo cumple con la condición.");
			}else {
				System.out.println("El archivo no cumple con la condición.");
			}
		}else {
			System.out.println("El archivo no existe en esa dirección.");
		}
	}
}
