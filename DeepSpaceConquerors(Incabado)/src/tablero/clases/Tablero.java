package tablero.clases;

import jugador.clases.Jugador;
import planetasyrecursos.Planeta;
import planetasyrecursos.Planetas;
import utiles.Leer;
import utiles.TextosConsola;

public class Tablero {
	
	private static final int JUGADORES_MAX = 4;
	private static final int JUGADORES_MIN = 2;
	public static final Tablero TABLERO = new Tablero();
	private Planeta[] planetas;
	private Jugador[] jugadores;
	
	private Tablero() {}
	
	//Genera una instancia del tablero obteniendo la cantidad y los nombre de los jugadores por consola.
	public static void iniciarTablero() {
		
		int cantidadJugadores = Leer.lecturaInt(TextosConsola.PREGUNTA_JUGADORES, JUGADORES_MIN, JUGADORES_MAX);
		
		Jugador[] jugadores = new Jugador[cantidadJugadores];
		for(int i = 0; i < cantidadJugadores; i++) {
			jugadores[i] = new Jugador(Leer.lecturaString(TextosConsola.NOMBRE_JUGADORES + (i+1)));
		}
		
		Planeta[] planetas = new Planeta[Planetas.values().length];
		for(int i = 0; i < Planetas.values().length; i++) {
			planetas[i] = new Planeta(Planetas.values()[i]);
		}
		
		TABLERO.jugadores = jugadores;
		TABLERO.planetas = planetas;
		
	}

	public Planeta[] getPlanetas() {
		return planetas;
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	public void modificarPlaneta(int indice, Planeta planeta) {
		this.planetas[indice] = planeta;
	}
	public Planeta obtenerPlaneta(int indice) {
		return this.planetas[indice];
	}
}
