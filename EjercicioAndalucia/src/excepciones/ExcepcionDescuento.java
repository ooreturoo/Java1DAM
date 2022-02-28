package excepciones;

public class ExcepcionDescuento extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExcepcionDescuento() {
		super("La cantidad de descuento introducida no es válida.");
	}

}
