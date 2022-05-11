package objetos;

import java.time.LocalDate;

import enums.Formato;

public class FicheroImagen extends FicheroBinario {

	private Formato formato;
	
	public FicheroImagen(String nombre, LocalDate fechaCreacion, int dimensionesContenido,
			Formato formato) {
		
		super(nombre, fechaCreacion, dimensionesContenido);
		
		this.formato = formato;
		
	}
	
	public FicheroImagen(String nombre, int dimensionesContenido, Formato formato) {
		
		super(nombre, dimensionesContenido);
		
		this.formato = formato;
		
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	

}
