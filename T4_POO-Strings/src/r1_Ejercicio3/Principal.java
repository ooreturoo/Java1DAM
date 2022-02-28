package r1_Ejercicio3;

import Leer.Leer;

public class Principal {
	public static void main(String[] args) {
		boolean pedir = true;
		Maquina maquina = Maquina.getMaquina();

		while (pedir) {

			System.out.println();
			System.out.println("****Menu****");
			System.out.println("1. Café solo.");
			System.out.println("2. Leche.");
			System.out.println("3. Café con leche.");
			System.out.println("4. Consultar estado máquina.");
			System.out.println("5. Apagar la máquina y salir.");

			int numIntroducido = Leer.lecturaInt("\nIntroduce el número de la operación:");

			switch (numIntroducido) {
			case 1:
			case 2:
			case 3:
				maquina.servirCafe(numIntroducido);
				break;
			case 4:
				System.out.println(maquina);
				break;
			case 5:
				System.out.println("¡Vuelve Pronto!");
				pedir = false;
			case 100:
				maquina.llenarDepositos();
				break;
			case 101:
				maquina.vaciarMonedero();
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}

		}

	}
}
