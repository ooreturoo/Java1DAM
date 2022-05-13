package ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		File file = new File("src/resources/ejercicio3.txt");
		PrintWriter writer = new PrintWriter(new FileWriter(file,true));
		
		String textoIntroducido = "";
		
		while(!(textoIntroducido =reader.readLine() ).equals("fin")) {
			
			writer.write(textoIntroducido);
			
		}
		
		writer.close();
		reader.close();
		
	}
	
}
