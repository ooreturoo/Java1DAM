package elementos;

public class Jugador extends Cromo{


	private String equipo;
	private int altura;
	
	
	public Jugador(int id, String nombre, String equipo, int altura) {
		
		super(id, nombre);
		this.equipo = equipo;
		this.altura = altura;
		
	}


	public String getEquipo() {
		return equipo;
	}


	public int getAltura() {
		return altura;
	}
	
	
	
}
