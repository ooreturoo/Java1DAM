package ejerciciosArray;

public class Arrays_13 {
	
	private static final int MAX = 10;
	public static Integer[] pila = new Integer[MAX];
	
	public static void main(String[] args) {
		apilar(3);
		apilar(10);
		desapilar();
		apilar(5);
		apilar(50);
	}
	
	public static void apilar(int numero) {
		boolean lleno = true;
		for(int i = 0; i < pila.length && lleno; i++) {
			if(pila[i] == null) {
				pila[i] = numero;
				imprimir();
				lleno = false;
			}
		}
		
		if(lleno) {
			System.out.println("La pila está llena, no puedo apilar el elemento.");
		}
	}
	
	public static void desapilar() {
		boolean vacia = true;
		for(int i = pila.length-1; i >= 0 || vacia; i--) {
			if(pila[i] != null) {
				pila[i] = null;
				imprimir();
				vacia = false;
			}
		}
		if(vacia)
		System.out.println("No hay elementos en la pila.");
	}
	
	public static void imprimir() {
		System.out.print("Pila = ");
		for(int i = 0; i < pila.length; i++) {
			if(pila[i] != null) {
				System.out.print(pila[i] + " ");
			}
		}
		System.out.println();
	}
	
	
}
