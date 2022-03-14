package menus;

import clases.Coche;
import clases.Parking;
import excepciones.ParkingException;
import excepciones.ValorCocheInvalidoException;
import utilidades.Funcionalidades;
import utilidades.Leer;

public class FuncionalidadMenu {

	public static void ejecucionMenu(Parking parking) {
		
		boolean salir = false;
		
		while(!salir) {
			
			InterfazMenu.ImprimirMenu();
			int indice = Leer.lecturaInt("Introduce el número de la acción a realizar.",1,6);
			try {
				salir = accionRequerida(indice, parking);
			} catch (ParkingException | ValorCocheInvalidoException e) {
				
				System.out.println(e.getMessage());
				
			}
			
		}
			
		
		
	}
	
	private static boolean accionRequerida(int indice, Parking parking) throws ParkingException, ValorCocheInvalidoException {
		
		boolean salidaMenu = false;
		
		if(indice > 1 && indice < 5) {
			
			if(parking.comprobarParkingVacio()) {
				
				throw new ParkingException("El parking está vacío.");
				
			}
			
		}
		
		switch(indice) {
		
		case 1:
			
			Coche coche = new Coche();
			Funcionalidades.obtenerValoresCoche(coche);
			parking.aparcarCoche(coche);
			break;
			
		case 2:
			parking.verCocheAparcado(Leer.lecturaInt("Introduce el número de plaza en la que buscar el coche.(1-30)")-1);
			break;
			
		case 3:
			parking.buscarCocheMatricula(Leer.lecturaString("Introduce la matrícula que quieres buscar."));
			break;
			
		case 4:
			parking.calcularTarifa(Leer.lecturaString("Introduce la matrícula del coche del que quieres calcular la tarifa."));
			break;
		case 5:
			
			salidaMenu = true;
		
		}
		
		return salidaMenu;
		
	}
	
	
}
