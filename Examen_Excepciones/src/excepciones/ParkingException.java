package excepciones;

public class ParkingException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public ParkingException(String msg) {
		super(msg);
	}
}
