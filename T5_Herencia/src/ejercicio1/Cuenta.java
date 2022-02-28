package ejercicio1;

public class Cuenta {
	
	private double saldo;
	
	
	public Cuenta() {
		saldo = 0;
	}
	
	public Cuenta(double saldo) {
		if(saldo < 0) {
			System.out.println("El saldo no puede ser menor que 0.");
			this.saldo = 0;
		}else {
			this.saldo = saldo;			
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
