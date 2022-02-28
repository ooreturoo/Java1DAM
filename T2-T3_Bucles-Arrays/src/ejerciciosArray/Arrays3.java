package ejerciciosArray;

import Leer.Leer;

public class Arrays3 {
	public static void main(String[] args){
		int menor, mayor, mayorRepetido, menorRepetido;
		double media = 0;
		int tamaño;
		int numeros[];
		
		do {
			tamaño = Leer.lecturaInt("Introduce la cantidad de campos del array: ");
			if(tamaño < 0) {
				System.out.println("No puedes dar un tamaño negativo al array.\n");
			}
			}while(tamaño < 0);
		
		numeros = new int[tamaño];
		
		
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = Leer.lecturaInt("Introduce los numeros para el array(" + (i+1) + " de " + numeros.length + ")");
		}
		
		menor = numeros[0];
		mayor = numeros[0];
		
		for(int i = 0; i < numeros.length; i++) {
			media += numeros[i];
			if(menor > numeros[i]){
				menor = numeros[i];
			}
			if (mayor < numeros[i]) {
				mayor = numeros[i];
			}
		}
		
		mayorRepetido = -1;
		menorRepetido = -1;
		
		for(int i = 0; i < numeros.length; i++) {
			if(mayor == numeros[i]) {
				mayorRepetido++;
			}
			if(menor == numeros[i]) {
				menorRepetido++;
			}
		}
		
		System.out.println("Mayor = " + mayor + "\nMenor = " + menor + "\nMedia = " + media/numeros.length);
		System.out.println("El mayor se ha repetido = " + mayorRepetido + " veces. El menor se ha repetido = " + menorRepetido + " veces.");
		
	}
}
