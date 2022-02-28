package ejerciciosJavaIO_NIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

import Leer.Leer;

public class Ejercicio7 {
	private static final String PATH = "src/ejerciciosJavaIO_NIO/archivos/"; //Establece la direccion de un directorio por defecto.
	public static void main(String[] args) {
		boolean bucle = true;
		while(bucle) {//Repite el menu hasta que el usuario salga.
			
			System.out.println();
			System.out.println("********************MENU********************");
			System.out.println("1.Listar directorio");
			System.out.println("2.Listar directorio y buscar ficheros que comiencen por una palabra");
			System.out.println("3.Listar archivos con cierta extensión de un directorio");
			System.out.println("4.Buscar un archivo en un directorio");
			System.out.println("5.Buscar recursivamente un archivo en un directorio");
			System.out.println("6.Salir");
			
			int nIntroducido = Leer.lecturaInt(0, 6);
			
			
			switch (nIntroducido) {
			
			case 1:
				listarDirectorio();
				break;
			case 2:
				buscarFicheroPorPalabra();
				break;
			case 3:
				buscarFicheroPorExtension();
				break;
			case 4:
				buscarArchivo();
				break;
			case 5: 
				buscarRecursivamente();
			case 6:
				Leer.cerrarFlujo();
				bucle = false;
				break;
			
			}
		}
	}
	
	
	/**
	 * Muestra los archivos de un directorio y su tamaño.
	 */
	private static void listarDirectorio() {
		
		Path path = Paths.get(PATH + Leer.lecturaString("Introduce el directorio que quieres listar:"));
		
		//Comprueba si la dirección introducida correspondea un directorio.
		if(Files.isDirectory(path)) {
			try {
				// Guarda mapa el cual contiene el nombre y el tamaño del archivo.
				Map<Path, String> mapa =Files.list(path)
											.collect(Collectors.toConcurrentMap(Path::getFileName, (l)-> {//Recolecta el nombre y el tamaño.
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
				mapa.entrySet().forEach(System.out::println);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("El directorio existe o no tengo permisos para acceder a el.");
		}
		
	}
	
	/**
	 * Busca si existen ficheros que tenga el nombre introducido por el usuario y los muestra junto con su tamaño.
	 */
	private static void buscarFicheroPorPalabra() {
		Path path = Paths.get(PATH + Leer.lecturaString("Introduce el directorio donde buscar los ficheros:"));
		String comienzoArchivo = Leer.lecturaString("Introduce una palabra por al que comience el fichero:");
		
		if(Files.isDirectory(path)) {	
			try {
				Map<Path, Long> mapa = Files.list(path)
											.filter((l) -> !Files.isDirectory(l))
											/*
											 * Obtiene el nombre de cada elemento del stream, lo pasa a String y lo compara con el nombre
											 *  introducido por el usuario.
											 */
											
											.filter((l) -> l.getFileName().toString().startsWith(comienzoArchivo))
											.collect(Collectors.toConcurrentMap(Path::getFileName, (l)-> {//Recollecta el nombre y el tamaño.
												try {
													return Files.size(l); //Guarda el tamaño como valor del map.
												} catch (IOException e) {
													e.printStackTrace();
												}
												return null;
											}));
											
				if(mapa.isEmpty()) {//Si el map esta vacío avisa de que no hay ningun archivo con el nombre introducido.
					System.out.println("No hay ningun archivo con ese nombre.");
				}else {
					mapa.entrySet().forEach(System.out::println);//Imprime el map como clave=valor.
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("El directorio existe o no tengo permisos para acceder a el.");
		}
		
	}
	
	/**
	 * Busca si existe ficheros que tengan la extension introducida por el usuario y los muestra junto con su tamaño.
	 */
	private static void buscarFicheroPorExtension() {
		
		Path path = Paths.get(PATH + Leer.lecturaString("Introduce el directorio donde buscar los ficheros:"));
		String extension = Leer.lecturaString("Introduce la extension del fichero:");
		
		if(Files.isDirectory(path)) {	
			try {
				Map<Path, Long> mapa =Files.list(path)
											.filter((l) -> !Files.isDirectory(l))
											/*
											 * Obtiene el nombre de cada elemento del stream, lo pasa a String y lo compara con la extension
											 *  introducido por el usuario.
											 */
											.filter((l) -> l.getFileName().toString().endsWith(extension))
											.collect(Collectors.toConcurrentMap(Path::getFileName, (l)-> {
												try {
													return Files.size(l);//Guarda el tamaño como valor del map.
												} catch (IOException e) {
													e.printStackTrace();
												}
												return null;
											}));
				if(mapa.isEmpty()) {//Si el map esta vacío avisa de que no hay ningun archivo con el nombre introducido.
					System.out.println("No hay ningun archivo con ese nombre.");
				}else {
					mapa.entrySet().forEach(System.out::println);//Imprime el map como clave=valor.
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("El directorio existe o no tengo permisos para acceder a el.");
		}
		
	}
	
	/**
	 * Busca un archivo en un directorio y muestra la ruta y su tamaño.
	 */
	private static void buscarArchivo() {
		
		Path path = Paths.get(PATH + Leer.lecturaString("Introduce el directorio y el nombre del archivo que quieres buscar:"));
		
		//Comprueba que el archivo existe y que no es un directorio.
		if(!Files.isDirectory(path) && Files.exists(path)) {
			try {
				//Muestra la ruta absoluta y el tamaño del archivo.
				System.out.println("Ruta= " + path.toAbsolutePath() + " Tamaño= " + Files.size(path) +"bytes");
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}else {
			System.out.println("El directorio existe o no tengo permisos para acceder a el.");
		}
		
	}
	
	/**
	 * Busca un archivo con un nombre específico en un directorio y si ese directorio contiene otros directorios, busca ese mismo archivo
	 * en cada directorio. Si lo encuentra muestra su ruta absoluta y su tamaño. 
	 */
	private static void buscarRecursivamente() {
		//Pide la dirección del directorio y lo transforma en un objeto File.
		File directorio = new File(PATH + Leer.lecturaString("Introduce el directorio")) ;
		//Pide el nombre del archivo a buscar.
		String nombreArchivo = Leer.lecturaString("Introduce el nombre del archivo que quieres buscar.");
		
		//Si el directorio existe, llamara al método que se encargara de buscar recursivamente.
		if(directorio.isDirectory()) {
			recursivo(directorio, nombreArchivo);
			
		}else {
			System.out.println("El directorio existe o no tengo permisos para acceder a el.");
		}
		
		
	}
	
	/**
	 * Método encargado de buscar recursivamente en cada subdirectorio encontrado.
	 * @param directorio Recibe un File del directorio en el que buscar.
	 * @param nombreArchivo Recibe el nombre del archivo que buscar.
	 */
	private static void recursivo(File directorio,String nombreArchivo) {
			//Crea una lista de nombres de todos los archivos y directorios contenidos en el directorio padre(el pasado por parámetros).
			String[] lista = directorio.list();
			//Si la lista está vacía, significa que el directorio está vacío, por lo tanto se acabaría la busqueda.
			if(lista != null) {
				//Recorre cada nombre de la lista.
				for(String f : lista) {
					//Crea un path compuesta por la dirección padre y añadiendole la dirección del nombre del archivo que va recorriendo.
					Path path = Paths.get(directorio.getAbsolutePath() + "\\" + f);
					
					/*
					 * Si la dirección que recorre en este momento, es un directorio, llamará a este mismo método recursivamente,
					 *  buscando en todos los subdirectorios el archivo.
					 * Si lo que encuentra es un archivo, comparara el nombre introducido, con el nombre del archivo. Si este tiene
					 *  el mismo nombre, imprimira su dirección absoluta y el tamaño del archivo.
					 */
					if(Files.isDirectory(path)) {
						recursivo(new File(path.toString()), nombreArchivo);
					}else if(f.matches(nombreArchivo + "\\.{1}.+")){
						try {
							System.out.println(path.toAbsolutePath() + " Tamaño= " + Files.size(path) +"bytes");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
	}
}
