package ejerciciosJavaIO_NIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Leer.Leer;

public class Ejercicio2 {
	
	private static final String PATH = "src/ejerciciosJavaIO_NIO/archivos/Ejercicio2";
	
	public static void main(String[] args) {
		Path path = Paths.get(PATH, Leer.lecturaString("Introduce el nombre del fichero.") + ".txt");
		
		if(Files.exists(path)) {
			int totalPalabras = 0;
			try(BufferedReader reader = Files.newBufferedReader(path)){
				totalPalabras = contadorPalabras(reader);
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
			System.out.println("El total de palabras es: " + totalPalabras);
		}else {
			System.err.println("El archivo no existe.");
		}
	}
	
	private static int contadorPalabras(BufferedReader reader) throws IOException {
		Pattern p = Pattern.compile("(?:\\s)*([.\\S]+)(?:\\s)*");
		String palabra = Leer.lecturaString("Introduce la palabra que quieras buscar.");
		int contadorPalabras = 0;
		int fila = 0;
		int columna = 0;
		String linea;
		do {
			linea = reader.readLine();
			
			if(linea != null) {
				Matcher m = p.matcher(linea);
				while(m.find()) {
					columna++;
					buscarPalabra(reader, m,palabra, fila,columna);
					contadorPalabras++;
				}
				columna = 0;
			}
			fila++;
		}while(linea != null);
		return contadorPalabras;
	}
	private static void buscarPalabra(BufferedReader reader, Matcher m,String palabra, int fila, int columna) throws IOException {

		System.out.println(m.group(1));
		if(m.group(1).matches(palabra +"\\.?")) {
			Path pathPalabra = Paths.get(PATH, "BuscandoPalabra" + palabra + ".txt");

			if(Files.notExists(pathPalabra)) {
				Files.createFile(pathPalabra);
			
			}
			BufferedWriter writer = Files.newBufferedWriter(pathPalabra, StandardOpenOption.WRITE);
			writer.write("Fila= " + fila + " Columna= " + columna);
			writer.close();
			
		}
			
		
	}
}
