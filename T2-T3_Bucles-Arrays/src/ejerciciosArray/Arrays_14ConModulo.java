package ejerciciosArray;

public class Arrays_14ConModulo {
	public static Integer[] cola = new Integer[10];
	private static int contador;
	private static int posPrimero;

	public static void main(String[] args) {
		encolar(1);
		encolar(2);
		encolar(3);
		encolar(4);
		encolar(5);
		encolar(6);
		encolar(7);
		encolar(8);
		encolar(9);
		encolar(10);
		encolar(11);
		encolar(12);
		desencolar();
		desencolar();
		encolar(11);
		desencolar();
		desencolar();
		desencolar();
		desencolar();
		desencolar();
		desencolar();
		desencolar();
		desencolar();
		encolar(1);
		encolar(2);
		encolar(3);
		desencolar();

	}
	
	public static void encolar(int num) {
		if(cola.length > contador) {
			/*
			 * Añadimos el número introducido en la cola en la posicion del primero + la cantidad de elementos que hay introducidos.
			 * Si la posición del primero fuera la 5ª y hubiera 5 elementos en total, la suma seria igual a la longitud de la cola,
			 * por lo que el modulo de la cola se sencargaria de llevarlo a la posicion 0 e introducirlo allí.
			 */
			cola[(posPrimero + contador) % cola.length] = num;
			contador++;
			imprimir();
		}else {
			System.out.println("La cola está llena");
		}
	}
	
	public static void desencolar() {
		if(contador > 0) {
			cola[posPrimero] = null;
			contador--;
			/*
			 * La posicion de primero la incrementamos en uno y comprobamos con modulo de longitud que no haya llegado al final, si llega
			 * al final el modulo de la longitud de la cola se encarga de devolverlo a cero, esto significaria que los números que
			 * estaban en la cola han sido vaciados y la cola comienza desde la posicion 0 de nuevo.
			 */
			posPrimero = (posPrimero +1) % cola.length;
			imprimir();
		}else {
			System.out.println("La cola está vacía");
		}
	}
	
	public static void imprimir() {
		System.out.print("Cola = ");
		for(int i = 0; i < cola.length; i++) {
			if(cola[i] != null) {
				System.out.print(cola[i] + " ");
			}
		}
		
		System.out.println();
	}

}
