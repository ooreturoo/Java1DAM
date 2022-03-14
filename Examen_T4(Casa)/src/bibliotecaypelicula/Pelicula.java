package bibliotecaypelicula;

import excepciones.FechaEstrenoException;

public class Pelicula {

	private String titulo;
	private int estreno;
	private String director;
	private double presupuesto;
	private double recaudacion;
	private String sinopsis;
	private String etiquetas;
	private double valoracion;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEstreno() {
		return estreno;
	}
	public void setEstreno(int estreno) throws FechaEstrenoException {
		if(estreno < 1950 || estreno > 2022) {
			throw new FechaEstrenoException("La fecha indicada no es válida.");
		}
		
		this.estreno = estreno;
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
	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pelicula [titulo=");
		builder.append(titulo);
		builder.append(", estreno=");
		builder.append(estreno);
		builder.append(", director=");
		builder.append(director);
		builder.append(", presupuesto=");
		builder.append(presupuesto);
		builder.append(", recaudacion=");
		builder.append(recaudacion);
		builder.append(", sinopsis=");
		builder.append(sinopsis);
		builder.append(", etiquetas=");
		builder.append(etiquetas);
		builder.append(", valoracion=");
		builder.append(valoracion);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
