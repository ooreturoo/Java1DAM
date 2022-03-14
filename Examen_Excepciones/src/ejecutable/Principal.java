package ejecutable;

import clases.Parking;
import menus.FuncionalidadMenu;

public class Principal {

	public static void main(String[] args) {
		
		Parking parking = new Parking();
		
		FuncionalidadMenu.ejecucionMenu(parking);
		
	}
	
}
