package ejerciciosJavaIO_NIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio_11 {
	private static final Path PATH = Paths.get( "src/ejerciciosJavaIO_NIO/archivos/Alumnos_Ej11.txt");
	private static final Path PATHCURSOS = Paths.get( "src/ejerciciosJavaIO_NIO/archivos/Cursos_Ej11");
	
	public static void main(String[] args) {
		Pattern p1 = Pattern.compile("([A-Z][a-z]{2,})(?:\\s)");
		Pattern p = Pattern.compile("^([A-Z][a-z]{2,}(?:\\s)){3}([1-4]º)");
		try {
			if(Files.exists(PATH) && Files.size(PATH) != 0) {
				try(BufferedReader reader = new BufferedReader(new FileReader(PATH.toString()))) { 
					boolean archivoValido =true;
					String linea;
					
					do {
						linea = reader.readLine();
						Matcher mGroup = p1.matcher(linea);
						Matcher m = p.matcher(linea);
						if(m.matches()) {
							ArrayList<String> list= new ArrayList<>();
							while(mGroup.find()) {
								list.add(mGroup.group(1));
							}

							Path cursos = Paths.get(PATHCURSOS.toString(),m.group(2));
							
							String s =list.get(1) + list.get(2) + list.get(0);
							Path alumno = Paths.get(cursos.toString(), s);
								
							Files.createDirectories(cursos);
							Files.createDirectories(alumno);
							
						}else {
							archivoValido = false;
						}
							
						
					}while(linea != null && archivoValido);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("El archivo no existe en esa dirección.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
