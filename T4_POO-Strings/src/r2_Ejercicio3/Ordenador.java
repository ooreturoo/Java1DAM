package r2_Ejercicio3;

public class Ordenador {
	private int nucleosMicro;
	private float velocidadCPU;
	private int espacioDiscoD;
	private int nucleosGPU;
	private int memoriaGPU;
	
	public Ordenador(int nucleosMicro, float velocidadCPU,int espacioDiscoD, int nucleosGPU,int memoriaGPU) {
		this.nucleosMicro = nucleosMicro;
		this.velocidadCPU = velocidadCPU;
		this.espacioDiscoD = espacioDiscoD;
		this.nucleosGPU = nucleosGPU;
		this.memoriaGPU = memoriaGPU;
	}

	public int getNucleosMicro() {
		return nucleosMicro;
	}

	public void setNucleosMicro(int nucleosMicro) {
		this.nucleosMicro = nucleosMicro;
	}

	public float getVelocidadCPU() {
		return velocidadCPU;
	}

	public void setVelocidadCPU(int velocidadCPU) {
		this.velocidadCPU = velocidadCPU;
	}

	public int getEspacioDiscoD() {
		return espacioDiscoD;
	}

	public void setEspacioDiscoD(int espacioDiscoD) {
		this.espacioDiscoD = espacioDiscoD;
	}

	public int getNucleosGPU() {
		return nucleosGPU;
	}

	public void setNucleosGPU(int nucleosGPU) {
		this.nucleosGPU = nucleosGPU;
	}

	public int getMemoriaGPU() {
		return memoriaGPU;
	}

	public void setMemoriaGPU(int memoriaGPU) {
		this.memoriaGPU = memoriaGPU;
	}
}
