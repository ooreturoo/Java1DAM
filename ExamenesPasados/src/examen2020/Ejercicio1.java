package examen2020;

public class Ejercicio1 {
	private static String[] estados = { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Carolina del Norte",
			"Carolina del Sur", "Colorado", "Connecticut", "Dakota del Norte", "Dakota del Sur", "Delaware",
			"Distrito de Columbia", "Florida", "Georgia", "Hawái", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
			"Kentucky", "Luisiana", "Maine", "Maryland", "Massachusetts", "Míchigan", "Minnesota", "Mississippi",
			"Misuri", "Montana", "Nebraska", "Nevada", "Nueva Jersey", "Nueva York", "Nuevo Hampshire", "Nuevo México",
			"Ohio", "Oklahoma", "Oregón", "Pensilvania", "Rhode Island", "Tennessee", "Texas", "Utah", "Vermont",
			"Virginia", "Virginia Occidental", "Washington", "Wisconsin", "Wyoming" };
	private static int[] electores = { 9, 3, 11, 6, 55, 15, 9, 9, 7, 3, 3, 3, 3, 29, 16, 4, 4, 20, 11, 6, 6, 8, 8, 4,
			10, 11, 16, 10, 6, 10, 3, 5, 6, 14, 29, 4, 5, 18, 7, 7, 20, 4, 11, 38, 6, 3, 13, 5, 12, 10, 3 };
	private static int[] votosDemocratas = { 729547, 116454, 1161167, 380494, 8753788, 1338870, 897572, 235603, 282830,
			4504975, 1877963, 266891, 189765, 3090729, 1033126, 653669, 427005, 628854, 780154, 715326, 1677928,
			1995196, 2268839, 1367716, 485131, 1071068, 177709, 568988, 539260, 348526, 2148278, 385234, 4556124,
			2189316, 93758, 2394164, 420375, 1002106, 2926441, 252525, 855373, 117458, 870695, 3877868, 310676, 178573,
			1981473, 1742718, 188794, 1382536, 55973 };
	private static int[] votosRepublicanos = { 1318255, 163387, 1252401, 684872, 4483810, 1202484, 673215, 185127,
			12723, 4617886, 2089104, 128847, 409055, 2146015, 1557286, 800983, 671018, 1202971, 1178638, 671154, 943169,
			1090893, 2279543, 1322951, 700714, 1594511, 279240, 991922, 512058, 345790, 1601933, 319667, 2819534,
			2362631, 216794, 2841005, 949136, 782403, 2970733, 180543, 1155389, 227721, 1522925, 4685047, 515231, 95369,
			1769443, 1221747, 489371, 1405284, 174419 };

	
	public static void main(String[] args) {
		// Iniciamos todas las variables que vamos a necesitar.
		int totalElectoresDemocratas = 0;
		int totalElectoresRepublicanos = 0;
		long totalVotosDemocratas = 0;
		long totalVotosRepublicanos = 0;
		int totalEstadosDemocratas = 0;
		int totalEstadosRepublicanos = 0;
		int maxElectoresDemocratas = 0;
		int maxElectoresRepublicanos = 0;
		String estadoDemocrata = null;
		String estadoRepublicano = null;

		// Abrimos un búcle for que se encargara de recorrer todos los arrays.
		for (int i = 0; i < estados.length; i++) {
			// Aqui averiguamos el total de votos que obtienen los democratas y el de los republicanos.
			totalVotosDemocratas += votosDemocratas[i];
			totalVotosRepublicanos += votosRepublicanos[i];

			// Averiguamos quien ha obtenido más votos en cada estado, el que más votos haya obtenido en ese estado obtiene todos los electores.
			if (votosDemocratas[i] > votosRepublicanos[i]) {
				totalElectoresDemocratas += electores[i];
				totalEstadosDemocratas++;//Averiguamos la cantidad de estados que han votado a los democratas.
				if(maxElectoresDemocratas < electores[i]) {
					maxElectoresDemocratas = electores[i];
					estadoDemocrata = estados[i];
				}
			} else {
				totalElectoresRepublicanos += electores[i];
				totalEstadosRepublicanos++;//Averiguamos la cantidad de estados que han votado a los republicanos.
				if(maxElectoresRepublicanos < electores[i]) {
					maxElectoresRepublicanos = electores[i];
					estadoRepublicano = estados[i];
				}
			}
			
		}
		
		//Imprimimos de que partido es el presidente elegido.
				if (totalElectoresDemocratas > totalElectoresRepublicanos) {
					System.out.println("El presidente es del partido Democrata");
				} else {
					System.out.println("El presidente es del partido Republicano");
				}
		
		//Imprimimos el númeto total de electores.
		System.out.printf("El número total de electores que obtienen ambos partidos es de %d\n",
				(totalElectoresDemocratas + totalElectoresRepublicanos));
		
		//Imprimimos el partido que más votos ha obtenido y de que cantidad de votos.
		if (totalVotosDemocratas > totalVotosRepublicanos) {
			System.out.printf("El partido Democrata ha sido el más votado con %d de %d votos totales\n",
					totalVotosDemocratas, (totalVotosDemocratas + totalVotosRepublicanos));
		} else {
			System.out.printf("El partido Republicano ha sido el más votado con %d de %d votos totales\n",
					totalVotosRepublicanos, (totalVotosDemocratas + totalVotosRepublicanos));
		}
		
		//Imprimimos el número de estados que apoyan a cada partido.
		System.out.printf("Hay %d estados que apoyan a los democratas\n", totalEstadosDemocratas );
		System.out.printf("Hay %d estados que apoyan a los republicanos\n", totalEstadosRepublicanos );
		
		//Imprimimos los estados con más electores han aportado a cada partido.
		System.out.printf("El estado de %s ha aportado %d electores a los democratas\n", estadoDemocrata, maxElectoresDemocratas);
		System.out.printf("El estado de %s ha aportado %d electores a los republicanos\n", estadoRepublicano, maxElectoresRepublicanos);
		
	}
}
