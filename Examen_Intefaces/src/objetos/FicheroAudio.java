package objetos;

import java.time.LocalDate;

import interfaces.Reproducible;

public class FicheroAudio extends FicheroBinario implements Reproducible {

	private int duracionSegundos;
	
	/**
	 * Crea una instancia de un Fichero creado anteriormente por lo que recibe su fecha de creación
	 * @param nombre Nombre del fichero.
	 * @param fechaCreacion Fecha de creacion del fichero.
	 * @param dimensionesContenido Tamaño del contenido.
	 * @param duracionSegundos Duracion del audio.
	 */
	public FicheroAudio(String nombre, LocalDate fechaCreacion,
			int dimensionesContenido, int duracionSegundos) {
		
		super(nombre, fechaCreacion, dimensionesContenido);
		
		this.duracionSegundos = duracionSegundos;
		
	}
	
	/**
	 * Crea una instancia de un Fichero.
	 * @param nombre Nombre del fichero.
	 * @param fechaCreacion Fecha de creacion del fichero.
	 * @param duracionSegundos Duracion del audio.
	 * @param dimensionesContenido Tamaño del contenido.
	 */
	public FicheroAudio(String nombre,int duracionSegundos , int dimensionesContenido) {
		
		super(nombre, dimensionesContenido);

		this.duracionSegundos = duracionSegundos;
		
	}
	
	@Override
	public void reproducir() {
		
		System.out.println("Reproduciendo " + getNombre());
		
	}

	public int getDuracionSegundos() {
		return duracionSegundos;
	}

	public void setDuracionSegundos(int duracionSegundos) {
		this.duracionSegundos = duracionSegundos;
	}


}
