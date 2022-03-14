package menu;

import Leer.Leer;
import bibliotecaypelicula.Biblioteca;
import bibliotecaypelicula.Pelicula;
import excepciones.FechaEstrenoException;

public class FuncionesBiblioteca {
	
	private FuncionesBiblioteca() {}
	
	
	public static boolean funcionamientoMenu(Biblioteca biblioteca) {
		
		int indice = Leer.lecturaInt("Introduce el indice al que acceder", 0,7);
		
		boolean salirMenu = false;
		
		switch(indice){
		case 1:
			añadirPelicula(biblioteca);
			break;
		case 2:
			consultarBiblioteca(biblioteca);
			break;
		case 3:
			buscarPorEtiqueta(biblioteca);			
			break;
		case 4:
			buscarPorTitulo(biblioteca);
			break;
		case 5:
			buscarPorPresupuestoMaximo(biblioteca);
			break;
		case 6: 
			salirMenu = true;
			break;
		}
		
		return salirMenu;
		
	}
	

	private static void añadirPelicula(Biblioteca biblioteca) {
		
		int indice = comprobarCapacidadBiblioteca(biblioteca);
		
		if(indice == -1) {
			System.out.println("La biblioteca se encuentra llena, no se pueden añadir más películas.");
		}else {
			
			Pelicula nuevaPelicula = new Pelicula();
			
			nuevaPelicula.setTitulo(Leer.lecturaString("Introduce el título de la película."));
			
			while(nuevaPelicula.getEstreno() == 0) {
				
				try {
					
					nuevaPelicula.setEstreno(Leer.lecturaInt("Introduce el año de estreno de la película."));
					
				} catch (FechaEstrenoException e) {
					
					System.out.println(e.getMessage());
					
				}
				
			}
			
			nuevaPelicula.setDirector(Leer.lecturaString("Introduce el nombre del director."));
			
			nuevaPelicula.setPresupuesto(Leer.lecturaDouble("Introduce el presupuesto de la película."));
			
			nuevaPelicula.setRecaudacion(Leer.lecturaDouble("Introduce la recaudación de la película."));
			
			nuevaPelicula.setSinopsis(Leer.lecturaString("Introduce la sinopsis de la película."));
			
			nuevaPelicula.setEtiquetas(Leer.lecturaString("Introduce las etiquetas de la película separadas por coma."));
			
			nuevaPelicula.setValoracion(obtenerValoración(nuevaPelicula));
			
			biblioteca.introducirPelicula(indice, nuevaPelicula);
		}
		
		
	}
	
	private static void consultarBiblioteca(Biblioteca biblioteca) {
		
		boolean peliculaEncontrada = false;
		
		for(int i = 0; i < biblioteca.longitud(); i++) {
			
			Pelicula pelicula = biblioteca.obtenerPelicula(i);
			
			if(pelicula != null) {
				
				System.out.println(pelicula);
				peliculaEncontrada = true;
			}
			
		}
		
		if(!peliculaEncontrada) {
			System.out.println("No se encontró ninguna película.");
		}
	}
	
	private static void buscarPorEtiqueta(Biblioteca biblioteca) {
		
		boolean peliculaEncontrada = false;
		
		String etiqueta = Leer.lecturaString("Introduce la etiqueta por la que buscar.");
		
		for(int i = 0; i < biblioteca.longitud(); i++) {
			
			Pelicula pelicula = biblioteca.obtenerPelicula(i);
			
			if(pelicula != null) {
				
				if(pelicula.getEtiquetas().contains(etiqueta)) {
					System.out.println(pelicula);
					peliculaEncontrada = true;
				}
				
			}
			
		}
		
		if(!peliculaEncontrada) {
			System.out.println("No se encontró ninguna película.");
		}
	}
	
	private static void buscarPorTitulo(Biblioteca biblioteca) {
		
		String titulo = Leer.lecturaString("Introduce el título de la película a buscar.");
		
		boolean peliculaEncontrada = false;
		
		for(int i = 0; i < biblioteca.longitud() && !peliculaEncontrada; i++) {
			
			Pelicula pelicula = biblioteca.obtenerPelicula(i);
			
			if(pelicula !=null) {
				if (pelicula.getTitulo().equals(titulo)) {
					peliculaEncontrada = true;
					System.out.println(pelicula);
				}
			}
			
		}
		
		
		if(!peliculaEncontrada) {
			System.out.println("No se encontró ninguna película.");
		}
	}
	
	private static void buscarPorPresupuestoMaximo(Biblioteca biblioteca) {
		
		boolean peliculaEncontrada = false;
		
		double presupuestoMaximo = Leer.lecturaDouble("Introduce el presupuesto máximo que la película a buscar puede tener.");
		
		for(int i = 0; i < biblioteca.longitud(); i++) {
			
			Pelicula pelicula = biblioteca.obtenerPelicula(i);
			
			if(pelicula != null) {
				
				if (pelicula.getPresupuesto() <= presupuestoMaximo) {
					
					System.out.println(pelicula.getTitulo());
					
				}
				
			}
			
		}
		
		if(!peliculaEncontrada) {
			System.out.println("No se encontró ninguna película.");
		}
		
	}
	
	private static int comprobarCapacidadBiblioteca(Biblioteca biblioteca) {
		
		boolean bibliotecaLlena = true;
		int indiceVacio = -1;
		
		for(int i = 0; i < biblioteca.longitud() && bibliotecaLlena; i++) {
			
			if(biblioteca.obtenerPelicula(i) == null) {
				
				bibliotecaLlena = false;
				indiceVacio = i;
				
			}
			
		}
		
		return indiceVacio;
		
	}
	
	private static int obtenerValoración(Pelicula pelicula) {
	
	double presupuesto = pelicula.getPresupuesto();
	double recaudado = pelicula.getRecaudacion();
	
	int valoracion = 0;
	
	if(presupuesto >= recaudado * 2) {
		valoracion = 10;
	}else {
		
		valoracion = (int) ((recaudado / presupuesto) * 5);			
	}
	
		return valoracion;
	}
	
}
