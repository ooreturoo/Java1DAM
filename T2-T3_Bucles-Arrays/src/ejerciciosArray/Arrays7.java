package ejerciciosArray;


public class Arrays7 {
	public static Boolean contieneElemento(int[] numeros, int buscarValor){
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] == buscarValor) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int longitud = 5;
		int[] numeros = new int[longitud];
		int valorBuscar = 5;
		
		for(int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce los números para el array (" + (i+1) + " de " + numeros.length + ")");
			numeros[i] = 5;
		}
		
		if(contieneElemento(numeros, valorBuscar)) {
			System.out.println("El valor si se encuentra en el array.");
		}else {
			System.out.println("El valor no se encuentra en el array.");
		}
	}
}
