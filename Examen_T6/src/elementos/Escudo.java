package elementos;

public class Escudo extends Cromo {


	private int anioFundacion;
	private int numeroJugadores;
	
	
	
	public Escudo(int id, String nombre, int anioFundacion, int numeroJugadores) {
		
		super(id,nombre);

		this.anioFundacion = anioFundacion;
		this.numeroJugadores = numeroJugadores;
		
	}



	public int getAnioFundacion() {
		return anioFundacion;
	}



	public int getNumeroJugadores() {
		return numeroJugadores;
	}
	
	
	
}
