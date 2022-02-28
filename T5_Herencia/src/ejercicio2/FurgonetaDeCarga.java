package ejercicio2;

public class FurgonetaDeCarga extends Vehiculo {

	private int pesoMaximo;
	
	public FurgonetaDeCarga(String matricula, Gama gama, int pesoMaximo) {
		super(matricula, gama);
		this.pesoMaximo = pesoMaximo;
	}

	public int getPesoMaximo() {
		return pesoMaximo;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Furgoneta de carga [");
		builder.append(super.toString());
		builder.append(", MPA = ");
		builder.append(pesoMaximo);
		return builder.toString();
	}
	
}
