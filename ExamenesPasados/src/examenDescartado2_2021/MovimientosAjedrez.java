package examenDescartado2_2021;

import java.util.Scanner;

/*
 * Queremos tener un sistema que dado un tablero de ajedrez, y una coordenada concreta, nos indique cuáles son los movimientos posibles de la pieza que ocupa dicha coordenada. El tablero se pasará por parámetro, al igual que la posición de la pieza. 
Ejemplo:

posiblesMovimientos(tablero, fila, columna);

Para simplificar, las fichas serán sustituidas por números que las representarán:
Los peones serán un 1
Las torres un 2
Los caballos un 3
Los alfiles un 4
La reina un 5
El rey un 6
En caso de que en esa posición del tablero no haya pieza, se representará con un 0
Detrás del número tendrán una letra (B/N) que representará el color de dicha pieza

    El tablero por tanto será una matriz de números de tamaño 8x8. 
Este ejercicio se puede hacer por partes, ya que cada pieza se mueve de una manera distinta. 
Imaginemos el siguiente tablero (jugada inicial):

2B	3B	4B	5B	6B	4B	3B	2B
1B	1B	1B	1B	1B	1B	1B	1B
0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0
0	0	0	0	0	0	0	0
1N	1N	1N	1N	1N	1N	1N	1N
2N	3N	4N	5N	6N	4N	3N	2N


La siguiente llamada:
posiblesMovimientos (tablero, 1, 1) //Tener en cuenta que la numeración aquí la hacemos por índice, no por numeración del tablero original.

Daría como resultado: (2,1) // los índices (2,1) pues es un peón que solo puede moverse hacia adelante.

Sobre el mismo tablero, la llamada:
posiblesMovimientos (tablero, 0, 1) //Caballo negro

Daría como resultado: [(0,3), (2,3)]

La llamada:
posiblesMovimientos (tablero, 0, 4) // Rey negro

Daría como resultado: “No existen movimientos posibles para esta pieza”.


Para el siguiente tablero:


2B	3B	4B	5B	6B	4B	3B	2B
1B	0	1B	1B	1B	1B	1B	1B
0	0	0	0	0	0	0	0
0	1B	0	0	0	0	0	0
0	0	0	0	0	0	0	0
3N	0	0	0	0	0	0	0
1N	1N	1N	1N	1N	1N	1N	1N
2N	0	4N	5N	6N	4N	3N	2N


La llamada:
posiblesMovimientos (tablero, F, 1) // Caballo blanco

Daría como resultado: [D2, H2, E3]

Supondremos:
Un tablero que siempre es válido
Utilizaremos métodos estáticos si todavía no se conocen los conceptos de objetos.

 */

public class MovimientosAjedrez {
	
	// Posición de la letra A (mayúscula) en el código ascii
	static final int indiceASCII_A = 65;
	static final String NO_HAY_FICHA = "0";
	static final String PIEZA_BLANCA = "B";
	static final String PIEZA_NEGRA = "N";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] tablero = {
				{"2B","3B","4B","5B","6B","4B","3B","2B"},
				{"1B","1B","1B","1B","1B","1B","1B","1B"},
				{"0","0","0","0","0","0","0","0"},
				{"0","0","0","0","0","0","0","0"},
				{"0","0","0","0","0","0","0","0"},
				{"0","0","0","0","0","0","0","0"},
				{"1N","1N","1N","1N","1N","1N","1N","1N"},
				{"2N","3N","4N","5N","6N","4N","3N","2N"}
		};
		
		/*
		 * Otro tablero para probar
		String[][] tablero = {
				{"2B","3B","4B","5B","6B","4B","3B","2B"},
				{"1B","0","1B","1B","1B","1B","1B","1B"},
				{"0","0","0","0","0","0","0","0"},
				{"0","1B","0","0","0","0","0","0"},
				{"0","0","0","0","0","0","0","0"},
				{"3N","0","0","0","0","0","0","0"},
				{"1N","1N","1N","1N","1N","1N","1N","1N"},
				{"2N","0","4N","5N","6N","4N","3N","2N"}
		};
		*/
		
		boolean posicionValida = false;
		// Las letras y los números del tablero
		int letra;
		int numero;
		
		do {
			System.out.println("Este es el tablero: ");
			muestraTablero(tablero);
			
			System.out.print("Introduce la posición de la pieza de la que quieres ver los movimientos (ej: A3): ");
			String posicion = sc.nextLine().toUpperCase();
			
			letra = (int)posicion.charAt(0) - indiceASCII_A;
			numero = Integer.parseInt(colorDePieza(posicion));
			
			// Número comenzaba en 1 en el tablero, pero aquí debe empezar en 0. Restamos 1
			numero--;
			
			posicionValida = (letra >= 0 && letra < tablero.length && numero >= 0 && numero < tablero.length);
			
			if (!posicionValida) {
				System.out.println("Posición no válida. El tablero es de 8x8. Las filas de la \"a\" a la \"h\" y las columnas del 1 al 8");
			}
			
			// Además, la posición no será válida hasta que no seleccione una casilla donde haya una pieza
			if (posicionValida && tablero[letra][numero].equals(NO_HAY_FICHA)) {
				// La posición era correcta pero en esa casilla no hay una ficha
				System.out.println("En esa posición no hay fichas. Este es el tablero:");
				muestraTablero(tablero);
				posicionValida = false;
			}
			
		} while (!posicionValida);
		
		// Cerramos el escáner
		sc.close();
		
		// Ya tenemos la posición seleccionada. Comprobamos ahora sobre el tablero los posibles movimientos
		posiblesMovimientos(tablero, letra, numero);
	}
	
	public static void posiblesMovimientos(String[][] tablero, int i, int j) {
		int tipoPieza;
		
		
		// Nota: en este momento no se conocen las excepciones, por lo que no se pide que
		// se controle el posible error del parseInt
		tipoPieza = Integer.parseInt(tablero[i][j].substring(0, 1));
		
		switch (tipoPieza) {
		case 1:
			// La pieza es un peón
			movimientosPeon(tablero, i, j);
			break;
		case 2:
			// La pieza es una torre
			break;
		case 3:
			// La pieza es un caballo
			break;
		case 4: 
			// La pieza es un alfil
			break;
		case 5:
			// La pieza es una reina
			break;
		case 6:
			// La pieza es un rey
			break;
		default:
			System.out.println("Se encontró una pieza inesperada");
		}
	}
	
	public static void movimientosPeon(String[][] tablero, int i, int j) {
		// Vamos a suponer un número máximo de movimientos de 10
		int[][] posiblesMovimientos = new int[10][2];
		
		/*
		 * Llenaremos el array de posibles movimientos con -1.
		 * Así, al mostrarlos, sabremos que ya no hay más movimientos posibles
		 * en el array
		 */
		for (int x = 0; x < posiblesMovimientos.length; x++) {
			for (int y = 0; y < posiblesMovimientos[x].length; y++) {
				posiblesMovimientos[x][y] = -1;
			}
		}
		
		int numMovimientos = 0;
		
		String colorPieza = colorDePieza(tablero[i][j]);
		
		// Nota: vamos a obviar si es o no el primer movimiento, por lo que si avanza de frente, avanzará 1 posición
		
		/* 
		 * En este caso, los peones avanzan en una dirección: los negros hacia arriba 
		 * y los blancos hacia abajo. Entiéndase: los blancos en orden creciente de fila
		 * (del índice 1 al 7), y los negros en orden decreciente (del 6 al 0)
		 * Avance nos servirá en este caso para sumar, sin importar la dirección
		 */
		
		int avance = 1;
		
		if (colorPieza.equals(PIEZA_NEGRA)) {
			avance = -1;
		}
			
		/*
		 * 
		 *  El peón puede hacer 2 movimientos: o avanza hacia adelante si la casilla está vacía,
		 *  o avanza 1 en diagonal si hay una pieza del color contrario en una de sus diagonales 
		 *  (a una distancia de 1, no más)
		 *
		 *  Tenemos que controlar que los índices estén dentro del tablero: desde 0 hasta el tamaño del tablero -1
		 *  Vamos a comprobar las 3 casillas de la siguiente fila que están a un índice de distancia
		 *	[  0,  0, 1B, 0 , ... 
		 *	[  0,  x,  y,  z, ...
		 *
		 *  En el ejemplo anterior, para la pieza 1B sólo tendré que comprobar las casillas 'x', 'y' y 'z', pues 
		 *  son los únicos movimientos posibles. Esto se traduce, para una pieza que está en la posición i,j, 
		 *  en comprobar las posiciones i+1,j-1 ;  i+1,j  ;  i+1,j+1
		 *  Siempre y cuando dichas posiciones estén dentro de los límites del tablero
		 */
		
		// tj es una variable auxiliar que irá cambiando su valor entre los valores posibles que miraremos:
		// j-1, j y j+1
		// ti será el resultado de sumar o restar una fila a la fila actual, dependiendo si la ficha es
		// blanca o negra
		int ti = i + avance;
		for (int tj = j - 1; tj <= j+1 && tj < tablero.length; tj++) {
			if (tj >= 0) {
				if (tj == j) {
					if (tablero[ti][tj].equals("0")) {
						posiblesMovimientos[numMovimientos][0] = ti;
						posiblesMovimientos[numMovimientos][1] = tj;
						numMovimientos++;
					}
				}
				else if (!tablero[ti][tj].equals("0") && !colorDePieza(tablero[ti][tj]).equals(colorPieza)) {
					/*
					 * En el caso de que exista una pieza del otro color en una diagonal.
					 * Nota que estamos cogiendo el último caracter del contenido de la celda (que si hay 
					 * una pieza debería ser la letra que marca el color), y comprobando que sea del otro color
					 * (nota que miramos haya una pieza en la diagonal y que no sea del mismo color que la nuestra)
					 */
					posiblesMovimientos[numMovimientos][0] = ti;
					posiblesMovimientos[numMovimientos][1] = tj;
					numMovimientos++;
				}
				
			}
		}
		
		// Por último mostramos los movimientos posibles
		mostrarPosiblesMovimientos(posiblesMovimientos);
		
	}
	
	private static String colorDePieza(String contenidoCasilla) {
		return contenidoCasilla.substring(1, 2);
	}
	
	public static void mostrarPosiblesMovimientos(int[][] movimientos) {
		System.out.println("Los posibles movimientos son: ");
		for (int i = 0; i < movimientos.length; i++) {
			if (movimientos[i][0] != -1) {
				if (i > 0) {
					System.out.print(", "); 
				}
				System.out.print((char)(movimientos[i][0] + indiceASCII_A));
				System.out.print(movimientos[i][1] + 1);
			}
		}
	}
	
	public static void muestraTablero(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.printf("%2s ", tablero[i][j]);
				// Si hemos llegado al último elemento de la fila, saltamos a la fila siguiente
				if (j == (tablero.length - 1)) {
					System.out.println("");
				}
			}
		}
	}

}
