package clases;

import java.time.LocalDate;

import excepciones.ValorCocheInvalidoException;
import utilidades.Funcionalidades;

public class Coche {
	
	
	private static final LocalDate FECHA_MINIMA = LocalDate.of(2022, 01, 01);
	private static final int KILOMETRAJE_MIN = 10;
	private static final int KILOMETRAJE_MAX = 350000;
	private static final int LONGITUD_MAX_MARCA = 15;

	private String nombrePropietario;
	private String matricula;
	private int kilometros;
	private String marca;
	private LocalDate fechaAparcamiento;
	
	
	public Coche() {}
	


	public String getNombrePropietario() {
		return nombrePropietario;
	}


	public void setNombrePropietario(String nombrePropietario) throws ValorCocheInvalidoException {
		
		if (nombrePropietario.isEmpty()) {
			
			throw new ValorCocheInvalidoException("El coche tiene que tener un nombre de propietario.");
			
		}
		
		this.nombrePropietario = nombrePropietario;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) throws ValorCocheInvalidoException {
		

		Funcionalidades.comprobarMatricula(matricula);
			
		
		this.matricula = matricula;
	}


	public int getKilometros() {
		return kilometros;
	}


	public void setKilometros(int kilometros) throws ValorCocheInvalidoException {
		if(kilometros < KILOMETRAJE_MIN || kilometros > KILOMETRAJE_MAX) {
			
			throw new ValorCocheInvalidoException("Los kilometros del vehículo no son válidos.");
			
		}
		this.kilometros = kilometros;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) throws ValorCocheInvalidoException {
		
		if(marca.isEmpty()) {
			
			throw new ValorCocheInvalidoException("El coche tiene que tener una marca.");
			
		}
		
		if (marca.length() > LONGITUD_MAX_MARCA) {
			
			throw new ValorCocheInvalidoException("El nombre introducido para la marca del coche es demasiado largo.");
			
		}
		
		this.marca = marca;
	}


	public LocalDate getFechaAparcamiento() {
		return fechaAparcamiento;
	}


	public void setFechaAparcamiento(LocalDate fechaAparcamiento) throws ValorCocheInvalidoException {
		
		if(fechaAparcamiento.isBefore(FECHA_MINIMA)) {
			
			throw new ValorCocheInvalidoException("La fecha introducida no puede ser anterior a " + FECHA_MINIMA);
			
		}
		
		this.fechaAparcamiento = fechaAparcamiento;
	}


	@Override
	public String toString() {
		return "Coche [nombrePropietario=" + nombrePropietario + ", matricula=" + matricula + ", kilometros="
				+ kilometros + ", marca=" + marca + ", fechaAparcamiento=" + fechaAparcamiento + "]";
	}
	
	
	
}
