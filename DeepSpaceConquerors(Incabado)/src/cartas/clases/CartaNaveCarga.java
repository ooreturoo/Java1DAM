package cartas.clases;

public class CartaNaveCarga extends CartaNave {

	public static final int PRECIO = 5;
	public static final String NOMBRE = "Nave de Carga";
	
	private CartaNaveCarga() {
		
		super(NOMBRE, PRECIO, 1);
		
	}
	
	public static CartaNaveAtaque crearCartaNaveCarga() {
		CartaNaveAtaque nave = null;
		if(getCartasDisponibles() != 0) {
			 new CartaNaveCarga();
		}
		return nave;
	}


}
