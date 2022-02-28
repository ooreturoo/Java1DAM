package ejerciciosArray;


public class Arrays6 {
		
	public static void main(String[] args) {
		int tamaño = 10;
		int buscarValor = 5;
		boolean contiene = false;
		int[] numeros = new int[tamaño];
		
		for(int i = 0; i < tamaño; i++) {
			numeros[i] = (int) Math.round(Math.random()*100);
		}
		
		for(int i = 0; i < tamaño && contiene == false; i++) {
			if(numeros[i] == buscarValor) {
				contiene = true;
			}
		}
		
		if (contiene) {
			System.out.println("El array contiene el número");
		}else {
			System.out.println("El array no contiene el número");
		}
		
	}
}
