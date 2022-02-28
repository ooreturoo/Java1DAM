package ejercicio1;

import java.util.Scanner;

public class Menu {
	
	private static final Scanner SCAN = new Scanner(System.in);
	
	private static void menu() {
		System.out.println("\n****Menú Peliculas****");
		System.out.println("1. Añadir nueva película.");
		System.out.println("2. Consultar la biblioteca.");
		System.out.println("3. Buscar películas por etiquetas.");
		System.out.println("4. Buscar películas por título.");
		System.out.println("5. Buscar películas por presupuesto máximo");
		System.out.println("6. Salir");
	}
	
	/**
	 * Método encargado de la gestión del menú accediento a las funciones dependiendo del número introducido por el usuario.
	 * @param biblioteca
	 */
	public static void funcionamientoMenu(Biblioteca biblioteca) {
		boolean salidaMenu = false;
		
		while(!salidaMenu) {
			
			menu();
			
			System.out.println("\nIntroduce el número de la acción a realizar.");
			int indice = Integer.parseInt(SCAN.nextLine());
			
			switch(indice) {
			case 1:
				AccionesBiblioteca.añadirPelicula(biblioteca);
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
				System.out.println("Número introducido no válido.");
				break;
			}
			
			
		}
	}
	
}
