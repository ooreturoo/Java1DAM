package foros;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ForoPlus extends ForoBasico {

	
	protected double precioSuscripcion;
	
	public ForoPlus(double precioSuscripcion) {
		
		super();
		this.precioSuscripcion = precioSuscripcion;
		
	}
	
	public ForoPlus(LocalDate fechaCreacion, double precioSuscripcion) {
		super(fechaCreacion);
		this.precioSuscripcion = precioSuscripcion;
		
	}

	public double dineroRecaudado() {
		
		double recaudado = contadorUsuariosRegistrados() * precioSuscripcion;
		
		recaudado *= Math.abs(ChronoUnit.MONTHS.between(fechaCreacion, LocalDate.now()));
		
		return recaudado;
		
	}
	
	private int contadorUsuariosRegistrados() {
		
		int usuariosRegistrados = 0;
		
		for(int i = 0; i < usuarios.length; i++) {
			
			if(usuarios[i] != null) {
				
				usuariosRegistrados++;
				
			}
			
		}
		
		return usuariosRegistrados;
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nPrecioSuscripcion=" + precioSuscripcion +
				"\nDineroRecaudado=" + dineroRecaudado();
	}
	
	
	
	
	
	
}
