package ejerciciosJavaIO_NIO;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Leer.Leer;

public class Ejercicio5 {
	public static void main(String[] args) {
		boolean bucle = true;
		while(bucle) {//Repite el menú hasta que el usuario quiera salir.
			
			System.out.println("*********Menu*********");
			System.out.println("1.Crear directorio");
			System.out.println("2.Crear fichero de texto");
			System.out.println("3.Borrar fichero de texto");
			System.out.println("4.Mostrar ficheros que tiene una carpeta");
			System.out.println("5.Salir");
			System.out.println();
			
			int nIntroducido = Leer.lecturaInt(0, 6);//Lee la opción elegida por el usuario.
			
			
			switch (nIntroducido) {
			
				case 1:
					crearDirectorio();
					break;
				case 2:
					crearFichero();
					break;
				case 3:
					borrarFichero();
					break;
				case 4:
					mostrarFicheros();
					break;
				case 5:
					Leer.cerrarFlujo();
					bucle = false;
					break;
			
			}
		
		}
	}
	
	private static final String PATH = "src/ejerciciosJavaIO_NIO/archivos/"; //Establece la direccion de un directorio por defecto.
	
	/**
	 * Metodo que crea un directorio en una direccion elegida por el usuario.
	 */
	private static void crearDirectorio() {
		//Pide el nombre para el directorio y lo guarda en la variable.
		String nombreDir = Leer.lecturaString("Introduce el nombre del directorio.");
		Path path = Paths.get(PATH + nombreDir);//Crea la ruta sumando la que establecimos por defecto y la que introduce el usuario.
		
		//Comprueba si el directorio con ese nombre no existe.Si no existe lo creamos, y si existe avisa al usuario.
		if(Files.notExists(path)) {
			
			try {
				Files.createDirectories(path); //Crea el directorio
				System.out.println("Se ha creado el directorio correctamente.");
			} catch (IOException e) {
				System.out.println("No se a podido crear el directorio.");
				e.printStackTrace();
			}
		}else {
			System.out.println("El directorio ya existe.");
			System.out.println();
		}
	}
	
	/**
	 * Metodo que crea un fichero con extension .txt en la direccion y con el nombre introducido por el usuario.
	 */
	private static void crearFichero() {
		
		//Pide el nombre para el fichero y lo guarda en la variable.
		String nombreFichero = Leer.lecturaString("Introduce el nombre del fichero.");
		
		//Crea la ruta sumando la que establecimos por defecto y la que introduce el usuario, y añade la extension.
		Path path = Paths.get(PATH + nombreFichero + ".txt");
		
		//Comprueba si el directorio con ese nombre no existe.Si no existe lo creamos, y si existe avisa al usuario.
		if(Files.notExists(path)) {
			try {
				Files.createFile(path);//Crea el archivo.
				System.out.println("Se ha creado el archivo correctamente.");
			} catch (IOException e) {
				System.out.println("No se a podido crear el archivo.");
				e.printStackTrace();
			}
		}else {
			System.out.println("El archivo ya existe.");
			System.out.println();
		}
	}
	
	/**
	 * Metodo que se encarga de eliminar un fichero de texto. Si no existe avisa al usuario.
	 */
	private static void borrarFichero() {
		//Pide el nombre para el fichero y lo guarda en la variable.
		String nombreFichero = Leer.lecturaString("Introduce la direccion del fichero para borrarlo.");
		//Crea la ruta sumando la que establecimos por defecto y la que introduce el usuario, y añade la extension.
		Path path = Paths.get(PATH + nombreFichero + ".txt");
		
		if(Files.exists(path) ) {//Comprueba si el fichero existe. Si no existe avisa al usuario.
			try {
				Files.delete(path);//Borra el fichero.
				System.out.println("Se ha borrado el archivo correctamente.");
			} catch (IOException e) {
				System.out.println("No se a podido borrar el archivo.");
				e.printStackTrace();
			}
		}else {
			System.out.println("El archivo que quieres borrar no existe.");
			System.out.println();
		}
	}
	
	/**
	 * Metodo que muestra solo los ficheros que contiene el directorio que introduce el usuario.
	 */
	private static void mostrarFicheros() {
		//Pide el nombre para el fichero y lo guarda en la variable.
		String direccion = Leer.lecturaString("Introduce el directorio del que quiera saber los archivos");
		//Crea la ruta sumando la que establecimos por defecto y la que introduce el usuario.
		Path path = Paths.get(PATH + direccion);
		
		//Comprueba si la dirección introducida correspondea un directorio.
		if(Files.isDirectory(path)) {
			try {
				/*
				 * Crea un stream de una lista de los directorios y los ficheros como un path que contiene el directorio
				 *  que se le pasa como parámetro.
				 */
				Files.list(path)
					.filter((l) -> !Files.isDirectory(l))//Filtra la lista obteniendo los archivos que no son un directorio.
					.map((l) -> l.getFileName())//Coge el nombre y la extension de los ficheros.
					.forEach((i) -> System.out.print(i + " "));//Imprime el nombre de cada archivo.
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Directorio no existe.");
			System.out.println();
		}
		
	}
}
