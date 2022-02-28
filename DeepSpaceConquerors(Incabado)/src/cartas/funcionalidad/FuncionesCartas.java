package cartas.funcionalidad;

import java.util.Random;

import cartas.clases.*;
import cartas.menu.InterfazMenuCartas;
import construcciones.clases.Construccion;
import construcciones.funcionalidad.GeneradorConstrucciones;
import jugador.clases.Jugador;
import jugador.funcionalidad.FuncionesJugador;
import jugador.funcionalidad.InteraccionesJugador;
import recursos.clases.Materia;
import utiles.TextosConsola;

public class FuncionesCartas {
	
	//Guarda el mensaje que se imprimira al usuario si no tiene suficiente oro para comprar una carta.
	
	
	
	/**
	 * Genera aleatoriamente una carta de materiales.
	 * @return Una CartaMateriales del material generado.
	 */
	public static CartaMateriales cogerCartaMaterial() {
		
		//Crea un random para generar un número aleatorio.
		Random random = new Random();
		//Obtiene todos los materiales posibles.
		Materia[] materiales = Materia.values();
		/*
		 * Genera un número aleatorio y obtiene el material al que corresponde la posición del número generado
		 * en el array anterior.
		 */
		Materia material = materiales[(int) random.nextInt()*3];
		
		//Devuelve la carta del material generado.
		return new CartaMateriales(material);
		
	}
	
	public static boolean comprarCartaNave(Jugador jugador, int indice) {
		System.out.println(InterfazMenuCartas.MenuCartasNaves());
		CartaNave carta = null;
		boolean naveComprada = false;
		
		switch (indice) {
		case 1:
			carta = CartaNaveAtaque.crearCartaNaveAtaque();
			break;
		case 2:
			carta = CartaNaveTransporte.crearCartaNaveTransporte();
			break;
		case 3:
			carta = CartaNaveCarga.crearCartaNaveCarga();		
			break;
		}
		/*
		 * Comprobamos que la carta no sea nula puesto que si se han alcanzado el máximo de
		 * naves vendidas, no se creara la nave y se devolvera un false.
		 */
		if(carta != null) {
			if(carta.getPrecio() < jugador.getOro()) {
				System.out.println(TextosConsola.MENSAJE_FALTA_DINERO);
			}else {
				
				naveComprada = InteraccionesJugador.unionCartaNaveYOrbitar(jugador, carta);
				
				if(naveComprada) {
					FuncionesJugador.retiradaOroJugador(jugador, carta.getPrecio());
				}
				
			}
		}else {
			System.out.println(TextosConsola.CARTAS_NAVES_AGOTADAS);
		}
		
		return naveComprada;
		
	}
	
		
	public static void comprarCartaConstruccion(Jugador jugador, int indice) {
		
		Carta carta = null;
	
		switch (indice) {
		case 1:
			carta = new CartaMina();
			break;
		case 2:
			carta = new CartaEscudoProtector();
			break;
		}
		
		if(carta != null) {
			if(carta.getPrecio() > jugador.getOro()) {
				System.out.println(TextosConsola.MENSAJE_FALTA_DINERO);
				carta = null;
			}else {
				
				FuncionesJugador.retiradaOroJugador(jugador, carta.getPrecio());
				
				Construccion construccion = null;
				
				if(carta instanceof CartaMina) {
					
					construccion = GeneradorConstrucciones.generarMinaConCarta(carta);
					
				}else if(carta instanceof CartaEscudoProtector) {
					
					construccion = GeneradorConstrucciones.generarEscudoConCarta(carta);
					
				}
				
				jugador.getMazoConstrucciones().add(construccion);
			}
		}
		
		
		
		
	}
	
	
	

	//TODO Ataques a planetas
	//TODO Ataques a naves
	//TODO Conquista de planeta. LAs naves oribtadas se eliminan.
	//TODO Implementar menú de acciones e ir implementando métodos que faltan
	//TODO Lo primero buscar todo sobre el tablero e implementarlo.  
}
