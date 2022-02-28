package ejerciciosArray;


public class Arrays_11 {
	public static void main(String[] args) {
		int[] numeros1 = {32, 63, 67, 2, 43, 46, 67, 23, 32};
		int[] numeros2 = {43, 6, 53, 63,12, 54, 3, 65, 56, 754, 32, 345, 54};
		
		int[] comunes = comunes(numeros1, numeros2);
		
		for(int num : comunes) {
			System.out.println(num);
		}
	}
	
	public static int[] comunes(int[] num1, int[] num2){
		
		int[] aux = new int[num1.length];
		int cont = 0;
		for(int i = 0; i < num1.length; i++) {
			for(int j = 0; j < num2.length; j++) {
				if(num1[i] == num2[j]) {
					aux[cont] = num1[i];
					cont++;
				}
			}
		}
		
		
		
		int[] comun = new int[cont];
		cont = 0;
		for(int i = 0; i < aux.length; i++) {
			if(aux[i] != 0) {
				comun[cont] = aux[i];
				cont++;
			}
		}
		
		return comun;
	}
	
	

}
