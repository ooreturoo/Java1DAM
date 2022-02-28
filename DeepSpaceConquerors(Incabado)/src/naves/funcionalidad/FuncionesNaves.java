package naves.funcionalidad;

import cartas.clases.*;
import dados.clases.*;
import jugador.clases.Jugador;
import jugador.funcionalidad.FuncionesJugador;
import naves.clases.*;
import planetasyrecursos.Planeta;
import utiles.TextosConsola;

public class FuncionesNaves {
	
	/*
	 * TODO falta implementar el método que una la compra de carta con orbitarNave,
	 * preguntando al usuario el planeta en el que mandar a orbitar y comprobando
	 * que el el metodo devuelve true.
	 */
	
	public static boolean orbitarNave(Jugador jugador, Planeta planeta, Carta carta) {
		
		boolean naveOrbitando = false;
		
		Nave nave = generarNave(carta, planeta, jugador);
		
		boolean huecoOrbita = false;
		int posicionHueco = -1;
		for(int i = 0; i < planeta.getNaves().length && !huecoOrbita; i++) {
			if(planeta.getNaves()[i] == null) {
				huecoOrbita = true;
				posicionHueco = i;
			}
		}
		
		if(posicionHueco != -1) {
			
			naveOrbitando = true;
			planeta.añadirNave(posicionHueco, nave);
			jugador.modificarPlanetasEnPosesion(FuncionesJugador.obtenerPosicionPlanetaJ(jugador, planeta), planeta);
			
		}else {
			System.out.println(TextosConsola.ORBITA_COMPLETA);
		}
		
		return naveOrbitando;
	}
	
	private static Nave generarNave(Carta carta, Planeta planeta, Jugador jugador) {
		
		Nave nave = null;
		Dado dado = null;
		
		if(carta instanceof CartaNaveAtaque) {
			
			nave = new NaveAtaque(planeta, jugador.getNombre());
			
		}else if(carta instanceof CartaNaveTransporte) {
			
			dado = new Dado_C();
			int resultadoDado = dado.lanzar();
			nave = new NaveTransporte(resultadoDado, planeta, jugador.getNombre());
			System.out.println("\n" + TextosConsola.CAPACIDAD_TRANSPORTE + resultadoDado + " habitantes.");
			
		}else if(carta instanceof CartaNaveCarga) {
			
			dado = new Dado_A();
			int resultadoDado = dado.lanzar();
			nave = new NaveCarga(resultadoDado, planeta, jugador.getNombre());
			System.out.println("\n" + TextosConsola.CAPACIDAD_GARGA + resultadoDado + " recursos.");
		}
		
		return nave;
		
	}
	
	
	
	
	
}
