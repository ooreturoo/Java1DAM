package ejercicio1;

import java.util.Scanner;

public class Menu {
	
	private static final Scanner SCAN = new Scanner(System.in);
	
	private static void menu() {
		System.out.println("\n****Men� Peliculas****");
		System.out.println("1. A�adir nueva pel�cula.");
		System.out.println("2. Consultar la biblioteca.");
		System.out.println("3. Buscar pel�culas por etiquetas.");
		System.out.println("4. Buscar pel�culas por t�tulo.");
		System.out.println("5. Buscar pel�culas por presupuesto m�ximo");
		System.out.println("6. Salir");
	}
	
	/**
	 * M�todo encargado de la gesti�n del men� accediento a las funciones dependiendo del n�mero introducido por el usuario.
	 * @param biblioteca
	 */
	public static void funcionamientoMenu(Biblioteca biblioteca) {
		boolean salidaMenu = false;
		
		while(!salidaMenu) {
			
			menu();
			
			System.out.println("\nIntroduce el n�mero de la acci�n a realizar.");
			int indice = Integer.parseInt(SCAN.nextLine());
			
			switch(indice) {
			case 1:
				AccionesBiblioteca.a�adirPelicula(biblioteca);
				break;
			case 2:
				AccionesBiblioteca.consultarBiblioteca(biblioteca);
				break;
			case 3:
				AccionesBiblioteca.buscarPorEtiqueta(biblioteca);
				break;
			case 4:
				AccionesBiblioteca.buscarPorTitulo(biblioteca);
				break;
			case 5:
				AccionesBiblioteca.buscarPeliculaPresupuestoMax(biblioteca);
				break;
			case 6:
				salidaMenu = true;
				SCAN.close();
				break;
			default:
				System.out.println("N�mero introducido no v�lido.");
				break;
			}
			
			
		}
	}
	
}
