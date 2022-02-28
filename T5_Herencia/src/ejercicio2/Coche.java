package ejercicio2;

public class Coche extends Vehiculo{
	
	private String tipoCombustible;
	
	public Coche(String matricula, Gama gama, String tipoCombustible) {
		super(matricula,gama);
		this.tipoCombustible = tipoCombustible;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coche [");
		builder.append(super.toString());
		builder.append(", Combustible = ");
		builder.append(tipoCombustible);
		return builder.toString();
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}
	
	
	
}
