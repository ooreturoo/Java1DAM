package ejecutable;

import cartas.menu.FuncionalidadMenuCartas;
import jugador.clases.Jugador;
import planetasyrecursos.Planeta;
import tablero.clases.Tablero;

public class Prueba {
	public static void main(String[] args) {
		Tablero.iniciarTablero();
		
		Jugador[] jugadores = Tablero.TABLERO.getJugadores();
		int contadorAcciones = 2;
		for(int i = 0; i < jugadores.length; i++) {
			Jugador jugador = jugadores[i];
			jugador.getPlanetasEnPosesion().add(Tablero.TABLERO.getPlanetas()[1]);
			System.out.println("Jugador " + jugador.getNombre());
			
			for(int j = contadorAcciones; j > 0;) {

				boolean accionRealizada = FuncionalidadMenuCartas.ImprimirMenuCartas(jugador);
				if(accionRealizada) {
					contadorAcciones = -1;
				}
			}
		}
		
	}
}
