package construcciones.funcionalidad;

import java.util.ArrayList;

import construcciones.clases.Construccion;
import construcciones.clases.Mina;
import jugador.clases.Jugador;
import jugador.funcionalidad.FuncionesJugador;
import planetasyrecursos.FuncionesPlanetas;
import planetasyrecursos.Planeta;
import recursos.clases.MateriaPrima;
import tablero.clases.Tablero;
import tablero.funcionalidad.FuncionalidadesTablero;
import utiles.Leer;
import utiles.TextosConsola;

public class ColocacionConstrucciones {
	
	/**
	 * Coloca la mina recibida en un planeta si este cumple con los recursos y con los habitantes necesarios.
	 * @param jugador Recibe el jugador que va a colocar al mina.
	 * @param mina Recibe la mina a colocar.
	 * @return Devolvera true si se consiguió colocar la mina, false en caso contrario.
	 */
	public static boolean colocarMina(Jugador jugador, Mina mina) {
		//Variable que de volvera el método informando si se pudo instalar la mina.
		boolean minaColocada = false;
		//Obtiene la lista de los planetas de los que el jugador es dueño.
		ArrayList<Planeta> planetasJugador = jugador.getPlanetasEnPosesion();
		//Llama al método para obtener el planeta en el que se puede instalar la mina y se guarda para su posterior uso
		Planeta planetaConstruible = obtenerPlanetaConstruible(planetasJugador, mina);
		
		/*
		 * Comprueba que el valor del planeta recibido no sea null, es decir, que se haya encontrado algún
		 * planeta en el que es posible la construcción. 
		 */
		if(planetaConstruible != null) {
			
			//Obtenemos la localización del planeta en el array de tablero que los almacena
			int numeroPlaneta = FuncionalidadesTablero.posicionPlanetaTablero(planetaConstruible.getNombrePlaneta());
			/*
			 * Obtenemos a través de la llamada al método los materiales que quedaran en el planeta
			 * una vez se instale la estructura.
			 */
			MateriaPrima[] restoMateriales = FuncionesPlanetas.reducirAumentarRecursosPlaneta(
					planetaConstruible.getMateriasPrimas(), Mina.COSTES_CONSTRUCCION, '-');
			
			//Modificaremos los habitantes del planeta restando los habitantes que se introduciran en la mina.
			planetaConstruible.setNumeroHabitantes(planetaConstruible.getNumeroHabitantes() - Mina.PERSONAS_NECESARIAS);
			//Le asignamos al planeta los materiales.
			planetaConstruible.setMateriasPrimas(restoMateriales);
			
			//Obtenemos la localización del planeta en las posesiones del jugador.
			int numeroPlanetaJugador = FuncionesJugador.obtenerPosicionPlanetaJ(jugador, planetaConstruible);
			
			//Actualizamos los valores del planeta en la lista de planetas del jugador.
			jugador.modificarPlanetasEnPosesion(numeroPlanetaJugador, planetaConstruible);;
			
			//Añadimos el planeta al tablero en la posición obtenida anteriormente.
			Tablero.TABLERO.modificarPlaneta(numeroPlaneta, planetaConstruible);
			//Marcamos que se ha colocado la mina correctamente.
			minaColocada = true;
		}
		
		return minaColocada;
	}
	
	
	/**
	 * Busca en los planetas que posee el jugador y pregunta en cual de ellos quiere construir la estructura, si el planeta no tiene el limite de estructuras,
	 * devolvera el planeta seleccionado en el que es posible construir. En caso de que el jugador no quiera colocar la estructura y salga, se devolvera un valor null.
	 * @param planetasJugador Recibe un Arraylist con los planetas del jugador.
	 * @param construccion Recibe la instancia de la construcción que se quiere colocar.
	 * @return Devuelve un Planeta en el que es posible construir o en caso contrario un valor null.
	 */
	private static Planeta obtenerPlanetaConstruible(ArrayList<Planeta> planetasJugador, Construccion construccion) {
		
		//Crea un StringBuilder que almacenara la cadena que se le mostrará al jugador junto a los nombre de los planetas en su posesión.
		StringBuilder sb = new StringBuilder();
		sb.append(TextosConsola.COLOCACION_MINA);
		//Llamamos al método que nos devolvera todos los nombres de los planetas del jugador para imprimirlos.
		sb.append(FuncionesJugador.obtenerNombresPlanetasJ(planetasJugador));
		
		//Variable que almacenara el planeta en el que sea posible instalar la estructura y sera devuelta por el método.
		Planeta planetaConstruible = null;
		//Variable que permitira al jugador salir de la colocación de estructuras.
		boolean salir = false;
		
		/*
		 * Mientras que no se encuentre el planeta en el que construir o el jugador no decida salir, se repetira la 
		 * pregunta de planeta en el que construir y sus comprobaciones.
		 */
		
		while(planetaConstruible == null && !salir) {
			
			//Guarda el nombre del planeta introducido por el jugador.
			String nombreIntroducido = Leer.lecturaString(sb.toString());
			
			//Recorre los planetas pertenecientes al jugador.
			for(Planeta planetaJugador : planetasJugador) {
				//Comprueba que el nombre introducido coincide con el nombre de un planeta.
				if(nombreIntroducido.toLowerCase().equals(planetaJugador.getNombrePlaneta().toString())) {
					//Comprueba que ese planeta posea los recursos necesarios para construir la estructura.
					if(comprobarRecursos(planetaConstruible, construccion)) {
						//Comprueba si la construccion es una instancia de mina  o en caso contrario, es estancia del escudo protector.
						if(construccion instanceof Mina) {
							//Variable almacenara si el planeta tiene un hueco en el que poder construir la mina.
							boolean huecoMina = false;
							//Comprueba si hay hueco para construir la mina.
							for(int i = 0; i < planetaJugador.getMinas().length && !huecoMina; i++) {
								if(planetaJugador.getMinas()[i] == null) {
									//Si hay hueco se introduce la mina en el planeta casteando la construccion del parámetro.
									planetaJugador.añadirMina(i, (Mina)construccion);
									huecoMina = true;
								}
							}
							
							//Si el planeta tiene hueco, se guardará en la variable.
							if(huecoMina) {
								planetaConstruible = planetaJugador;
							}else {
								System.out.println(TextosConsola.PLANETA_MINAS_COMPLETAS + planetaJugador.getNombrePlaneta());
							}
						}else {
							//Comprueba si el planeta no tiene escudo para poder construir uno. En caso contrario avisa al jugador.
							if(!planetaJugador.isEscudoProtector()) {
								planetaConstruible = planetaJugador;
							}else {
								System.out.println(TextosConsola.PLANETA_CON_ESCUDO);
							}
						}
					}
				//Si el nombre introducido no coincide con ningun planeta, avisa al jugador.
				}else {
					System.out.println(TextosConsola.NOMBRE_PLANETA_INVALIDO);
				}
				
			}
			//Si no se enscontró el planeta, pregunta si quiere volvera intentar buscar el planeta o salir.
			if(planetaConstruible == null) {
				if(Leer.lecturaString(TextosConsola.SALIR_CONTRUCCION).toLowerCase().equals("si")) {
					salir = true;
				}
			}
			
		}
		
		
		
		return planetaConstruible;
	}
	
	
	/**
	 * Comprueba si un planeta tiene los recursos suficientes para poder construir la estructura.
	 * @param planetaConstruible Recibe el planeta a comprobar
	 * @param construccion Recibe la estructura que se quiere implementar.
	 * @return Devuelve true si es posible construir la estructura.
	 */
	private static boolean comprobarRecursos(Planeta planetaConstruible, Construccion construccion) {
		
		boolean recursosSuficientes = false;
		
		MateriaPrima[] restoMateriales = FuncionesPlanetas.reducirAumentarRecursosPlaneta(
				planetaConstruible.getMateriasPrimas(), construccion.COSTES_CONSTRUCCION, '-');
		
		if(planetaConstruible.getNumeroHabitantes() >= construccion.PERSONAS_NECESARIAS) {
			if(!restoMateriales.equals(planetaConstruible.getMateriasPrimas())) {
				recursosSuficientes = true;
			}else {
				System.out.println(TextosConsola.MATERIALES_INSUFICIENTES);
			}
		}else{
			System.out.println(TextosConsola.HABITANTES_INSUFICIENTES);
		}
		
		return recursosSuficientes;
		
	}
	
	
	
	//TODO Metodo para colocar escudo.
	
}
