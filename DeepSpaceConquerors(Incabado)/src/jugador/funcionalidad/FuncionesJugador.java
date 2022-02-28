package jugador.funcionalidad;

import java.util.ArrayList;

import construcciones.clases.Construccion;
import jugador.clases.Jugador;
import planetasyrecursos.Planeta;
import utiles.Leer;
import utiles.TextosConsola;

public class FuncionesJugador {

	/**
	 * Retira oro del jugador al realizar una compra.
	 * @param jugador
	 * @param oroGastado
	 */
	public static void retiradaOroJugador(Jugador jugador, int oroGastado) {
		
		jugador.setOro(jugador.getOro() - oroGastado);
		
	}
	
	/**
	 * Obtiene todas las construcciones almacenadas en el mazo del jugador y le pregunta
	 * cual de ellas quiere construir.
	 * @param jugador Recibe el jugador que quiere construir.
	 * @return Devuelve la construcción seleccionada o null si no tiene construcciones o si elige salir.
	 */
	public static Construccion obtenerConstruccionMazo(Jugador jugador) {
		//Variable para guardar la construcción seleccionada por el jugador.
		Construccion construccion = null;
		//Obtiene el mazo del jugador y se almacena en un Arraylist para operar con el.
		ArrayList<Construccion> mazo = jugador.getMazoConstrucciones();
		
		//Si el mazo está vacío se avisa al usuario
		if(mazo.size() != 0) {
			/*
			 * El siguiente StringBuilder construira una cadena almacenando la información de las construcciones
			 * del mazo para mostrarselas al jugador y que pueda elegir la construcción deseada.
			 */
			StringBuilder sb = new StringBuilder();
			
			sb.append(TextosConsola.MAZO_JUGADOR);
			
			for(int i = 0; i < mazo.size(); i++) {
				
				sb.append("\n").append((i+1)).append(". ").append(mazo.get(i));
			}
			
			/*
			 * Se le asigna a cada construcción un número para que el jugador pueda seleccionar la construcción
			 * que quiere colocar.
			 */
			sb.append("\n").append((mazo.size()+1)).append(". ").append("Salir");
			//Se le pide que introduzca el número de la construcción a colocar.
			int numeroIntroducido = Leer.lecturaInt(TextosConsola.ELECCION_CONSTRUCCION, 1, mazo.size()+1) - 1;
			/*
			 * Si el número introducido está en el rango de construcciones disponibles se obtendra la construcción
			 * seleccionada, si el número es un número mayor que el total de construcciones a obtener, significará
			 * que el jugador a querido salir, por lo que no se hará nada y al final no se devolverá ninguna construcción.
			 */
			if(mazo.size() > numeroIntroducido) {
				construccion = mazo.get(numeroIntroducido);
			}
		}else {
			System.out.println(TextosConsola.MAZO_VACIO);
		}
		
		
		return construccion;
		
	}
	
	
	/**
	 * Método para obtener la posición que ocupa un planeta en el ArrayList que almacena los planetas
	 * conquistado por el jugador.
	 * @param jugador Jugador del que obtener la posición del planeta.
	 * @param planeta Planeta a buscar.
	 * @return Posición del planeta.
	 */
	public static int obtenerPosicionPlanetaJ(Jugador jugador, Planeta planeta) {
		//Obtiene el mazo del jugador y se almacena en un Arraylist para operar con el.
		ArrayList<Planeta> planetasJugador = jugador.getPlanetasEnPosesion();
		int posicionPlaneta = -1;
		//Busca el planeta en la lista de planetas que pertenecen al jugador.
		boolean planetaEncontrado = false;
		for(int i = 0; i < planetasJugador.size() && !planetaEncontrado; i++) {
			if(jugador.getPlanetasEnPosesion().get(i).getNombrePlaneta().equals(planeta.getNombrePlaneta())) {
				/*
				 * Una vez encontrado, se almacena la posición en la que se encuentra el planeta y se cambia
				 * el valor de la variable que avisa si se encontró el planeta.
				 */
				posicionPlaneta = i;
				planetaEncontrado = true;
			}
		}
		
		return posicionPlaneta;
	}

	
	/**
	 * Obtiene los nombres de los planetas en posesion del jugador para guardar
	 * los nombres es un StringBuilder para en un futuro imprimirlos.
	 * @param jugador Jugador del que obtener los nombres de los planetas.
	 * @return Devuelve un StringBuilder con los planetas del jugador.
	 */
	public static StringBuilder obtenerNombresPlanetasJ(ArrayList<Planeta> planetasJugador) {
		
		StringBuilder sb = new StringBuilder();
		//Obtiene la lista de planetas.
		
		//Recorre los planetas del jugador y almacena sus nombres en el StringBuilder.
		sb.append("\n(");
		for(int i = 0; i < planetasJugador.size(); i++) {
			sb.append(planetasJugador.get(i).getNombrePlaneta());
			if(i != planetasJugador.size()-1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		
		return sb;
	}
	
	/**
	 * Comprueba si el jugador se a quedado sin planetas y lo elimina de la partida.
	 * @param jugador
	 */
	public static void eliminarJugador(Jugador jugador) {
		if(jugador.getPlanetasEnPosesion().size() == 0) {
			jugador.setEliminado(true);
			System.out.println(jugador.getNombre() + "ha sido eliminado.");
		}
	}
	
	public static void conquistarPlaneta(Planeta planeta, String nombreJugador) {
		
		if(planeta.isConquistado()) {
			planeta.setNombreConquistador(nombreJugador);
		}
		
	}
	
	//TODO Implementar el acceso al mazo del jugador. Comprobando si devuelve nulo
	//TODO Implementar la comprobación de eliminar jugador al final de cada turno.
}
