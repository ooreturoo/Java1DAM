package ejerciciosJavaIO_NIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Leer.Leer;

public class Ejercicio9 {
	
	private static final String PATH = "src/ejerciciosJavaIO_NIO/archivos/"; //Establece la direccion de un directorio por defecto.

	public static void main(String[] args) {
		Path path = Paths.get(PATH + Leer.lecturaString("Introduce la dirección del archivo."));
		String exRegular = "^[a-zA-Z]{2,}\\s{1}";
		
		if(Files.exists(path)) {
			
			try(BufferedReader readerCoches = new BufferedReader(new FileReader(path.toString()));
				BufferedReader readerMatriculas = new BufferedReader(new FileReader(PATH.toString() + "MatriculasCorrectas_Ej9.txt"))) {
				String linea;
				String matriculas = "";
				do {
					boolean matriculaValida = false;
					linea = readerCoches.readLine();
					while(linea != null && matriculas != null && !matriculaValida) {
						
						matriculas = readerMatriculas.readLine();
						
						if(linea.matches(exRegular + matriculas)) {
							matriculaValida = true;
						}
					}
					
					if(linea != null) {
						if(matriculaValida) {
							System.out.println("El coche " + linea + " tiene una matrícula correcta.");
						}else {
							System.out.println("El coche " + linea + " tiene una matrícula erronea.");
						}
					}
					
					
				}while(linea != null);
			} catch (IOException e) {
				System.out.println("Error" + e);
			}
			
		}else {
			System.out.println("El archivo no existe en esa dirección.");
		}
	}
}
