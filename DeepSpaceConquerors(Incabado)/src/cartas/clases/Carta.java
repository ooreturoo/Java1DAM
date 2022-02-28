package cartas.clases;

public abstract class Carta {
	
	private String nombre;
	private int precio;
	
	public Carta(String nombre, int precio) {
		this.nombre = "Carta de " + nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPrecio() {
		return precio;
	}
	
	
}
