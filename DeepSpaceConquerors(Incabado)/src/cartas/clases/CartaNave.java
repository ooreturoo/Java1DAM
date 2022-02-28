package cartas.clases;

public abstract class CartaNave extends Carta{

	private static final int CARTAS_DISPONIBLES_TOTALES = 45;
	
	private static int cartasDisponibles = CARTAS_DISPONIBLES_TOTALES;

	//TODO comprobar si hay cartas disponibles , si no mandar excepcion y mandar carta null.
	protected CartaNave(String nombre, int precio, int cartaComprada) {
		super(nombre, precio);
		cartasDisponibles -= cartaComprada;
	}
	

	public static int getCartasDisponibles() {
		return cartasDisponibles;
	}

	
	
	
}
