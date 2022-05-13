package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("./src/resources/ejercicio1.txt"));
		
		int contadorLineas = 0;
		
		while (reader.readLine() != null){
			
			contadorLineas++;
			
		}
		
		reader.close();
		
		System.out.println(contadorLineas);
		
		
	}
	
}
