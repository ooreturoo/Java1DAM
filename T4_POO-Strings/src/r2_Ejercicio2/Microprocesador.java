package r2_Ejercicio2;

public class Microprocesador {
	private String marca;
	private String modelo;
	private int nucleos;
	private float velocidad;
	private String socket;
	
	public Microprocesador(String marca, String modelo, int nucleos, float velocidad, String socket) {
		this.marca = marca;
		this.modelo = modelo;
		this.nucleos = nucleos;
		this.velocidad = velocidad;
		this.socket = socket;
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
	public String getSocket() {
		return socket;
	}
}
