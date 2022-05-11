package clases;

import java.util.Objects;

public class Ingrediente implements Comparable<Ingrediente> {

	private String nombre;
	private int cantidad;
	
	public Ingrediente(String nombre, int cantidad) {
		
		this.nombre = nombre;
		this.cantidad = cantidad;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(nombre, other.nombre);
	}


	

	@Override
	public String toString() {
		return nombre + ": " + cantidad + " unidades";
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Ingrediente o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	
	
}
