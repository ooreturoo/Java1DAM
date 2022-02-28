package ejerciciosJavaIO_NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Leer.Leer;

public class Ejercicio3 {
	
	private static final String PATH = "src/ejerciciosJavaIO_NIO/archivos";
	//Repetido en la relación anterior.
	public static void main(String[] args) {
		Path path = Paths.get(PATH, Leer.lecturaString("Introduce el nombre del archivo que comprobar.") + ".txt");
		boolean valido = true;
		if(Files.exists(path)) {
			Pattern p = Pattern.compile("^([a-zA-Z]{2,}(?:\\s)){3}([1-9][0-9]?)");
			try(BufferedReader reader = Files.newBufferedReader(path)){
				String linea;
				do {
					linea = reader.readLine();
					if(linea != null) {
						Matcher m = p.matcher(linea);
						if(!m.matches()) {
							valido = false;
						}
						
					}
				}while(linea != null && valido);
				
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
			if(valido) {
				System.out.println("El archivo es válido.");
			}else {
				System.out.println("La estructura del archivo no es válida.");
			}
		}else {
			System.out.println("El archivo no existe.");
		}
		
		
	}
}
