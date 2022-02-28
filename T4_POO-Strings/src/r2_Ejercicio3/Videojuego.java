package r2_Ejercicio3;

import java.time.LocalDate;

public class Videojuego {
	private String nombre;
	private String compañiaCreadora;
	private LocalDate añoCreado;
	private Ordenador caractMinimas;
	
	public Videojuego(String nombre, String compañiaCreadora, LocalDate añoCreado, Ordenador caractMinimas) {
		this.nombre = nombre;
		this.compañiaCreadora = compañiaCreadora;
		this.añoCreado = añoCreado;
		this.caractMinimas = caractMinimas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompañiaCreadora() {
		return compañiaCreadora;
	}

	public void setCompañiaCreadora(String compañiaCreadora) {
		this.compañiaCreadora = compañiaCreadora;
	}

	public LocalDate getAñoCreado() {
		return añoCreado;
	}

	public void setAñoCreado(LocalDate añoCreado) {
		this.añoCreado = añoCreado;
	}

	public Ordenador getCaractMinimas() {
		return caractMinimas;
	}

	public void setCaractMinimas(Ordenador caractMinimas) {
		this.caractMinimas = caractMinimas;
	}
	
}
