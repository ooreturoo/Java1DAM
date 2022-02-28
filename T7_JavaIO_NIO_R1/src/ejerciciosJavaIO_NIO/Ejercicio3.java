package ejerciciosJavaIO_NIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * Captura las excepciones y abre el flujo de datos dentro del try, para que una vez acabado el proceso lo cierre.
		 * Crea un documento con el nombre establecido en la dirección elegida, sobreescribiendolo si ya existe o si tiene dentro información.
		 */
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/ejerciciosJavaIO_NIO/archivos/salidaEj3.txt",true)))){
			
			String textoIntroducido = null;
			
			do {
				System.out.println("Introduce el texto para el documento. Escribe fin para terminar");
				//Guarda el texto introducido por consola.
				textoIntroducido = scan.nextLine();
				//Comprueba que el texto introducido no es la palabra fin, puesto que esta serviría para salir del búcle y terminar de escribir.
				if(!textoIntroducido.equals("fin")) {
					pw.write(textoIntroducido);//Escribe la información en el documento.
				}
			}while(!textoIntroducido.equals("fin"));
			
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			scan.close();
		}
	}
}
