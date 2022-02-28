package ejercicios3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio6_3 {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int alumnosC = 0;
		boolean validador = true;
		
		do {
			try {
				System.out.println("Introduce la cantidad de alumnos en al clase.");
				alumnosC = Integer.parseInt(reader.readLine());
				if(alumnosC > 0){
					validador = false;					
				}else {
					System.out.println("Número de alumnos no válido.");
				}
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un número");
			}
		} while (validador);
		
		validador = true;
		
		
		double notaIntroducida = 1;
		int suspensos = 0;
		
		for(int i = 1; i <= alumnosC; i++) {
				do {
					try {
						System.out.println("Introduce la nota del alumno nº " + i);
						notaIntroducida = Double.parseDouble(reader.readLine());
						if(notaIntroducida >=0 || notaIntroducida <= 10){
							validador = false;
						}else {
							System.out.println("Nota introducida no valida.");
						}
					} catch (NumberFormatException e) {
						System.out.println("No has introducido un número");
					}
				} while (validador);
				if(notaIntroducida >= 0 && notaIntroducida < 5)
					suspensos++;
			
		}
		
		
		System.out.printf("El número de suspensos es de %d alumnos, un %.2f%%\n", suspensos, (double) suspensos/alumnosC * 100);
		System.out.printf("El número de aprobados es de %d alumnos, un %.2f%%", (alumnosC - suspensos), (double) (alumnosC-suspensos)/alumnosC * 100);
		

	}

}
