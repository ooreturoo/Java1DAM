package r2_Ejercicio7;

import Leer.Leer;


public class Principal {
	public static void main(String[] args) {
		boolean accionesJarras = true;
		Jarra jarraA = Jarra.crearJarra('A');
		Jarra jarraB = Jarra.crearJarra('B');

		while (accionesJarras) {

			System.out.println();
			System.out.println("****Menu****");
			System.out.println("1. Llenar jarra.");
			System.out.println("2. Vaciar jarra.");
			System.out.println("3. Volcar jarra.");
			System.out.println("4. Ver estado de las jarras.");
			System.out.println("5. Salir.");

			int numIntroducido = Leer.lecturaInt("\nIntroduce el número de la operación:");

			switch (numIntroducido) {
				case 1: {
					
					char letra = Leer.lecturaString("¿Que jarra desea llenar (A/B)?").toUpperCase().charAt(0);
					if(letra == 'A') {
						jarraA.llenarJarra();
					}else if(letra == 'B') {
						jarraB.llenarJarra();
					}else {
						System.out.println("La jarra que quieres llenar no existe.");
					}
					break;
				}
				case 2: {
					
					char letra = Leer.lecturaString("¿Que jarra desea llenar (A/B)?").toUpperCase().charAt(0);
					if(letra == 'A') {
						jarraA.vaciarJarra();
					}else if(letra == 'B') {
						jarraB.vaciarJarra();
					}else {
						System.out.println("La jarra que quieres vaciar no existe.");
					}
					break;
					
				}
				case 3: {
					
					char letra = Leer.lecturaString("¿Donde quieres volcar el contenido de la otra jarra (A/B)?").toUpperCase().charAt(0);
					if(letra == 'A') {
						jarraA.volcarJarra(jarraB);
					}else if(letra == 'B') {
						jarraB.volcarJarra(jarraA);
					}else {
						System.out.println("La jarra que quieres vaciar no existe.");
					}
					break;
					
				}
				case 4: {
					
					Jarra.estadoJarras(jarraA, jarraB);
					break;
					
				}
				case 5: {
					
					System.out.println("Se han llenado " + Jarra.getLitrosLlenados() + " litros en total.");
					accionesJarras = false;
					
				}
				default: {
					
					System.out.println("Opción no válida");
					break;
					
				}
			}

		}
	}
}
