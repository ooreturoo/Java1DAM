package ejercicio1;

import java.util.Scanner;

public class AccionesBiblioteca {

	private AccionesBiblioteca () {}
	
	private static final Scanner SCAN = new Scanner(System.in);
	
	
	/**
	 * Añade una película a la biblioteca.
	 * @param biblioteca
	 */
	public static void añadirPelicula(Biblioteca biblioteca) {
		
		boolean bibliotecaLlena = true;
		
		//Variable para almacenar la posición de la biblioteca que se encuentra vacía.
		int huecoVacio = 0;
		
		//Recorremos la biblioteca en busca de un hueco vacío en el que introducir al nueva película.
		for(int i = 0; i < biblioteca.longitud() && bibliotecaLlena; i++) {
			if(biblioteca.accederAPelicula(i) == null) {
				bibliotecaLlena = false;
				huecoVacio = i;
			}
		}
		
		//Si la biblioteca está llena no almacenamos nada y avisamos al usuario.
		if(bibliotecaLlena) {
		
			System.out.println("Biblioteca llena, no se puede añadir ninguna película.");
			
		}else {
			
			biblioteca.introducirPelicula(huecoVacio, nuevaPelicula());
			
		}
		
	}
	
	/**
	 * Método encargado de crear una Pelicula y rellenar sus datos con los datos introducidos por el usuario.
	 * Cada dato a introducir por el usuario se comprobará que no está vacío.
	 * @return
	 */
	private static Pelicula nuevaPelicula() {
		
		Pelicula nuevaPelicula = new Pelicula();
		
		//Variable para salir de los bucles cuando el valor introducido por el usuario es válido(Se reseteará su valor antes de cada comprobación).
		boolean campoRelleno = false;
		
		String campo = null;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce el título de la película.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setTitulo(campo.toLowerCase());
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce el año de estreno de la película.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setFechaEstreno(Integer.parseInt(campo));
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce el director de la película.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setDirector(campo.toLowerCase());
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce el presupuesto de la película.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setPresupuesto(Double.parseDouble(campo));
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce la recaudación de la película.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setRecaudacion(Double.parseDouble(campo));;
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce la sinopsis de la película.");
			campo = lecturaSinopsis().toString();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setSinopsis(campo);
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce las etiquetas de la película.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setEtiquetas(campo.toLowerCase());
				campoRelleno = true;
			}
		}
		
		Pelicula.obtenerValoracion(nuevaPelicula.getPresupuesto(), nuevaPelicula.getRecaudacion(), nuevaPelicula);
		
		return nuevaPelicula;
	}
	
	
	
	/**
	 * Método encargado de leer texto introducido por el usuario y crear una sinopsis, permitiendo agregar saltos de linea.
	 * @return
	 */
	public static StringBuilder lecturaSinopsis() {
		//Creamos un StringBuilder donde almacenar todas las líneas de texto introducidad por el usuario.
		StringBuilder sinopsis = new StringBuilder();
		//Variable para parar el bucle.
		boolean introduccionTexto = true;
		//Variable para comprobar el valor del texto antes de añadirla al StringBuilder.
		String textoSinopsis = null;
		System.out.println("Introduce la Sinopsis(Intro para cada salto de linea y escribe fin para salir.)");
		while(introduccionTexto) {
			textoSinopsis = SCAN.nextLine();
			/*
			 * Si el texto introducido es fin, se parará de introducir texto y terminara el búcle.
			 * Si el texto tiene cualquier otro valor se añade al StringBuilder con un salto de línea al final.
			 */
			if(textoSinopsis.toLowerCase().equals("fin")) {
				introduccionTexto = false;
			}else {
				sinopsis.append(textoSinopsis);
				sinopsis.append("\n");
			}
		}
		return sinopsis;
	}
	
	/**
	 * Consulta en la biblioteca todas las películas disponibles imprimiendo todo su conenido.
	 * @param biblioteca
	 */
	public static void consultarBiblioteca(Biblioteca biblioteca) {
		
		boolean bibliotecaVacia = true;
		
		for(int i = 0; i < biblioteca.longitud(); i++) {
			if(biblioteca.accederAPelicula(i) != null) {
				bibliotecaVacia = false;
				System.out.println(biblioteca.accederAPelicula(i));
				
			}
		}
		
		if(bibliotecaVacia) {
			System.out.println("No hay ningun elemento en la biblioteca.");
		}
		
		
	}
	
	/**
	 * Busca en la biblioteca las películas que tengan la etiqueta introducida por el usuario.
	 * @param biblioteca
	 */
	public static void buscarPorEtiqueta(Biblioteca biblioteca) {
		
		boolean etiquetaValida = false;
		
		String etiqueta = null;
		
		while(!etiquetaValida) {
			
			System.out.println("Introduce la etiqueta que quieras buscar.");
			etiqueta = SCAN.nextLine().toLowerCase();
			
			if(!etiqueta.isEmpty()) {
				etiquetaValida = true;
			}
		}
		
		boolean peliculaEncontrada = false;
		
		for(int i = 0; i < biblioteca.longitud(); i++) {
			Pelicula pelicula = biblioteca.accederAPelicula(i);
			if(pelicula != null) {
				if(pelicula.getEtiquetas().contains(etiqueta)) {
					peliculaEncontrada = true;
					System.out.println("Pelicula: " + pelicula.getTitulo());
				}
			}
		}
		
		if(!peliculaEncontrada) {
			System.out.println("No se ha encontrado ninguna película con esa etiqueta.");
		}
		
	}
	
	/**
	 * Busca en la biblioteca las películas que tengan el título introducido por el usuario.
	 * @param biblioteca
	 */
	public static void buscarPorTitulo(Biblioteca biblioteca) {
		
		boolean tituloValido = false;
		
		String titulo = null;
		
		while(!tituloValido) {
			
			System.out.println("Introduce el titulo que quieras buscar.");
			titulo = SCAN.nextLine().toLowerCase().trim();
			
			if(!titulo.isEmpty()) {
				tituloValido = true;
			}
		}
		
		Pelicula peliculaObtenida = null;
		
		for(int i = 0; i < biblioteca.longitud() && peliculaObtenida == null; i++) {
			Pelicula pelicula = biblioteca.accederAPelicula(i);
			if(pelicula.getTitulo().equals(titulo)) {
				peliculaObtenida = pelicula;
			}
		}
		
		if(peliculaObtenida != null) {
			System.out.println(peliculaObtenida);
		}else {
			System.out.println("Película no encontrada.");
		}
	}
	
	/**
	 * Busca en la biblioteca las películas que tengan el presupuesto por debajo del introducido por el usuario.
	 * @param biblioteca
	 */
	public static void buscarPeliculaPresupuestoMax(Biblioteca biblioteca) {
		boolean presupuestoValido = false;
		
		double presupuestoMax = 0;
		
		while(!presupuestoValido) {
			
			System.out.println("Introduce el presupuesto por el que quieras buscar la película.");
			presupuestoMax = Integer.parseInt(SCAN.nextLine());
			
			if(presupuestoMax > 0) {
				presupuestoValido = true;
			}
		}
		
		boolean peliculaEncontrada = false;
		
		for(int i = 0; i < biblioteca.longitud(); i++) {
			Pelicula pelicula = biblioteca.accederAPelicula(i);
			if(pelicula != null) {
				if(pelicula.getPresupuesto() < presupuestoMax) {
					peliculaEncontrada = true;
					System.out.println("Pelicula: " + pelicula.getTitulo());
				}
			}
		}
		
		if(!peliculaEncontrada) {
			System.out.println("No se ha encontrado ninguna película con un presupuesto menor al introducido.");
		}
		
		
	}
	
}
