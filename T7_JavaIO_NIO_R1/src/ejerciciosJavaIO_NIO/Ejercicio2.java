package ejerciciosJavaIO_NIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
	public static void main(String[] args) {
		
		//Captura las excepciones y abre el flujo de datos dentro del try, para que una vez acabado el proceso lo cierre.
		try (BufferedReader reader = new BufferedReader(new FileReader("src/ejerciciosJavaIO_NIO/archivos/Ejercicio1Y2.txt"))){
			//Variable en al que se asignara el valor de cada lectura para comprobarse.
			String linea = null;
			StringBuffer bf = new StringBuffer();
			
			//Si en el documento queda información por leer seguira en el bucle. 
			while((linea = reader.readLine()) != null) {
				//Añadimos lo leido al Buffer para luego imprimir por pantalla toda la información recogida del documento.
				bf.append(linea + "\n");
			}
			//Muestra toda la información recogida del documento.
			System.out.println(bf);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
