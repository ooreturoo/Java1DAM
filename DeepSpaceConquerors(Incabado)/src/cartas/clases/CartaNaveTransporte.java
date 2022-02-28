package cartas.clases;

public class CartaNaveTransporte extends CartaNave {

	public static final int PRECIO = 5;
	public static final String NOMBRE = "Nave de Transporte";
	
	private CartaNaveTransporte() {
		
		super(NOMBRE, PRECIO, 1);
		
	}
	
	public static CartaNaveAtaque crearCartaNaveTransporte() {
		CartaNaveAtaque nave = null;
		if(getCartasDisponibles() != 0) {
			 new CartaNaveTransporte();
		}
		return nave;
	}


}
