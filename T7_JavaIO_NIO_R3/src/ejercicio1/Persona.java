package ejercicio1;

import java.time.LocalDate;

public class Persona {

	private String nombre;
	private int dni;
	private int telefono;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, int dni, int telefono, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDni() {
		return dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
}
