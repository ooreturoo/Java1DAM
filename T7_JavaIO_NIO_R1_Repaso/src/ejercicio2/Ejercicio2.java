package ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("src/resources/ejercicio1.txt"));
		StringBuilder texto = new StringBuilder();
		
		String lineActual = "";
		while ( (lineActual = reader.readLine()) != null) {
			
			texto.append(lineActual).append(" ");
			
		}
		
		reader.close();
		
		System.out.println(texto);
		
	}
	
}
