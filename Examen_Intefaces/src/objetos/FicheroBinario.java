package objetos;

import java.time.LocalDate;

public class FicheroBinario extends Fichero {

	private byte[] contenido;
	
	public FicheroBinario(String nombre, int dimensionContenido) {
		
		super(nombre);
		
		this.contenido = new byte[dimensionContenido];
		
	}
	
	public FicheroBinario(String nombre, LocalDate fechaCreacion, int dimensionContenido) {
		
		super(nombre, fechaCreacion);
		
		this.contenido = new byte[dimensionContenido];
		
	}

	
	public byte[] getContenido() {
		return contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}

	@Override
	public double calcularDimension() {
		
		return contenido.length;
		
	}
	
}
