package ejerciciosJavaIO_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

import Leer.Leer;

public class Ejercicio6 {
	public static void main(String[] args) {
		mostrarArchivosDir(Leer.lecturaString("Introduce la dirección de la que quieras obtener los archivos que contiene."));
		Leer.cerrarFlujo();
	}
	
	private static final String PATH = "src/ejerciciosJavaIO_NIO/archivos/"; //Establece la direccion de un directorio por defecto.
	
	
	/**
	 * Muestra los archivos y su tamaño.
	 * @param directorio recibe el resto del directorio donde se encuentran los archivos.
	 */
	private static void mostrarArchivosDir(String restoDirectorio) {
		Path path = Paths.get(PATH + restoDirectorio);//Junta el directorio por defecto con la obtenida por parámetro.
		
		//Comprueba si la dirección introducida es un directorio.
		if(Files.isDirectory(path)) { 
			try {
				
				// Guarda mapa el cual contiene el nombre y el tamaño del archivo.
				Map<Path, String> mapa =Files.list(path)
											.collect(Collectors.toConcurrentMap(Path::getFileName, (l)-> {//Recollecta el nombre y el tamaño.
												if(Files.isDirectory(l)) {//Si es un directorio, no guarda el tamaño, si no una cadena.
													return "Directorio";
												}else {
													try {
														return Long.toString( Files.size(l));//Guarda el tamaño como un string.
													} catch (IOException e) {
														e.printStackTrace();
													}
													return "No se a podido obtener el tamaño";
												}
												

											}));
				mapa.entrySet().forEach(System.out::println);//Convierte el map en un set y lo imprime.
											
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}else {
			System.out.println("El directorio no existe.");
		}
	}
}
