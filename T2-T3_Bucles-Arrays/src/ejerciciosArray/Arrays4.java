package ejerciciosArray;

public class Arrays4 {
	public static void main(String[] args) {
		final int GENERAR_NUMEROS= 60;
		double media = 0;
		double mediaPorcentajes = 0;
		int[] contDigitoFinal = new int[10];
		
		for(int i = 0; i < GENERAR_NUMEROS; i++) {
			int numGenerado = (int) Math.round(Math.random()*100);
			
			media += numGenerado;
			
			contDigitoFinal[numGenerado % 10]++;
			
		}
		
		
		for(int i = 0; i < 10; i++) {
			mediaPorcentajes += (double) contDigitoFinal[i]*100/GENERAR_NUMEROS;
			if(contDigitoFinal[i] == 0) {
				System.out.printf("El nº %d no se ha repetido ninguna vez.", contDigitoFinal[i]);
			}else {
				System.out.printf("El nº %d se ha repetido %d veces , esto equivale a un %.2f%%. \n", i,contDigitoFinal[i], (double)contDigitoFinal[i]*100/GENERAR_NUMEROS);
			}
		}
		
		System.out.println();
		
		System.out.printf("La suma de los números introducidos es de %.0f y la media es %f \n", media, media/GENERAR_NUMEROS);
		System.out.printf("La suma de todos los porcentajes es equivalente al %.2f%%. El %% medio para cada contador es de %.2f%%", mediaPorcentajes, mediaPorcentajes/10);
		
	}
}
