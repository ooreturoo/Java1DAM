package ejerciciosJavaIO_NIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
	public static void main(String[] args) {
		int contadorLineas = 0;//Contador de las lineas del fichero.
		
		//Captura las excepciones y abre el flujo de datos dentro del try, para que una vez acabado el proceso lo cierre.
		try (BufferedReader reader = new BufferedReader(new FileReader("src/ejerciciosJavaIO_NIO/archivos/Ejercicio1Y2.txt"))) {
			//Comprueba si hay una linea para leer, si la hay suma una al contador.
			while (reader.readLine() != null) {
				contadorLineas++;
			}
			//Muestra la cantidad de lineas por pantalla.
			System.out.printf("El archivo tiene %d lineas", contadorLineas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
