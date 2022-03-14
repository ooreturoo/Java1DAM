package clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import excepciones.ParkingException;
import excepciones.ValorCocheInvalidoException;
import utilidades.Funcionalidades;

public class Parking {

	private static final int MAX_COCHES = 30;
	private static final double PRECIO_DIA = 12.65;
	
	private boolean parkingCompleto;
	private Coche[] cochesAparcados;
	
	public Parking() {
		
		cochesAparcados = new Coche[MAX_COCHES];
		parkingCompleto = false;
		
	}
	
	
	/**
	 * Método encargado de almacenar un coche en el array cochesAparcados. Si el array está completo lanzará una excepción.
	 * @param coche Recibe el coche que aparcar.
	 * @throws ParkingException
	 */
	public void aparcarCoche(Coche coche) throws ParkingException {
		
		if(parkingCompleto) {
			
			throw new ParkingException("El parking está completo.");
			
		}
		
		//Variable para comprobar si el vehículo ha sido aparcado.
		boolean cocheAparcado = false;
		
		//Recorre el array en busca de un hueco libre para almacenar el coche.
		for(int i = 0; i < cochesAparcados.length && !cocheAparcado; i++) {
			
			/*
			 * Se comprueba que el lugar que se está recorriendo está vacío. Si lo está se almacena el vehículo y se cambia
			 * el valor de la variable cocheAparcado a true.
			 */
			if(cochesAparcados[i] == null) {
				
				cochesAparcados[i] = coche;
				
				/*
				 * Se comprueba si la posición en la que se ha almacenado el coche es la última. Si lo es se establece el valo de
				 * la variable parkingCompleto a true.(Como no hay ningún método para sacar coches funcionaría correctamente, en el caso
				 * de haberlo habría que implementarlo de otra forma).
				 */
				
				if(i == MAX_COCHES-1) {
					
					parkingCompleto = true;
					
				}
				
				
			}
			
		}
		
		
		System.out.println("Coche aparcado.");
		
	
	}
	
	
	/**
	 * Método encargado de mostrar el coche aparcado en la posición recibida.
	 * @param plaza Posición de la que mostrar el coche aparcado.
	 * @throws ParkingException
	 */
	public void verCocheAparcado(int plaza) throws ParkingException {
		
		//Se comprueba que el valor recibido no es negativo y no es mayor que la longitud del almacenamiento.
		if(plaza < 0 || plaza >= MAX_COCHES) {
			
			throw new ParkingException("Esa plaza no existe.");
			
		}
		
		//Se comprueba que la plaza no esté vacía.
		if(cochesAparcados[plaza] == null) {
			
			throw new ParkingException("No hay ningún vehículo en esa plaza.");
			
		}

		//Se imprime el coche de la plaza.
		System.out.println(cochesAparcados[plaza]);
		
	}
	
	
	/**
	 * Método para buscar el coche que tenga la matrícula recibida por parámetro.
	 * @param matricula
	 * @return Devolverá el coche encontrado.
	 * @throws ValorCocheInvalidoException
	 */
	public Coche buscarCocheMatricula(String matricula) throws ValorCocheInvalidoException {
		
		//Se comprueba que la matricula sea válida.
		Funcionalidades.comprobarMatricula(matricula);
		
		//Almacenara el coche encontrado.
		Coche coche = null;
		
		//Indicará que el coche a sido encontrado.
		boolean cocheEncontrado = false;
		
		
		//Se recorre el almacenamiento de coches buscando uno que tenga la misma matricula que la recibida.
		for(int i = 0; i < cochesAparcados.length && !cocheEncontrado; i++) {
			
			//Se obtiene el coche de la posición que se está recorriendo.
			Coche cocheAparcado = cochesAparcados[i];
			
			
			//Se comprueba que la posición que se esta recorriendo no esté vacía.
			if(cocheAparcado != null) {
				
				//Se comprueba si la matricula del coche obtenido es igual que la matrícula recibida.
				if(cocheAparcado.getMatricula().equals(matricula)) {
					//Se indica que se ha encontrado el coche.
					cocheEncontrado = true;
					//Se muestran los datos del vehículo.
					System.out.println(cocheAparcado);
					System.out.println("Plaza: " + (i +1));
					//Se almacena el coche encontrado.
					coche = cocheAparcado;
					
				}
				
			}
			
		}
		
		//Si el coche no ha sido encontrado se indicará.
		if (!cocheEncontrado) {
			
			System.out.println("No se ha encontrado ningún coche con esa matrícula.");
			
		}
		
		return coche;
		
	}
	
	
	/**
	 * Método encargado de calcular la tarifa del vehículo al que le corresponda la matrícula recibida.
	 * @param matricula
	 * @throws ValorCocheInvalidoException
	 */
	public void calcularTarifa(String matricula) throws ValorCocheInvalidoException {
		
		//Se comprueba la validez de la matrícula.
		Funcionalidades.comprobarMatricula(matricula);
		
		//Se obtiene el coche que tiene la matricula.
		Coche coche = buscarCocheMatricula(matricula);
		
		//Se obtiene la diferencia de dias para calcular la tarifa.
		long diasDiferencia = ChronoUnit.DAYS.between(coche.getFechaAparcamiento(), LocalDate.now());
		
		//Se obtiene la tarifa.
		double tarifa =  diasDiferencia * PRECIO_DIA;
		
		//Se muestra la tarifa obtenida.
		System.out.println("La tarifa por el aparcamiento es de " + tarifa + "euros.");
		
	}
	
	
	/**
	 * Comprueba si el parking se encuentra vacío.
	 * @return
	 */
	public boolean comprobarParkingVacio() {
		
		boolean vacio = true;
		
		for(int i = 0; i < this.cochesAparcados.length && !vacio; i++) {
			
			if(cochesAparcados[i] != null) {
				
				vacio = false;
				
			}
			
		}
		
		return vacio;
		
	}
	
}
