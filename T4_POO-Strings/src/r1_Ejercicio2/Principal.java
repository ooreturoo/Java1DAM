package r1_Ejercicio2;

import Leer.Leer;

public class Principal {
	public static void main(String[] args) {
		boolean operaciones = true;
		Cuenta cuentaBanco = new Cuenta();
		
		while(operaciones) {
		System.out.println("*********MENU*********");
		System.out.println("1.Ingresar dinero");
		System.out.println("2.Retirar dinero");
		System.out.println("3.Consultar saldo");
		System.out.println("4.Salir");
		
		int numIntroducido = Leer.lecturaInt("\nIntroduce el número de la operación:");
		
		switch (numIntroducido) {
			case 1: //Si el numero introducido es 1, llama al metodo para ingresar dinero.
				cuentaBanco.ingreso();
				break;
			case 2: //Si el numero introducido es 2, llama al metodo para retirar dinero.
				cuentaBanco.retirada();
				break;
			case 3: //Si el numero introducido es 3, imprime el saldo de la cuenta.
				System.out.printf("Tu saldo es de %.2f€\n", cuentaBanco.getSaldoCuenta());
				break;
			case 4: //Si el numero introducido es 4, sale del menu.
				operaciones = false;
				System.out.println("¡Hasta pronto!");
				break;
			default://Si el numero introducido es  cualquier otro distinto a los anteriores, avisa al usuario que no es válido.
				System.out.println("Operación no válida.");
				break;
		
		}
		
		}
	}
}
