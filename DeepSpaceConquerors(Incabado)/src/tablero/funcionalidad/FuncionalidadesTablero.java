package tablero.funcionalidad;

import planetasyrecursos.Planetas;
import tablero.clases.Tablero;

public class FuncionalidadesTablero {
	
	/**
	 * Comprobará en que posición de los planetas almacenados del tablero se encuentra el planeta
	 * pasado por parámetro.
	 * @param planeta Planeta a buscar.
	 * @return Posición del planeta.
	 */
	public static int posicionPlanetaTablero(Planetas nombrePlaneta) {
		
		int numeroPlaneta = -1;
		boolean posicionEncontrada = false;
		for(int i = 0; i < Tablero.TABLERO.getPlanetas().length && !posicionEncontrada; i++) {
			if(nombrePlaneta.equals(Tablero.TABLERO.getPlanetas()[i].getNombrePlaneta())) {
				numeroPlaneta = i;
			}
		}
		
		return numeroPlaneta;
	}
	
}
