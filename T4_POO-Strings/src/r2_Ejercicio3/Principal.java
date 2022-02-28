package r2_Ejercicio3;

import java.time.LocalDate;

public class Principal {
	public static void main(String[] args) {
		Videojuego videojuego = new Videojuego("COD", "Activision", LocalDate.of(2005, 10, 2),
				new Ordenador(3, 2.5f, 2000, 2, 3));
		Ordenador pc = new Ordenador(3, 3.2f, 2000, 2, 5);

		Ordenador minimos = videojuego.getCaractMinimas();
		if (pc.getEspacioDiscoD() >= minimos.getEspacioDiscoD() && pc.getMemoriaGPU() >= minimos.getMemoriaGPU()
				&& pc.getNucleosGPU() >= minimos.getNucleosGPU() && pc.getNucleosMicro() >= minimos.getNucleosMicro()
				&& pc.getVelocidadCPU() >= minimos.getVelocidadCPU()) {
				
			System.out.println("El juego se puede ejecutar en ese ordenador.");
		}else {
			System.out.println("El juego no se puede ejecutar en ese ordenador.");
		}
	}

}
