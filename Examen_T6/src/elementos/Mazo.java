package elementos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import excepciones.MazoException;


public class Mazo {

	private HashMap<Cromo, Integer> mazoCromos;

	public Mazo() {

		this.mazoCromos = new HashMap<Cromo, Integer>();
		
	}
	
	
	/**
	 * Añade un cromo al mazo. En el caso de ya tener ese cromo, aumenta la cantidad(valor)
	 * de los cromos del mismo tipo en posesión.
	 * @param cromo Cromo que añadir.
	 */
	public void addCromo(Cromo cromo) {
		
		if(mazoCromos.containsKey(cromo)) {
			
			int cantidadCromo = mazoCromos.get(cromo) + 1;
			
			mazoCromos.replace(cromo, cantidadCromo);
			
		}else {
			
			mazoCromos.put(cromo, 1);
			
		}
		
	}
	
	/**
	 * Intercambia un cromo de nuestro mazo por un cromo de otra persona.
	 * @param cromoPropio Recibe el cromo que queremos dar.
	 * @param cromoOtro Recibe el cromo que queremos obtener.
	 * @throws MazoException Lanza una excepci�n si el cromo propio si queremos dar no lo
	 * tenemos en nuestro mazo.
	 */
	public void intercambioCromo(Cromo cromoPropio, Cromo cromoOtro) throws MazoException {
		
		if(!mazoCromos.containsKey(cromoPropio)) {
			
			throw new MazoException("El mazo no contiene el cromo que se quiere intercambiar.");
			
		}
		
		//Se obtiene la cantidad de cromos de ese tipo restandole uno por el cromo que daremos.
		int cantidad = mazoCromos.get(cromoPropio) - 1;
		
		/*
		 * Comprobamos si era el unico cromo de ese tipo que teniamos, si lo es lo eliminamos del mazo
		 * y si no lo es almacenamos su nueva cantidad.
		 */
		if(cantidad == 0) {
			
			mazoCromos.remove(cromoPropio);
			
		}else {
			
			mazoCromos.put(cromoPropio, cantidad);
			
		}
		
		addCromo(cromoOtro);
		
	}
	
	/**
	 * Recibe un nuevo mazo y lo mezcla con el propio.
	 * @param nuevoMazo
	 */
	public void mezclarMazo(Mazo nuevoMazo) {
		
		//Si nuestro mazo está vacío lo añadimos directamente.
		if(mazoCromos.size() == 0) {
			
			mazoCromos = nuevoMazo.mazoCromos;
			
		}else {
			
			//Recorremos todos los cromos de nuestro mazo
			for(Cromo cromo : nuevoMazo.mazoCromos.keySet()) {
				
				//Obtenemos la cantidad del mismo cromo del nuevo mazo.
				int cantidadCromoNuevoMazo = nuevoMazo.mazoCromos.get(cromo);
				
				//Comprobamos si nuestro mazo tiene el cromo del nuevo mazo.
				if(this.mazoCromos.containsKey(cromo)) {
					
					/*
					 * Obtenemos la cantidad del cromo que tenemos en nuestro mazo y lo sumamos
					 * a la cantidad de los cromos nuevos que vamos a obtener.
					 */
					int cantidadTotal = mazoCromos.get(cromo) + cantidadCromoNuevoMazo;
					
					//Añadimos el cromo con la cantidad total de ellos.
					mazoCromos.put(cromo, cantidadTotal);
					
				}else {
					
					mazoCromos.put(cromo, cantidadCromoNuevoMazo);
					
				}
				
			}
			
		}
		
		
		
	}
	
	/**
	 * Obtiene y devuelve un conjunto de cromos que pertenezcan al equipo introducido
	 * por parametros.
	 * @param nombreEquipo
	 * @return
	 */
	public HashSet<Cromo> devolverCromosMismoEquipo(String nombreEquipo){
		
		HashSet<Cromo> listaCromosEquipo = new HashSet<Cromo>();
		
		//Recorre todas las claves.
		for(Cromo cromo : mazoCromos.keySet()) {
			
			/*
			 * Comprueba de que tipo es el cromo y obtiene el nombre del equipo al que
			 * pertenece, si son del equipo recibido por parametros, lo añade al conjunto.
			 */
			if(cromo instanceof Escudo) {
				
				Escudo escudo = (Escudo) cromo;
				
				if(escudo.getNombre().equals(nombreEquipo)) {
					
					listaCromosEquipo.add(escudo);
					
				}
				
			}else {
				
				Jugador jugador = (Jugador) cromo;
				
				if(jugador.getEquipo().equals(nombreEquipo)) {
					
					listaCromosEquipo.add(jugador);
					
				}
				
			}
			
			
		}
		
		return listaCromosEquipo;
		
	}
	
	/**
	 * Obtiene la altura de los jugadores de un mismo equipo y devuelve
	 * la media.
	 * @param nombreEquipo
	 * @return
	 */
	public double calcularAlturaEquipo(String nombreEquipo) {
		
		HashSet<Cromo> cromosEquipo = devolverCromosMismoEquipo(nombreEquipo);
		
		 OptionalDouble media = cromosEquipo.stream()
				.filter( c -> (c instanceof Jugador))
				.map( c -> (Jugador) c)
				.mapToDouble(j -> j.getAltura())
				.average();
		
		 return media.getAsDouble();
		 
	}
	
	
	/**
	 * Devuelve la cantidad de cromos diferentes que tenemos en el mazo.
	 * @return
	 */
	public int contarCromosDiferentes() {
		
		return mazoCromos.size();
		
	}
	
	
	/**
	 * Devuelve una lista con los cromos ordenados. La ordenación será la siguiente:
	 * 1. Por tipo. Los cromos de escudos irán primero
	 * 2. Dentro del mismo tipo, por orden alfabético según el nombre.
	 * @return
	 */
	public LinkedList<Cromo> devolverListaCromosOrdenados() {
		
		 List<Cromo> listaOrdenada = mazoCromos.keySet().stream().sorted( (a, b) -> {
			
			int orden = 0;
			
			if(a instanceof Escudo && b instanceof Escudo) {
				
				orden = a.compareTo(b);
				
			}else if(a instanceof Escudo) {
				
				orden = -1;
				
			}else if(b instanceof Escudo) {
				
				orden = 1;
				
			}else {
				
				orden = a.compareTo(b);
				
			}
			
			return orden;
			
		}).collect(Collectors.toList());	
		
		 return new LinkedList<Cromo>(listaOrdenada);
		 
	}
	
	/**
	 * Obtiene los equipos los cuales tenga el escudo y todos los jugadores,
	 * devolviendo los nombres nombres de los equipos.
	 * @return
	 */
	public List<String> equiposCompletos(){
		
		//Se obtiene la lista de escudos que tenemos en el mazo.
		List<Escudo> escudos = mazoCromos.keySet().stream()
														.filter( c -> (c instanceof Escudo))
														.map( c -> (Escudo) c)
														.collect(Collectors.toList()); 
		
		/*
		 * Comenzamos haciendo un stream de los escudos en posición y comprobamos que el número de jugadores
		 * del equipo sea igual al conteo de jugadores de ese equipo que tenemos en el mazo.
		 * 
		 * Para obtener la cantidad de jugadores de un equipo del mazo, convertimos el mazo a stream y filtramos
		 * los cromos para tener solo jugadores. Una vez que tenemos los cromos como Jugadores, comprobamos que
		 * el equipo al que pertenece sea el mismo que el nombre del escudo(obtenido del primer stream)
		 * y contamos la cantidad lo cumplen con el count.
		 * 
		 */
		List<String> nombreEscudos = escudos.stream()
											.filter( escudo -> escudo.getNumeroJugadores() == mazoCromos.keySet()
													.stream()
													.filter( c -> (c instanceof Jugador))
													.map( c -> ((Jugador) c).getEquipo())
													.filter( eq -> eq.equals(escudo.getNombre()))
													.count()
													)
											.map( escudo -> escudo.getNombre())
											.collect(Collectors.toList());
		
		return nombreEscudos;
		
	}

	
	/**
	 * Devuelve la lista de todos los cromos del mazo.
	 * @return
	 */
	public List<Cromo> devolverListaCromosTotales() {
		
		return mazoCromos.keySet().stream().collect(Collectors.toList());
		
	}
	
	
	
	
	
}
