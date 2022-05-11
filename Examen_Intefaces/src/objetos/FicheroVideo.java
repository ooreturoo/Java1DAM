package objetos;

import java.time.LocalDate;

import interfaces.Reproducible;

public class FicheroVideo extends FicheroBinario implements Reproducible{

	private int duracionSegundos;
	
	public FicheroVideo(String nombre, LocalDate fechaCreacion, int dimensionesContenido,
			int duracionSegundos) {
		
		super(nombre,  fechaCreacion, dimensionesContenido);
		
		this.duracionSegundos = duracionSegundos;
		
	}
	
	public FicheroVideo(String nombre, int duracionSegundos, int dimensionesContenido) {
		super(nombre, dimensionesContenido);
		
		this.duracionSegundos = duracionSegundos;
		
	}

	public int getDuracionSegundos() {
		return duracionSegundos;
	}

	public void setDuracionSegundos(int duracionSegundos) {
		this.duracionSegundos = duracionSegundos;
	}

	@Override
	public void reproducir() {

		System.out.println("Reproduciendo " + getNombre());
		
	}
	
	

	
	
	
}
