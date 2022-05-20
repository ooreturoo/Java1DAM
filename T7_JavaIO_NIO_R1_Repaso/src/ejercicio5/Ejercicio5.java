package ejercicio5;



import java.io.File;
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
	
	private static final String PATH = "src/resources/"; //Establece la direccion de un directorio por defecto.
	
	/**
	 * Metodo que crea un directorio en una direccion elegida por el usuario.
	 */
	private static void crearDirectorio() {
		
		String nombreDirectorio = Leer.lecturaString("Introduce el nombre del directorio a crear.");
		
		File file = new File(PATH + nombreDirectorio);
		
		if(file.exists()) {
			
			System.out.println("Ya existe.");
			
		}else {
			
			boolean creado = file.mkdir();
			
			if(creado) {
				
				System.out.println("Creado con exito.");
				
			}else {
				
				System.out.println("No se pudo crear el directorio.");
				
			}
		
		}
		
	}
	
	/**
	 * Metodo que crea un fichero con extension .txt en la direccion y con el nombre introducido por el usuario.
	 */
	private static void crearFichero() {
		
		String fichero = Leer.lecturaString("Introduce nombre fichero. (txt por defecto)");
		
		boolean tieneExtension = fichero.matches("^.*(\\.){1}([a-z]){3,}");
		
		if(!tieneExtension) {
			
			fichero = fichero.concat(".txt");
			
		}
		
		File file = new File(PATH + fichero);
		
		try {
			
			boolean creado = file.createNewFile();
			
			if(creado) {
				
				System.out.println("Creado");
				
			}else {
				
				System.out.println("Ya existe.");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al crear.");
		}
		
	}
	
	/**
	 * Metodo que se encarga de eliminar un fichero de texto. Si no existe avisa al usuario.
	 */
	private static void borrarFichero() {
		
		String fichero = Leer.lecturaString("Escribe el nombre del archivo");
		
		boolean tieneExtension = fichero.matches("^.*(\\.){1}([a-z]){3,}");
		
		if(!tieneExtension) {
			
			fichero = fichero.concat(".txt");
			
		}
		
		File file = new File(PATH + fichero);
		
		if(file.exists()) {
			
			if(file.delete()) {
				
				System.out.println("El archivo se eliminó con exito.");
				
			}else {
				
				System.out.println("No se pudo eliminar el archivo.");
			}
			
		}else {
			
			System.out.println("El archivo no existe.");
			
		}
		
		
	}
	
	/**
	 * Metodo que muestra solo los ficheros que contiene el directorio que introduce el usuario.
	 */
	private static void mostrarFicheros() {
		
	}
}
