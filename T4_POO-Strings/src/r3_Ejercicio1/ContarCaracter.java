package r3_Ejercicio1;

public class ContarCaracter {
	
	public static void main(String[] args) {
		String cadena = "Hay varias as aqui";
		System.out.println(caracterRepetido(cadena, 'a'));
	}
	
	private static int caracterRepetido(String cadena, char caracter) {
		int vecesRepetidos = 0;
		cadena = cadena.toUpperCase();
		caracter = Character.toUpperCase(caracter);
		if(cadena.indexOf(caracter) != -1) {
			
			for(int i = 0; i < cadena.length(); i++) {
				if(cadena.charAt(i) == caracter) {
					vecesRepetidos++;
				}
			}
			
		}else {
			System.out.println("El caracter no se encuentra en la cadena.");
		}
		
		return vecesRepetidos;
		
	}
}
