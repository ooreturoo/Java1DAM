package cartas.menu;

import cartas.funcionalidad.FuncionesCartas;
import jugador.clases.Jugador;
import utiles.Leer;

public class FuncionalidadMenuCartas {
	
	private static final String TEXTO_CARTAS = "Introduce el índice del tipo de carta que quieres comprar.";
	private static final String TEXTO_NAVES = "Introduce el índice del tipo de nave que quieres comprar.";
	private static final String TEXTO_CONSTRUCCIONES = "Introduce el índice de la construccion que quieres comprar.";
	
	public static boolean ImprimirMenuCartas(Jugador jugador) {
		boolean salirMenu = false;
		boolean accionRealizada = false;
		
		while(!accionRealizada && !salirMenu) {
			
			System.out.println(InterfazMenuCartas.MenuCartas());
			int indice = Leer.lecturaInt(TEXTO_CARTAS, 1, 4);
			
			switch (indice) {
			case 1:
				accionRealizada = ImprimirMenuCartasNaves(jugador);
				break;
			case 2:
				accionRealizada = ImprimirMenuCartasConstrucciones(jugador);
				break;
			case 3:
				salirMenu = true;
				break;
			}
			
		}
		
		return accionRealizada;
		
	}
	

	private static boolean ImprimirMenuCartasNaves(Jugador jugador) {
		boolean salirMenu = false;
		boolean naveObtenida = false;
		
		while(!naveObtenida && !salirMenu) {
			
			System.out.println(InterfazMenuCartas.MenuCartasNaves());
			int indice = Leer.lecturaInt(TEXTO_NAVES, 1, 5);
			
			if(indice != 4) {
				
				naveObtenida = FuncionesCartas.comprarCartaNave(jugador, indice);
				
			}else{
				
				salirMenu = true;

			}
		}
		
		return naveObtenida;
		
	}
	
	private static boolean ImprimirMenuCartasConstrucciones(Jugador jugador) {
		boolean salirMenu = false;
		boolean construccionComprada = false;
		while(!construccionComprada && !salirMenu) {
			
			System.out.println(InterfazMenuCartas.MenuCartasConstrucciones());
			int indice = Leer.lecturaInt(TEXTO_CONSTRUCCIONES, 1, 4);
			
			if(indice != 3) {
				
				FuncionesCartas.comprarCartaConstruccion(jugador, indice);
				
			}else{
				
				salirMenu = true;

			}	
		}
		
		return construccionComprada;
	}
	
	
}
