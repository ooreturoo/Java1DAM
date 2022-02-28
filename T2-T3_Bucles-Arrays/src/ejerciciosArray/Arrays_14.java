package ejerciciosArray;

public class Arrays_14 {
	public static Integer[] cola = new Integer[10];
	
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
		
	}
	
	public static void encolar(int num) {
		boolean lleno = true;
		

		for(int i = 0; i < cola.length && lleno; i++) {
			if(cola[i] == null) {
				cola[i] = num;
				imprimir();
				lleno = false; 
			}
		}
		
		if(lleno) {
			System.out.println("La cola está llena, no puedo encolar el elemento.");
		}
	}
	
	public static void desencolar() {
		boolean vacia = true;
		for(int i = 0; i < cola.length && vacia; i++) {
			if(cola[i] != null) {
				cola[i] = null;
				imprimir();
				vacia = false;
			}
		}
		
		for(int i = 0; i < cola.length-1; i++) {
			if(cola[i] == null && cola[i+1] != null) {
				cola[i] = cola[i+1];
				cola[i+1] = null;
			}
		}
		
		if(vacia)
		System.out.println("No hay elementos en la pila.");
		
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
