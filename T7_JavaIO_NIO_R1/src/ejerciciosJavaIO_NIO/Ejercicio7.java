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
			System.out.println("3.Listar archivos con cierta extensi�n de un directorio");
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
	 * Muestra los archivos de un directorio y su tama�o.
	 */
	private static void listarDirectorio() {
		
		Path path = Paths.get(PATH + Leer.lecturaString("Introduce el directorio que quieres listar:"));
		
		//Comprueba si la direcci�n introducida correspondea un directorio.
		if(Files.isDirectory(path)) {
			try {
				// Guarda mapa el cual contiene el nombre y el tama�o del archivo.
				Map<Path, String> mapa =Files.list(path)
											.collect(Collectors.toConcurrentMap(Path::getFileName, (l)-> {//Recolecta el nombre y el tama�o.
												if(Files.isDirectory(l)) {//Si es un directorio, no guarda el tama�o, si no una cadena.
													return "Directorio";
												}else {
													try {
														return Long.toString( Files.size(l));//Guarda el tama�o como un string.
													} catch (IOException e) {
														e.printStackTrace();
													}
													return "No se a podido obtener el tama�o";
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
	 * Busca si existen ficheros que tenga el nombre introducido por el usuario y los muestra junto con su tama�o.
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
											.collect(Collectors.toConcurrentMap(Path::getFileName, (l)-> {//Recollecta el nombre y el tama�o.
												try {
													return Files.size(l); //Guarda el tama�o como valor del map.
												} catch (IOException e) {
													e.printStackTrace();
												}
												return null;
											}));
											
				if(mapa.isEmpty()) {//Si el map esta vac�o avisa de que no hay ningun archivo con el nombre introducido.
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
	 * Busca si existe ficheros que tengan la extension introducida por el usuario y los muestra junto con su tama�o.
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
													return Files.size(l);//Guarda el tama�o como valor del map.
												} catch (IOException e) {
													e.printStackTrace();
												}
												return null;
											}));
				if(mapa.isEmpty()) {//Si el map esta vac�o avisa de que no hay ningun archivo con el nombre introducido.
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
	 * Busca un archivo en un directorio y muestra la ruta y su tama�o.
	 */
	private static void buscarArchivo() {
		
		Path path = Paths.get(PATH + Leer.lecturaString("Introduce el directorio y el nombre del archivo que quieres buscar:"));
		
		//Comprueba que el archivo existe y que no es un directorio.
		if(!Files.isDirectory(path) && Files.exists(path)) {
			try {
				//Muestra la ruta absoluta y el tama�o del archivo.
				System.out.println("Ruta= " + path.toAbsolutePath() + " Tama�o= " + Files.size(path) +"bytes");
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}else {
			System.out.println("El directorio existe o no tengo permisos para acceder a el.");
		}
		
	}
	
	/**
	 * Busca un archivo con un nombre espec�fico en un directorio y si ese directorio contiene otros directorios, busca ese mismo archivo
	 * en cada directorio. Si lo encuentra muestra su ruta absoluta y su tama�o. 
	 */
	private static void buscarRecursivamente() {
		//Pide la direcci�n del directorio y lo transforma en un objeto File.
		File directorio = new File(PATH + Leer.lecturaString("Introduce el directorio")) ;
		//Pide el nombre del archivo a buscar.
		String nombreArchivo = Leer.lecturaString("Introduce el nombre del archivo que quieres buscar.");
		
		//Si el directorio existe, llamara al m�todo que se encargara de buscar recursivamente.
		if(directorio.isDirectory()) {
			recursivo(directorio, nombreArchivo);
			
		}else {
			System.out.println("El directorio existe o no tengo permisos para acceder a el.");
		}
		
		
	}
	
	/**
	 * M�todo encargado de buscar recursivamente en cada subdirectorio encontrado.
	 * @param directorio Recibe un File del directorio en el que buscar.
	 * @param nombreArchivo Recibe el nombre del archivo que buscar.
	 */
	private static void recursivo(File directorio,String nombreArchivo) {
			//Crea una lista de nombres de todos los archivos y directorios contenidos en el directorio padre(el pasado por par�metros).
			String[] lista = directorio.list();
			//Si la lista est� vac�a, significa que el directorio est� vac�o, por lo tanto se acabar�a la busqueda.
			if(lista != null) {
				//Recorre cada nombre de la lista.
				for(String f : lista) {
					//Crea un path compuesta por la direcci�n padre y a�adiendole la direcci�n del nombre del archivo que va recorriendo.
					Path path = Paths.get(directorio.getAbsolutePath() + "\\" + f);
					
					/*
					 * Si la direcci�n que recorre en este momento, es un directorio, llamar� a este mismo m�todo recursivamente,
					 *  buscando en todos los subdirectorios el archivo.
					 * Si lo que encuentra es un archivo, comparara el nombre introducido, con el nombre del archivo. Si este tiene
					 *  el mismo nombre, imprimira su direcci�n absoluta y el tama�o del archivo.
					 */
					if(Files.isDirectory(path)) {
						recursivo(new File(path.toString()), nombreArchivo);
					}else if(f.matches(nombreArchivo + "\\.{1}.+")){
						try {
							System.out.println(path.toAbsolutePath() + " Tama�o= " + Files.size(path) +"bytes");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
	}
}
