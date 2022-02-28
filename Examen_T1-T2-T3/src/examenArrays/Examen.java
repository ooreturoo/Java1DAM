package examenArrays;

import java.util.Scanner;

public class Examen {
	private static final int FILAS = 6;	//Establece el número de filas de la matriz.
	private static final int COLUMNAS = 7;//Establece el número de columnas de la matriz.
	private static int fichasTotales = 42;//Establece el total de fichas que tiene el juego.
	//Variable que identifica si alguien ha ganado el juego.
	private static boolean fichasConectadas = false;
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		char[][] tablero = new char[FILAS][COLUMNAS];//Crea la matriz.
		boolean juegoAcabado = false;//Identifica cuando el juego ha acabado. Sirve como condición para el búcle.
		
		/*
		 * Si el juego no ha acabado y nadie ha conectado las 4 fichas, el juego irá transcurriendo con 
		 * este búcle.
		 */
		while(!juegoAcabado && !fichasConectadas) {
			boolean fichaIntroducida;//Permite saber si la ficha ha sido introducida con exito.
			
			/*
			 * Comprueba si quedan fichas en el juego. Si no quedan, cambia el valor de juegoAcabado, para
			 * que salga del búcle y acabe el juego. Si quedan, deja seguir el transcurso del juego.
			 */
			
			if(fichasTotales == 0) {
				juegoAcabado = true;
			}else {
				
				/*
				 * Comienza el primer jugador, al que se le pide que introduzca la columna donde quiere
				 * introducir la ficha, si la ficha no se ha podido introducir, se repetira hasta que introduzca
				 * una columna válida.
				 */
				do {
				
					System.out.println("Jugador A(A), introduce la columna donde introducir la ficha.(1-7)");
					//Llama al método con el tablero, la columna introducida por el jugador y el jugador que es.
					fichaIntroducida = insertarFichas(tablero, Integer.parseInt(scan.nextLine()) -1, 'A');
					
				}while(!fichaIntroducida);
				
				muestraTablero(tablero);//Muestra el tablero de juego.
				
				/*
				 * Comprueba si el primer jugador ha conectado antes las fichas, si es así al segundo jugador ya
				 * no se le deja introducir ficha.
				 */
				
				if(!fichasConectadas) {
					do {
						
						System.out.println("Jugador B(B), introduce la columna donde introducir la ficha.(1-7)");
						//Llama al método con el tablero, la columna introducida por el jugador y el jugador que es.
						fichaIntroducida = insertarFichas(tablero,Integer.parseInt(scan.nextLine()) -1, 'B');
						
					}while(!fichaIntroducida);
					
					muestraTablero(tablero);//Muestra el tablero de juego.
				}
				
				
			}
	
		}
		
		if(juegoAcabado) {
			System.out.println("Se acabaron las fichas, el juego ha terminado.");
		}
		
	}
	
	
	/**
	 * Método encargado de verificar si se puede introducir la ficha en la columna introducida por el usuario.
	 * @param tablero Recibe el tablero de juego.
	 * @param columna Recibe la columna en la que el usuario quiere meter la ficha.
	 * @param jugador Recibe el jugador al que pertenece la ficha.
	 * @return Devuelve true si se ha podido introducir la ficha y false en caso contrario.
	 */
	private static boolean insertarFichas(char[][] tablero, int columna, char jugador) {
		
		boolean fichaIntroducida = false;
		
		//Si el valor introducido por el usuario está fuera de los limites, se le avisa.
		if(columna < 0 || columna > 7) {
			System.out.println("Las coordenadas introducidas no son válidas, intentalo de nuevo.");
			
			//Si el valor introducido por el usuario ya está ocupado, se le avisa.
		}else if(tablero[0][columna] != '\u0000') {
			System.out.println("La columna esta llena");
		}else {
			
			int fila = FILAS-1;//Variable que sirve para recorrer las filas.
			
			/*
			 * Mientras que la ficha no haya sido introducida, ira aumentando la fila en la que tiene que
			 * introducirse, hasta que logre hacerlo.
			 * El búcle acabara siempre, ya que las opciones para que no llegue a introducirse se descartan 
			 * anteriormente.
			 */
			while (!fichaIntroducida) {
				/*
				 * Comprueba si la fila está vacía, si lo esta introduce al ficha, resta a ficha de las fichas
				 * totales, y cambia el valor de la variable encargada de comunicar que la ficha ha sido introducida.
				 * Si no, resta una fila y prueba en la siguiente.
				 */
				if(tablero[fila][columna] == '\u0000') {
					tablero[fila][columna] = jugador;
					fichasTotales--;
					fichaIntroducida = true;
					//Comprueba si con la ficha introducida, se conectan 4.
					comprobarFichasConectadas(tablero, fila, columna, jugador);
				}else {
					fila--;
				}
			}
		}
		
		return fichaIntroducida;
	}
	
	
	/**
	 * Comprueba si alguien a conectado las 4 fichas.
	 * @param tablero Recibe el tablero.
	 * @param fila Recibe la posición en la fila de la ultima ficha que se ha introducido.
	 * @param columna Recibe la posición de la columna de la ultima ficha que se ha introducido.
	 * @param jugador Recibe el jugador al que pertenece la ficha.
	 */
	private static void comprobarFichasConectadas(char[][] tablero, int fila, int columna,char jugador) {
		int contFichas = 1;//Cuenta las fichas seguidas del mismo jugador.
		boolean fichaContraria = false;//Avisa si una ficha del jugador contrario interrumpe la conexión.
		
		/*
		 * Si la fila en la que se ha introducido esta en la 4 posición o más contando desde abajo,
		 * comprobara tres fichas más hacia abajo si hay fichas del mismo jugador.
		 */
		if(fila < 3) {
			for(int x = fila +3; x > fila && !fichaContraria; x--) {
				/*
				 * Si la ficha es del mismo jugador suma al contador, en caso contrario cambia el valor de al variable
				 * para salir del bucle y devuelve el contador a 1;.
				 */
				if(tablero[x][columna] == jugador) {
					contFichas++;
				}else {
					fichaContraria = true;
					contFichas = 1;
				}
			}
		}
		
		fichaContraria = false;//Reestablece el valor a al variable para que compruebe el siguiente bucle.
		
		
		for(int x = columna-3; x < columna && !fichaContraria && contFichas!= 4; x++) {
			if(x < 0 || x >= COLUMNAS || x == columna ) {
				continue;
			}
			/*
			 * Si la ficha es del mismo jugador suma al contador, en caso contrario cambia el valor de al variable
			 * para salir del bucle y devuelve el contador a 1;.
			 */
			if(tablero[fila][x] == jugador) {
				contFichas++;
			}else {
				fichaContraria = true;
				contFichas = 1;
			}
		}
		
		fichaContraria = false;//Reestablece el valor a al variable para que compruebe el siguiente bucle.
		
		for(int x = columna+3; x > columna && !fichaContraria && contFichas!= 4; x--) {
			if(x < 0 || x >= COLUMNAS || x == columna ) {
				continue;
			}
			/*
			 * Si la ficha es del mismo jugador suma al contador, en caso contrario cambia el valor de al variable
			 * para salir del bucle y devuelve el contador a 1;.
			 */
			if(tablero[fila][x] == jugador) {
				contFichas++;
			}else {
				fichaContraria = true;
				contFichas = 1;
			}
		}
	
		/*
		 * Si se han contado 4 fichas conectadas, se cambia el valor de la variable estática para que acabe el juego
		 * y se muestra un mensaje al ganador por pantalla.
		 */
		 
		if(contFichas == 4) {
			fichasConectadas = true;
			System.out.println("¡Felicidades, Jugador " + jugador + " has ganado el juego!");
		}
		
	}
	
	/**
	 * Se encarga de imprimir el tablero.
	 */
	private static void muestraTablero(char[][] tablero) {
		for(int i = 0; i < FILAS; i++) {
			for(int j = 0; j < COLUMNAS; j++) {
				if(tablero[i][j] == '\u0000') {
					System.out.print("| |");
				}else {
					System.out.print("|" + tablero[i][j] + "|");
				}
				
			}
			System.out.println();
		}
	}
	
}
