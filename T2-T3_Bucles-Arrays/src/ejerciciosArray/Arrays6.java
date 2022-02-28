package ejerciciosArray;


public class Arrays6 {
		
	public static void main(String[] args) {
		int tama�o = 10;
		int buscarValor = 5;
		boolean contiene = false;
		int[] numeros = new int[tama�o];
		
		for(int i = 0; i < tama�o; i++) {
			numeros[i] = (int) Math.round(Math.random()*100);
		}
		
		for(int i = 0; i < tama�o && contiene == false; i++) {
			if(numeros[i] == buscarValor) {
				contiene = true;
			}
		}
		
		if (contiene) {
			System.out.println("El array contiene el n�mero");
		}else {
			System.out.println("El array no contiene el n�mero");
		}
		
	}
}
