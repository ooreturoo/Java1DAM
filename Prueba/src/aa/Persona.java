package aa;

public class Persona {

	private String nombre;
	private int edad;
	private int altura;
	private Coche coche;
	
	
	
	public Persona(String nombre, int edad, int altura, Coche coche) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.coche = coche;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public Coche getCoche() {
		return coche;
	}
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	
	
}
