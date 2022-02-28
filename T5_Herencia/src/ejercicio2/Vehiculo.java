package ejercicio2;

public class Vehiculo {
	
	private String matricula;
	private Gama gamaVehiculo;
	private double precioAlquiler;
	
	public Vehiculo(String matricula, Gama gama) {
		this.matricula = matricula;
		this.gamaVehiculo = gama;
	}

	public String getMatricula() {
		return matricula;
	}

	public Gama getGamaVehiculo() {
		return gamaVehiculo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Matricula = ");
		builder.append(matricula);
		builder.append(", Gama = ");
		builder.append(gamaVehiculo);
		return builder.toString();
	}

	public double getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	
}
