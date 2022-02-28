package dados.clases;

import java.util.Random;

import dados.interfaces.ILanzable;
import utiles.TextosConsola;

public abstract class Dado implements ILanzable{
	
	private int numeroCaras;
	private int valorMinimo;
	
	@Override
	public int lanzar() {
		Random generarNumero = new Random();
		System.out.println(TextosConsola.LANZAMIENTO_DADO);
		int resultadoDado = (int)(generarNumero.nextDouble() * numeroCaras + valorMinimo);
		System.out.println(TextosConsola.RESULTADO_DADO + resultadoDado);
		return resultadoDado;
	}

	public int getMin() {
		return valorMinimo;
	}
	
	public int getMax() {
		return valorMinimo + numeroCaras - 1;
	}
	
	protected void setNumeroCaras(int numeroCaras) {
		this.numeroCaras = numeroCaras;
	}

	protected void setValorMinimo(int valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	
	
	
}
