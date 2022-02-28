package jugador.funcionalidad;

import java.util.ArrayList;

import cartas.clases.Carta;
import jugador.clases.Jugador;
import naves.funcionalidad.FuncionesNaves;
import planetasyrecursos.Planeta;
import tablero.clases.Tablero;
import tablero.funcionalidad.FuncionalidadesTablero;
import utiles.*;

public class InteraccionesJugador {
	
	public static boolean unionCartaNaveYOrbitar(Jugador jugador, Carta carta) {
		
		boolean salir = false;
		boolean naveOrbitada = false;
		ArrayList<Planeta> planetasJugador = jugador.getPlanetasEnPosesion();
		StringBuilder sb = new StringBuilder();
		
		sb.append(TextosConsola.PLANETA_A_ORBITAR);
		sb.append(FuncionesJugador.obtenerNombresPlanetasJ(planetasJugador));
		
		while(!salir) {
			
			String nombrePlaneta = Leer.lecturaString(sb.toString()).toLowerCase();
			for(int i = 0; i < planetasJugador.size(); i++) {
				Planeta planetaJugador = planetasJugador.get(i);
				if(planetaJugador.getNombrePlaneta().toString().toLowerCase().equals(nombrePlaneta)) {
					salir = true;
					naveOrbitada = FuncionesNaves.orbitarNave(jugador, planetaJugador, carta);
					if(naveOrbitada) {
						jugador.modificarPlanetasEnPosesion(i, planetaJugador);
						Tablero.TABLERO.modificarPlaneta(
								FuncionalidadesTablero.posicionPlanetaTablero(planetaJugador.getNombrePlaneta()), planetaJugador);
					}
				}
			}
			
			if(!salir) {
				System.out.println(TextosConsola.NOMBRE_PLANETA_INVALIDO);
			}
		}
		
		return naveOrbitada;
		
	}
	
	
}
