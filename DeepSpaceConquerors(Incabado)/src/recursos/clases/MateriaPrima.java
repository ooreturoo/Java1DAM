package recursos.clases;

public class MateriaPrima {

	private int cantidadMateria;
	
	private Materia tipoMateria;
	
	public MateriaPrima(int cantidadMateria, Materia tipoMateria) {
		this.cantidadMateria = cantidadMateria;
		this.tipoMateria = tipoMateria;
	}

	public int getCantidadMateria() {
		return cantidadMateria;
	}

	public Materia getTipoMateria() {
		return tipoMateria;
	}

	public void setCantidadMateria(int cantidadMateria) {
		this.cantidadMateria = cantidadMateria;
	}
	
	
}
