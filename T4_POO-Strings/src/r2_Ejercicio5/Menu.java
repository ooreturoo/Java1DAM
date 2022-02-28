package r2_Ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Leer.Leer;


public class Menu {
	public static void main(String[] args) {
		
		char movimiento = ' ';
		boolean menu = true;
		Linea linea = new Linea();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(menu) {
			boolean valorValido = false;
			
			System.out.println("****Menu****");
			System.out.println("A-Mover arriba");
			System.out.println("B-Mover abajo");
			System.out.println("I-Mover izquierda");
			System.out.println("D-Mover derecha");
			System.out.println("M-Mostrar linea");
			System.out.println("S-Salir");
			System.out.println();
			
			
			while(!valorValido) {
				try {
					System.out.println("Introduce el movimiento");
					movimiento = reader.readLine().toUpperCase().charAt(0);
					if(movimiento == 'A' || movimiento == 'B' || movimiento == 'I' || movimiento == 'D' || movimiento == 'M' || movimiento == 'S') {
						valorValido = true;
					}else {
						System.out.println("Movimiento no válido");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			String pedirCoordenada = "Introduce la coordenada para realizar el movimiento.";
			
			switch(movimiento) {
				case 'A':
					linea.moverDerecha(Leer.lecturaDouble(pedirCoordenada));
					break;
				case 'B':
					linea.moverDerecha(Leer.lecturaDouble(pedirCoordenada));
					break;
				case 'I':
					linea.moverDerecha(Leer.lecturaDouble(pedirCoordenada));
					break;
				case 'D':
					linea.moverDerecha(Leer.lecturaDouble(pedirCoordenada));
					break;
				case 'M':
					System.out.println(linea);
					break;
				case 'S':
					menu = false;
					System.out.println("¡Hasta la próxima!");
					break;
			}	
		}
	}
	
	
}
