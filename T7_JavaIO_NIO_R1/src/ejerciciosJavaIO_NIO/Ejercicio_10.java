package ejerciciosJavaIO_NIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Ejercicio_10 {
	
	private static final Path PATH = Paths.get( "src/ejerciciosJavaIO_NIO/archivos/Ficheros_Ej10.txt"); //Establece la direccion del archivo.
	private static final Path PATH_NUEVOS_A = Paths.get("src/ejerciciosJavaIO_NIO/archivos/Ficheros_Ej10/");
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^F\\s[a-zA-Z]{3,}\\.[a-zA-Z]{3}");
		
		try {
			if(Files.exists(PATH) && Files.size(PATH) != 0) {
				boolean archivoValido = true;
				String linea;
				try(BufferedReader reader = new BufferedReader(new FileReader(PATH.toString()))) {
					do {
						linea = reader.readLine();
						if(linea != null) {
							if(pattern.matcher(linea).matches()) {
								if(Files.exists(Paths.get(PATH_NUEVOS_A.toString(),linea))) {
									System.out.println("El archivo ya existe.");
								}else {
									Files.createFile(Paths.get(PATH_NUEVOS_A.toString(),linea));
									System.out.println("Archivo creado.");
								}
							}else {
								System.out.println("Nombre en el archivo no válido.");
								archivoValido = false;
							}
						}
					}while(linea != null);
				} catch (IOException e) {
					
				}
				if(archivoValido) {
					System.out.println("El archivo es válido.");
				}else {
					System.out.println("El archivo no es válido.");
				}
			}else if(Files.size(PATH) == 0) {
				System.out.println("El archivo está vacío.");
			}else {
				System.out.println("El archivo no existe en esa dirección.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
