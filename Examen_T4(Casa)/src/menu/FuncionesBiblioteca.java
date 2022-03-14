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
			a�adirPelicula(biblioteca);
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
	

	private static void a�adirPelicula(Biblioteca biblioteca) {
		
		int indice = comprobarCapacidadBiblioteca(biblioteca);
		
		if(indice == -1) {
			System.out.println("La biblioteca se encuentra llena, no se pueden a�adir m�s pel�culas.");
		}else {
			
			Pelicula nuevaPelicula = new Pelicula();
			
			nuevaPelicula.setTitulo(Leer.lecturaString("Introduce el t�tulo de la pel�cula."));
			
			while(nuevaPelicula.getEstreno() == 0) {
				
				try {
					
					nuevaPelicula.setEstreno(Leer.lecturaInt("Introduce el a�o de estreno de la pel�cula."));
					
				} catch (FechaEstrenoException e) {
					
					System.out.println(e.getMessage());
					
				}
				
			}
			
			nuevaPelicula.setDirector(Leer.lecturaString("Introduce el nombre del director."));
			
			nuevaPelicula.setPresupuesto(Leer.lecturaDouble("Introduce el presupuesto de la pel�cula."));
			
			nuevaPelicula.setRecaudacion(Leer.lecturaDouble("Introduce la recaudaci�n de la pel�cula."));
			
			nuevaPelicula.setSinopsis(Leer.lecturaString("Introduce la sinopsis de la pel�cula."));
			
			nuevaPelicula.setEtiquetas(Leer.lecturaString("Introduce las etiquetas de la pel�cula separadas por coma."));
			
			nuevaPelicula.setValoracion(obtenerValoraci�n(nuevaPelicula));
			
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
			System.out.println("No se encontr� ninguna pel�cula.");
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
			System.out.println("No se encontr� ninguna pel�cula.");
		}
	}
	
	private static void buscarPorTitulo(Biblioteca biblioteca) {
		
		String titulo = Leer.lecturaString("Introduce el t�tulo de la pel�cula a buscar.");
		
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
			System.out.println("No se encontr� ninguna pel�cula.");
		}
	}
	
	private static void buscarPorPresupuestoMaximo(Biblioteca biblioteca) {
		
		boolean peliculaEncontrada = false;
		
		double presupuestoMaximo = Leer.lecturaDouble("Introduce el presupuesto m�ximo que la pel�cula a buscar puede tener.");
		
		for(int i = 0; i < biblioteca.longitud(); i++) {
			
			Pelicula pelicula = biblioteca.obtenerPelicula(i);
			
			if(pelicula != null) {
				
				if (pelicula.getPresupuesto() <= presupuestoMaximo) {
					
					System.out.println(pelicula.getTitulo());
					
				}
				
			}
			
		}
		
		if(!peliculaEncontrada) {
			System.out.println("No se encontr� ninguna pel�cula.");
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
	
	private static int obtenerValoraci�n(Pelicula pelicula) {
	
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
