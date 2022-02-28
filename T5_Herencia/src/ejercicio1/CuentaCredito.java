package ejercicio1;

import Leer.Leer;

public class CuentaCredito extends Cuenta {
	
	private final int MAX_CREDITO = 300;
	private final int CREDITO_DEFECTO = 100;
	private double credito;
	
	public CuentaCredito() {
		super();
		credito = CREDITO_DEFECTO;
	}
	
	public CuentaCredito(double saldo) {
		super(saldo);
		this.credito = CREDITO_DEFECTO;
	}
	
	public CuentaCredito(double saldo, double credito) {
		super(saldo);
		setCredito(credito);
	}
	
	public void setCredito(double credito) {
		if(credito >= 0 && credito <= MAX_CREDITO) {
			this.credito = credito;
		}else {
			credito = CREDITO_DEFECTO;
		}
	}
	
	public void ingresarSaldo() {
		double saldoIngresado = Leer.lecturaDouble("Introduce la cantidad de saldo a ingresar.", 0, true);
		this.setSaldo(saldoIngresado);
	}
	
	public void retirarSaldo() {
		double saldoRetirado = Leer.lecturaDouble("Introduce el saldo a retirar.", 0 , true);
		if(saldoRetirado <= (this.getSaldo() + this.credito)) {
			this.setSaldo(this.getSaldo() - saldoRetirado);
		}else{
			System.out.println("No puedes retirar más saldo del disponible.");
		}
	}
	
	@Override
	public String toString() {
		
		return "Saldo = " + this.getSaldo() + " Credito = " + this.credito;
	}
	
	
	
	
	
	
	
	
}
