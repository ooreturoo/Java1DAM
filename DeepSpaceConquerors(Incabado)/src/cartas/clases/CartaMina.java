package cartas.clases;

import construcciones.clases.Mina;

public class CartaMina extends Carta {

	public static final int PRECIO = 1;
	public static final String NOMBRE = "Mina";
	private Mina mina;
	
	public CartaMina() {
	
		super(NOMBRE,PRECIO);
		
	}

	public Mina getMina() {
		return mina;
	}

	public void setMina(Mina mina) {
		this.mina = mina;
	}

	
}
