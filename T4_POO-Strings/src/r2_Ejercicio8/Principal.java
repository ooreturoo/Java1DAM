package r2_Ejercicio8;

public class Principal {
	public static void main(String[] args) {
		Partido primerPartido = Partido.crearPartido();
		System.out.println(primerPartido);
		primerPartido.ponerResultado();
		System.out.println(primerPartido);
	}
}
