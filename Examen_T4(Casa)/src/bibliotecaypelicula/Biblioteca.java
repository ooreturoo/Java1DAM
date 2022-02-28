package bibliotecaypelicula;

public class Biblioteca {

	private Pelicula[] peliculas;
	
	public Biblioteca(int capacidad) {
		this.peliculas = new Pelicula[capacidad];
	}
	
	public Pelicula obtenerPelicula(int indice) {
		return peliculas[indice];
	}
	
	public void introducirPelicula(int indice, Pelicula pelicula) {
		peliculas[indice] = pelicula;
	}
	
	public int longitud() {
		return peliculas.length;
	}
	
}
