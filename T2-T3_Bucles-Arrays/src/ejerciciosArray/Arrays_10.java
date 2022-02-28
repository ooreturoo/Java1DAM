package ejerciciosArray;


public class Arrays_10 {
	public static Integer[] eliminarDuplicados(Integer[] valores) {
		int cont = 0;
		/*
		 * Recorremos el array y si la posicion de "i" es distinta a la posicion "j". Si son distintos, comprobamos
		 *  que le valor de "i" sea igual que el de "j", si es así dejamos i vacío y aumentamos contador(que nos contara
		 *  las posiciones vacías.
		 */
		
		for(int i = 0; i < valores.length; i++) {
			for(int j = 0; j < valores.length; j++) {
				if(i != j) {
					if(valores[i]==valores[j]) {
						valores[i] = null;
						cont++;
					}
				}
			}
		}
		
		/*
		 * Creamos un nuevo array con la longitud del anterior menos las posiciones vacias.
		 * Luego con un bucle lo rellenamos de las posiciones que no estan vacías, con la ayuda de "cont" que 
		 * sera nuestro iterador para el nuevo array.
		 */
		Integer[] aux = new Integer[valores.length-cont];
		cont = 0;
		for(int i = 0; i < valores.length; i++) {
			if(valores[i] != null) {
				aux[cont] = valores[i];
				cont++;
			}
		}
		
		return aux;
		
		
	}
	
	
	
	public static void main(String[] args) {
		Integer[] numeros = {5, 76, 5, 84, 12, 67, 78, 34, 12, 84};
		Integer[] sinDuplicados = eliminarDuplicados(numeros);
		for(int nums : sinDuplicados) {
			System.out.println(nums);
		}
		
	}
}
