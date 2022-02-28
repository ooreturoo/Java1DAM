package examenDescartado2021;

import java.util.Arrays;

public class Examen {
	private static String[] pilotos = { "M. Verstappen", "L. Hamilton", "V. Bottas", "S. Pérez", "Lando Norris",
			"Charles Leclerc", "C. Sainz Jr.", "D. Ricciardo", "Pierre Gasly", "F. Alonso", "Esteban Ocon", "S. Vettel",
			"Lance Stroll", "Yuki Tsunoda", "George Russell", "K. Raikkonen", "Nicholas Latifi", "Antonio Giovinazzi",
			"Mick Schumacher", "Nikita Mazepin" };
	private static int[][] tiempos = {
			{84570, 77339, 82181, 74394, 82304, 72632, 78487, 72292, 74549, 72098, 85859, 80729, 85131, 77889, 85768, 87849, 87537, 73941, 74719, 83535},
			{73685, 72807, 71678, 75660, 85241, 85691, 78105, 80115, 83779, 79941, 72473, 85248, 77727, 86788, 86677, 82230, 88960, 83327, 71852, 85043},
			{84451, 73867, 75221, 75250, 72372, 75382, 88702, 85325, 72858, 81747, 75408, 73580, 77389, 85394, 81220, 85806, 74344, 79707, 74335, 71475},
			{83865, 75959, 80632, 87045, 79190, 78780, 87066, 71569, 78633, 76787, 76388, 76741, 77884, 82631, 79646, 88679, 78560, 79580, 80871, 76511},
			{71703, 83561, 71017, 76562, 85218, 78739, 87342, 73773, 71252, 87896, 76060, 74202, 87109, 78453, 86955, 71298, 75618, 71700, 82344, 71711},
			{85794, 80694, 85730, 75100, 74180, 74553, 79521, 85900, 76692, 74022, 76342, 71828, 82476, 80297, 83102, 81286, 86727, 83454, 86608, 84331},
			{76753, 71365, 83942, 74748, 74122, 72737, 79624, 83996, 85385, 78002, 79555, 74454, 71181, 77021, 75545, 78286, 78159, 84693, 88562, 81655},
			{76659, 72457, 86241, 80529, 80477, 80698, 88209, 75852, 74913, 77126, 72574, 76957, 80579, 76390, 84400, 84188, 79420, 75488, 86129, 83816},
			{87838, 75466, 81824, 74279, 76975, 75260, 75646, 74654, 73889, 77264, 80390, 86026, 86338, 87737, 88826, 73048, 87103, 88125, 78984, 85031},
			{85171, 76497, 77051, 83560, 86765, 79904, 81230, 82431, 87856, 80166, 79867, 84217, 71893, 77167, 88466, 78441, 79003, 87879, 80197, 73617},
			{88398, 81742, 75824, 71577, 72948, 82218, 78422, 81407, 81748, 76745, 74630, 71388, 83522, 77585, 87324, 78463, 84821, 73046, 78036, 86488},
			{79306, 86376, 84986, 84947, 79537, 84661, 72457, 87454, 81845, 81586, 72930, 84617, 74938, 76546, 74668, 85465, 84046, 82304, 77273, 77113},
			{86257, 80415, 71727, 81839, 77329, 79372, 79157, 86358, 85838, 77308, 80823, 75484, 88717, 80279, 74466, 82570, 74312, 88001, 79941, 71947},
			{71922, 84929, 78936, 73339, 73737, 76112, 79398, 83550, 73380, 77551, 83318, 84523, 81483, 76149, 78872, 79011, 81637, 83540, 75066, 86161},
			{77932, 77927, 86346, 87375, 75582, 75674, 78102, 84290, 81069, 88726, 85487, 80868, 72457, 84296, 74156, 83084, 77951, 81996, 82619, 83132},
			{84376, 72267, 87826, 88647, 77332, 81934, 84260, 82637, 84594, 76126, 78015, 84020, 82627, 86810, 71554, 82404, 81952, 79636, 83723, 84319},
			{78692, 87097, 75566, 81340, 72420, 77306, 83458, 72911, 80752, 80667, 71606, 84278, 78145, 76264, 86129, 82066, 86930, 74527, 82743, 80448},
			{80251, 74174, 81207, 80691, 86104, 86698, 79969, 86272, 85528, 81769, 84773, 71078, 85745, 83836, 80503, 74936, 73665, 75549, 83470, 84008},
			{88080, 74737, 72859, 78945, 72513, 79753, 78807, 74641, 77431, 73963, 72886, 75457, 87748, 88648, 79303, 83123, 72445, 75226, 83645, 71447},
			{85034, 79064, 88454, 85993, 87042, 74540, 87281, 76362, 86733, 75261, 80862, 78890, 72175, 76706, 79410, 77245, 83683, 73321, 81488, 77417}
			};
	
	
	public static void main(String[] args) {
		ordenarPorTiempos();
		Imprimir();
	}
	
	
	/**
	 * Metodo principal que ordena los arrays por la posición en las que han quedado los corredores.
	 */
	private static void ordenarPorTiempos() {
		//Ordena cada array de tiempos de menor a mayor 
		for(int i= 0; i < tiempos.length; i++) {
			Arrays.sort(tiempos[i]);
			
		}
		
		//Recorre cada linea de la matriz  y la ordena en funcion del primer tiempo(El menor tiempo)
		for(int i= 0; i < tiempos.length; i++) {
			for(int j = 0; j < tiempos.length-1-i; j++){
				//Si el tiempo primero es mayor que el siguiente le cambiamos la posición.
				if(tiempos[j][0] > tiempos[j+1][0]) {
					ordenar(j);
				//En el caso que los tiempos sean iguales invocamos el metodod ordenarIguales.	
				}else if(tiempos[j][0] == tiempos[j+1][0]) {
					ordenarIguales(j);
				}
			}
				
		}
		
		
	}
	
	/**
	 * 
	 * @param posicion Recibe la posición en la que encuentra el primer tiempo igual que el siguiente
	 */
	private static void ordenarIguales(int posicion) {
		boolean iguales = true;
		boolean ordenado = false;
		int contIguales = 0;
		//Un bucle que cuenta la cantidad de corredores que tienen el mismo tiempo y lo suma al contador(contIguales).
		for(int i = posicion; i < tiempos.length-1 && iguales; i++) {
			if(tiempos[i][0] == tiempos[i+1][0]) {
				contIguales++;
			}else {
				iguales = false;//Si no son iguales se cambia el valor del booleano para salir del bucle.
			}
		}
		/*
		 * Recorremos la cantidad de elementos seguidos iguales y los vamos ordenando entre ellos, comprobando todos los tiempos hasta que
		 * acabe el bucle o se encuentre uno distinto y se ordene.
		 */
		for(int i= posicion; i < posicion+contIguales; i++) {
			for(int j = posicion; j < posicion+contIguales-i; j++) {
				for(int k = 1; k < tiempos.length && !ordenado; k++){
					if(tiempos[j][k] > tiempos[j+1][k]) {
						ordenar(j);
						ordenado = true;
					}
				}
			}
				
		}
	}
	
	/**
	 * Metodo encargado de cambiar las posiciones.
	 * @param j Posición del elemento a cambiar.
	 */
	private static void ordenar(int j) {
		int[]tiempoAux = new int[tiempos[0].length];
		String salidaPilotos = null;
		
		tiempoAux = tiempos[j];
		tiempos[j] = tiempos[j+1];
		tiempos[j+1] = tiempoAux;
		
		salidaPilotos = pilotos[j+1];
		pilotos[j+1] = pilotos[j];
		pilotos[j] = salidaPilotos;
		
	}
	
	/**
	 * Imprime la matriz. Posicion del corredor, nombre y tiempo.
	 */
	private static void Imprimir() {
		for(int i = 0; i < pilotos.length; i++) {
			System.out.println(i+1 + " - " + pilotos[i] + " - " + formatoTiempos(tiempos[i][0]));
		}
	}
	
	/**
	 * Pasa los milisegundos a segundos y minutos
	 * @param tiempo Parametro para recibir el tiempo en milisegundos que hay que transformar.
	 * @return
	 */
	private static String formatoTiempos(int tiempo) {
		int minutos = tiempo / 3600;
		int segundos = (tiempo % 3600) / 60 ;
		int milisegundos = tiempo % 60;
		
		return  minutos + ":" + segundos + ":" + milisegundos;
	}

}
