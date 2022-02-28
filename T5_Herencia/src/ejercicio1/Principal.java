package ejercicio1;

import Leer.Leer;

public class Principal {

	public static void main(String[] args) {
		boolean salirMenu = false;
		CuentaCredito cuenta = new CuentaCredito();
		
		while(!salirMenu) {
			
			System.out.println("1. Ingresar saldo.");
			System.out.println("2. Retirar saldo.");
			System.out.println("3. Mostrar saldo y credito");
			System.out.println("4. Salir");
			
			int indice = Leer.lecturaInt(1, 5);
			
			switch(indice) {
			case 1:
				cuenta.ingresarSaldo();
				break;
			case 2:
				cuenta.retirarSaldo();
				break;
			case 3:
				System.out.println(cuenta);
				break;
			case 4:
				salirMenu = true;
				break;
			}
		}
	}
}
