package objetos;

import java.time.LocalDate;

public abstract class Fichero {

	private String nombre;
	private double dimensiones;
	private LocalDate fechaCreacion;
	
	/**
	 * Crea una instancia de un Fichero creado anteriormente por lo que recibe su fecha de creación
	 * @param nombre Nombre del fichero.
	 * @param fechaCreacion Fecha de creacion del fichero.
	 */
	public Fichero(String nombre, LocalDate fechaCreacion) {
		
		this.nombre = nombre;
		this.dimensiones = calcularDimension();
		this.fechaCreacion = fechaCreacion;
		
	}
	
	/**
	 * Crea una instancia de Fichero.
	 * @param nombre Nombre del fichero.
	 */
	public Fichero(String nombre) {
		
		this.nombre = nombre;
		this.dimensiones = calcularDimension();
		this.fechaCreacion = LocalDate.now();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(double dimensiones) {
		this.dimensiones = dimensiones;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public abstract double calcularDimension();
	
	public final void informacionBasica() {
		
		System.out.println("Nombre: " + nombre);
		System.out.println("Tamaño: " + dimensiones);
		System.out.println("Fecha Creación: " + fechaCreacion);
		
	}
	
}
