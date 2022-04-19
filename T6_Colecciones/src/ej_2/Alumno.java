package ej_2;

import java.util.Objects;

public class Alumno {

	private String nombre;
	private String dni;
	
	public Alumno(String nombre, String dni) {
		
		this.nombre = nombre;
		this.dni = dni;
		
	}
	
	@Override
	public String toString() {
		
		return "Nombre: " + this.nombre + " DNI: " + this.dni;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
