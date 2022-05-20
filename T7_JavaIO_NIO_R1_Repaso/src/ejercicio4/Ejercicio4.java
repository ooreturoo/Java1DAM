package ejercicio4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import Leer.Leer;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Path ruta = Paths.get("src/resources/ejercicio4.txt");
		
		
		String introducido = "";
		while(!introducido.equals("fin")) {
			
			introducido = Leer.lecturaString("Introduce texto.(Escribe 'fin' para salir)");
			
			if(!introducido.equals("fin")) {
				
				try {
					
					Files.writeString(ruta, introducido, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}
		
		
	}
	
}
