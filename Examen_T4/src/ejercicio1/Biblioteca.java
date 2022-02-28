package ejercicio1;

public class Biblioteca {

	private Pelicula[] peliculas;
	
	public Biblioteca(int capacidadBiblioteca) {
		this.peliculas = new Pelicula[capacidadBiblioteca];
	}

	public Pelicula[] getPeliculas() {
		return peliculas;
	}
	
	/**
	 * Accede a la pel�cula situada en la posicion pasada por parametro de la biblioteca. 
	 * @param numPelicula Recibe la posici�n de la pel�cula.
	 * @return
	 */
	public Pelicula accederAPelicula(int numPelicula) {
		
		return peliculas[numPelicula];
		
	}
	
	/**
	 * Introduce una pel�cula situada en la posicion pasada por parametro de la biblioteca. 
	 * @param posicionBiblioteca Recibe la posici�n donde introducir la pelicula.
	 * @param pelicula Recibe la pel�cula a introducir.
	 */
	public void introducirPelicula(int posicionBiblioteca, Pelicula pelicula) {
		
		peliculas[posicionBiblioteca] = pelicula;
		
	}
	
	/**
	 * Obtiene la capacidad de la biblioteca.
	 * @return
	 */
	public int longitud() {
		return peliculas.length;
	}
	
}
