package cartas.clases;

public class CartaNaveAtaque extends CartaNave{
	
	public static final int PRECIO = 5;
	public static final String NOMBRE = "Nave de Ataque";

	private CartaNaveAtaque() {
		
		super(NOMBRE, PRECIO, 1);
		
	}
	
	public static CartaNaveAtaque crearCartaNaveAtaque() {
		CartaNaveAtaque nave = null;
		if(getCartasDisponibles() != 0) {
			 new CartaNaveAtaque();
		}
		return nave;
	}


}
