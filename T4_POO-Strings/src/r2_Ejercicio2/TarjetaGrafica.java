package r2_Ejercicio2;

public class TarjetaGrafica {
	private String marca;
	private String modelo;
	private int nucleos;
	private float velocidad;
	private int memoria;
	
	public TarjetaGrafica(String marca, String modelo, int nucleos, float velocidad, int memoria) {
		this.marca = marca;
		this.modelo = modelo;
		this.nucleos = nucleos;
		this.velocidad = velocidad;
		this.memoria = memoria;
	}
	
	
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getNucleos() {
		return nucleos;
	}
	public float getVelocidad() {
		return velocidad;
	}
	public int getMemoria() {
		return memoria;
	}
}
