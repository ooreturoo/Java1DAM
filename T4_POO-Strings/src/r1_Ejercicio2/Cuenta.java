package r1_Ejercicio2;

import Leer.Leer;

public class Cuenta {
	
	private double saldoCuenta;
	private int vecesRetiradas = 0;
	private int vecesIngresadas = 0;
	
	/**
	 * Método encargado de retirar saldo de la cuenta.
	 */
	public void retirada() {
		int cantidadRetirada = Leer.lecturaInt("Introduce la cantidad a retirar.(Mínimo 5€)"); //Pide al usuario la cantidad a ingresar
		
		if(cantidadRetirada > 5 && saldoCuenta >= cantidadRetirada) {//Comprueba si cumple el minimo de retirada y si en la cuenta
																	// hay el mismo saldo o más del que quiere retirar.
			
			vecesRetiradas++;//Suma una retida al contador de retiradas realizadas.
			saldoCuenta -= cantidadRetirada;//Le resta al saldo la cantidad retirada.
			System.out.printf("Has retirado %d€. Tu saldo actual es de %.2f€.\n", cantidadRetirada, this.saldoCuenta);
			
		}else if(saldoCuenta < cantidadRetirada) {//Si el saldo de la cuenta es menor que el que quiere retirar, avisa al usuario.
			System.out.printf("No tienes suficiente dinero en la cuenta para retirar esa cantidad. Tu saldo actual es de %.2f€.\n", this.saldoCuenta);
		}else {//Si la cantidad a retirar es menor que el minimo por retirada, avisa al usuario.
			System.out.println("Cantidad para retirar no valida.");
		}
	}
	
	/**
	 * Método encargado del ingreso de saldo en la cuenta.
	 */
	public void ingreso() {
		int cantidadIngreso = Leer.lecturaInt("Introduce la cantidad a ingresar.");//Pide al usuario la cantidad a ingresar
		
		if(cantidadIngreso > 0) {//Comprueba que la cantidad introducida por el usuario es positiva y mayor que 0.
			vecesIngresadas++;//Suma una retida al contador de ingresos realizados.
			saldoCuenta += cantidadIngreso;//Suma el dinero ingresado al saldo de la cuenta.
			System.out.printf("Has ingresado %d€. Tu saldo actual es de %.2f€\n", cantidadIngreso, this.saldoCuenta);
		}else {//Si la cantidad a ingresar no es válida, avisa al usuario.
			System.out.println("Cantidad para ingresar no valida.");
		}
		
	}

	public double getSaldoCuenta() {
		return saldoCuenta;
	}
	

	public int getVecesRetiradas() {
		return vecesRetiradas;
	}

	public int getVecesIngresadas() {
		return vecesIngresadas;
	}
}
