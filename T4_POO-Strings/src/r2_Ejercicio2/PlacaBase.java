package r2_Ejercicio2;

public class PlacaBase {
	private String marca;
	private String chipset;
	private String socket;
	
	public PlacaBase(String marca, String chipset, String socket) {
		this.marca = marca;
		this.chipset = chipset;
		this.socket = socket;
	}

	public String getMarca() {
		return marca;
	}

	public String getChipset() {
		return chipset;
	}

	public String getSocket() {
		return socket;
	}
	
}
