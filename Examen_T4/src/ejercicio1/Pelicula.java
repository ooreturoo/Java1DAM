package ejercicio1;

public class Pelicula {

	private String titulo;
	private int fechaEstreno;
	private String director;
	private double presupuesto;
	private double recaudacion;
	private String sinopsis;
	private String etiquetas;
	private int valoracion;
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Título: ").append(titulo);
		sb.append("\nAño estreno: ").append(fechaEstreno);
		sb.append("\nDirector: ").append(director);
		sb.append("\nPresupuesto: ").append(presupuesto);
		sb.append("\nRecaudación: ").append(recaudacion);
		sb.append("\nSinopsis: ").append(sinopsis);
		sb.append("\nEtiquetas: ").append(etiquetas);
		sb.append("\nValoración: ").append(valoracion);
		
		return sb.toString();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(int fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public double getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}
	public double getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	/**
	 * Método que obtiene la valoración dependiendo del presupuesto y la recaudación recibida.
	 * @param presupuesto
	 * @param recaudacion
	 * @param pelicula
	 */
	public static void obtenerValoracion(double presupuesto, double recaudacion, Pelicula pelicula) {
		int valoracion = (int)(((recaudacion - presupuesto) % presupuesto) *10);
		
		if(valoracion > 10) {
			valoracion = 10;
		}else if (valoracion < 0) {
			valoracion = 0;
		}
		
		pelicula.setValoracion(valoracion);
		
	}
}
