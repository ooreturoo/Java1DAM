package mensajes;

import java.time.LocalDate;

import enums.CategoriaMensajes;
import foros.Usuario;
import funcionalidades.Funcionalidades;

public class MensajeTexto {
	
	protected Usuario autor;
	protected String texto;
	protected CategoriaMensajes categoria;
	protected LocalDate fechaPublicacion;
	
	public MensajeTexto(Usuario autor, String texto, CategoriaMensajes categoria) {
		
		this.autor = autor;
		this.texto = texto;
		this.categoria = categoria;
		this.fechaPublicacion = LocalDate.now();
		
	}
	
	public double calcularPeso() {
		
		return calcularPesoTexto();
		
	}
	
	protected double calcularPesoTexto() {
		
		double bytes = texto.length();
		
		return Funcionalidades.pasarAMegaBytes(bytes);
		
	}

	public Usuario getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "Autor=" + autor + ", Texto=" + texto + ", Categoria=" + categoria + ", FechaPublicacion="
				+ fechaPublicacion + ", CalcularPeso()=" + calcularPeso();
	}
	
	
	
	
}
