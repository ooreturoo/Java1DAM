package ejerciciosJavaIO_NIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import Leer.Leer;

public class Ejercicio1 {
	
	private static final String PATH = "src/ejerciciosJavaIO_NIO/archivos/Ejercicio1"; 
	
	public static void main(String[] args) {
		boolean salirMenu = false;
		
		while(!salirMenu) {
			imprimirMenu();
			int num = Leer.lecturaInt("Introduce el número de la acción que quieres realizar.", 1,6);
			
			switch(num) {
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
					salirMenu = true;
					break;
			}
		}
		
		
	}
	
	private static void imprimirMenu() {
		System.out.println();
		System.out.println("************Menu************");
		System.out.println("1. Crear directorio.");
		System.out.println("2. Crear fichero de texto.");
		System.out.println("3. Borrar fichero de texto.");
		System.out.println("4. Mostrar los ficheros que contiene una carpeta.");
		System.out.println("5. Salir");
		
	}
	
	private static void crearDirectorio() {
		String nombreDirectorio = Leer.lecturaString("Introduce el nombre para el directorio.");
		Path path = Paths.get(PATH,nombreDirectorio);
		
		if(Files.notExists(path)) {
			try {
				Files.createDirectory(path);
			} catch (IOException e) {
				System.out.println("No se a podido crear el directorio.");
			}
		}else {
			System.out.println("El directorio ya existe.");
		}
	}
	
	private static void crearFichero() {
		String nombreFichero = Leer.lecturaString("Introduce el nombre para el fichero.") + ".txt";
		Path path = Paths.get(PATH,nombreFichero);
		
		if(Files.notExists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException ex) {
				System.out.println("Error, el archivo no se pudo crear.");
			}
			try(BufferedWriter writer = Files.newBufferedWriter(path,StandardOpenOption.WRITE)) {
				String texto = Leer.lecturaString("Introduce el texto con el que rellenar el fichero.");
				writer.write(texto);
				writer.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("El archivo que intentas crear ya existe.");
		}
	}

	private static void borrarFichero() {
		String fichero = Leer.lecturaString("Introduce el archivo que quieres borrar.") + ".txt";
		Path path = Paths.get(PATH, fichero);
		
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				System.err.println("No se ha podido borrar el archivo.");
			}
		}else {
			System.out.println("El archivo no existe.");
		}
	}

	
	private static void mostrarFicheros() {
		Path path = Paths.get(PATH, Leer.lecturaString("Introduce el nombre del directorio del que mostrar los archivos."));
		if(Files.isDirectory(path)) {
			try {
				List<String> archivos = Files.list(path)
								.filter((l) -> !Files.isDirectory(l))
								.map((l) -> l.getFileName().toString())
								.sorted()
								.collect(Collectors.toList());
				
				archivos.forEach(System.out::println);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}else {
			System.out.println("La dirección no corresponde con un directorio.");
		}
		
		
	}

	
}
