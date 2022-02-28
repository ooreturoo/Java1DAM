package r3_Ejercicio9;



import Leer.Leer;

public class Sumar {
	public static void main(String[] args) {
		String texto = Leer.lecturaString("Introduce un texto.");
		int suma = 0;
		
		for(int i = 0; i < texto.length(); i++) {
			if(Character.isDigit(texto.charAt(i))) {
				boolean esNumero = true;
				int cont = i+1;
				while(esNumero && cont < texto.length()) {
					if(Character.isDigit(texto.charAt(cont))) {
						cont++;
					}else {
						esNumero = false;
					}
				}
				
				suma += Integer.parseInt(texto.substring(i, cont));
				i = cont;
			}
			
			
		}
		
		System.out.println(suma);
		
	}
}
