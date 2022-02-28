package ejercicio2;

public class MicroBus extends Vehiculo{

	private int plazas;
	
	public MicroBus(String matricula, Gama gama, int plazas) {
		super(matricula, gama);
		this.plazas = plazas;
	}

	public int getPlazas() {
		return plazas;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MicroBus [");
		builder.append(super.toString());
		builder.append(", Plazas = ");
		builder.append(plazas);
		return builder.toString();
	}

}
