package ejercicio1;

import java.util.Scanner;

public class AccionesBiblioteca {

	private AccionesBiblioteca () {}
	
	private static final Scanner SCAN = new Scanner(System.in);
	
	
	/**
	 * A�ade una pel�cula a la biblioteca.
	 * @param biblioteca
	 */
	public static void a�adirPelicula(Biblioteca biblioteca) {
		
		boolean bibliotecaLlena = true;
		
		//Variable para almacenar la posici�n de la biblioteca que se encuentra vac�a.
		int huecoVacio = 0;
		
		//Recorremos la biblioteca en busca de un hueco vac�o en el que introducir al nueva pel�cula.
		for(int i = 0; i < biblioteca.longitud() && bibliotecaLlena; i++) {
			if(biblioteca.accederAPelicula(i) == null) {
				bibliotecaLlena = false;
				huecoVacio = i;
			}
		}
		
		//Si la biblioteca est� llena no almacenamos nada y avisamos al usuario.
		if(bibliotecaLlena) {
		
			System.out.println("Biblioteca llena, no se puede a�adir ninguna pel�cula.");
			
		}else {
			
			biblioteca.introducirPelicula(huecoVacio, nuevaPelicula());
			
		}
		
	}
	
	/**
	 * M�todo encargado de crear una Pelicula y rellenar sus datos con los datos introducidos por el usuario.
	 * Cada dato a introducir por el usuario se comprobar� que no est� vac�o.
	 * @return
	 */
	private static Pelicula nuevaPelicula() {
		
		Pelicula nuevaPelicula = new Pelicula();
		
		//Variable para salir de los bucles cuando el valor introducido por el usuario es v�lido(Se resetear� su valor antes de cada comprobaci�n).
		boolean campoRelleno = false;
		
		String campo = null;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce el t�tulo de la pel�cula.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setTitulo(campo.toLowerCase());
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce el a�o de estreno de la pel�cula.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setFechaEstreno(Integer.parseInt(campo));
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce el director de la pel�cula.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setDirector(campo.toLowerCase());
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce el presupuesto de la pel�cula.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setPresupuesto(Double.parseDouble(campo));
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce la recaudaci�n de la pel�cula.");
			campo = SCAN.nextLine();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setRecaudacion(Double.parseDouble(campo));;
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce la sinopsis de la pel�cula.");
			campo = lecturaSinopsis().toString();
			
			if(!campo.isEmpty()) {
				nuevaPelicula.setSinopsis(campo);
				campoRelleno = true;
			}
		}
		
		campoRelleno = false;
		
		while(!campoRelleno) {
			
			System.out.println("Introduce las etiquetas de la pel�cula.");
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
	 * M�todo encargado de leer texto introducido por el usuario y crear una sinopsis, permitiendo agregar saltos de linea.
	 * @return
	 */
	public static StringBuilder lecturaSinopsis() {
		//Creamos un StringBuilder donde almacenar todas las l�neas de texto introducidad por el usuario.
		StringBuilder sinopsis = new StringBuilder();
		//Variable para parar el bucle.
		boolean introduccionTexto = true;
		//Variable para comprobar el valor del texto antes de a�adirla al StringBuilder.
		String textoSinopsis = null;
		System.out.println("Introduce la Sinopsis(Intro para cada salto de linea y escribe fin para salir.)");
		while(introduccionTexto) {
			textoSinopsis = SCAN.nextLine();
			/*
			 * Si el texto introducido es fin, se parar� de introducir texto y terminara el b�cle.
			 * Si el texto tiene cualquier otro valor se a�ade al StringBuilder con un salto de l�nea al final.
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
	 * Consulta en la biblioteca todas las pel�culas disponibles imprimiendo todo su conenido.
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
	 * Busca en la biblioteca las pel�culas que tengan la etiqueta introducida por el usuario.
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
			System.out.println("No se ha encontrado ninguna pel�cula con esa etiqueta.");
		}
		
	}
	
	/**
	 * Busca en la biblioteca las pel�culas que tengan el t�tulo introducido por el usuario.
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
			System.out.println("Pel�cula no encontrada.");
		}
	}
	
	/**
	 * Busca en la biblioteca las pel�culas que tengan el presupuesto por debajo del introducido por el usuario.
	 * @param biblioteca
	 */
	public static void buscarPeliculaPresupuestoMax(Biblioteca biblioteca) {
		boolean presupuestoValido = false;
		
		double presupuestoMax = 0;
		
		while(!presupuestoValido) {
			
			System.out.println("Introduce el presupuesto por el que quieras buscar la pel�cula.");
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
			System.out.println("No se ha encontrado ninguna pel�cula con un presupuesto menor al introducido.");
		}
		
		
	}
	
}
