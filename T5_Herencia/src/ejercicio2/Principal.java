package ejercicio2;

import Leer.Leer;

public class Principal {
	public static void main(String[] args) {
		EmpresaAlquiler empresa1 = new EmpresaAlquiler();
		boolean salir = false;
		while(!salir) {
			System.out.println("1. �lta de veh�culo.");
			System.out.println("2. C�lculo precio alquiler.");
			System.out.println("3. Salir.");
			
			int indice = Leer.lecturaInt("Introduce el indice de la acci�n a realizar.", 1, 4);
			
			switch(indice) {
			case 1:
				empresa1.altaVehiculo();
				break;
			case 2:
				String matricula = Leer.lecturaString("Introduce la matr�cula del veh�culo.");
				empresa1.calculoPrecio(matricula);
				break;
			case 3:
				salir = true;
				break;
			}
		}
	}
}
