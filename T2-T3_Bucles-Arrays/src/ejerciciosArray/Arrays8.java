package ejerciciosArray;

public class Arrays8 {
	public static <T> int posicionContiene(T[] elementos, T valorBuscar) {
		for(int i = 0; i < elementos.length; i++) {
			if(elementos[i] == valorBuscar) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String[] cadena = {"Madrid", "Murcia", "Barcelona", "Galicia", "Sevilla"};
		int valor = posicionContiene(cadena, "Sevilla");
		if(valor >= 0) {
			System.out.println("El valor esta en la posición " + valor);
		}else {
			System.out.println("El valor no se encuentra el el array");
		}
	}
}
