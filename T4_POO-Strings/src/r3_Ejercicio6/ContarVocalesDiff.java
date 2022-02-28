package r3_Ejercicio6;

import Leer.Leer;

public class ContarVocalesDiff {
	public static void main(String[] args) {
		int vocales = 0;
		String texto = Leer.lecturaString("Introduce la frase o palabra para averiguar cuantas vocales distintas tiene.");
		if(texto.indexOf('a') != -1){
			vocales++;
		}
		if(texto.indexOf('e') != -1){
			vocales++;
		}
		if(texto.indexOf('i') != -1){
			vocales++;
		}
		if(texto.indexOf('o') != -1){
			vocales++;
		}
		if(texto.indexOf('u') != -1){
			vocales++;
		}
		
		System.out.printf("El texto introducido tiene %d vocales diferentes.", vocales);
		
	}
}
