package examen2020;

public class Ejercicio2 {
	private static int[][] jardin = {
		  {1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0},
		  {0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0},
		  {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4},
		  {0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1},
		  {0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3},
		  {4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0},
		  {1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
		  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
		  {3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0},
		  {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0},
		  {0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0},
		  {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0},
		  {0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0},
		  {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1},
		  {1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2}
		};
	public static void main(String[] args) {
		for(int i = 0; i < jardin.length; i++) {
			for(int j = 0; j < jardin.length; j++) {
				if(jardin[i][j] == 5) {
					comprobarAbeja(i, j);
				}
			}
		}
	}
	
	private static void comprobarCercanos(int i, int j) {
		boolean agua = false;
		boolean gusano = false;
		boolean hierba = false;
		
		for(int x = i-1; x <= i+1; x++) {
			if(x < 0 || x >= jardin.length) {
				continue;
			}
			for(int y = j-1; y <= j+1; y++) {
				if(y < 0 || y >= jardin.length) {
					continue;
				}
				if(jardin[x][y] == 2) {
					agua = true;
				}
				if(jardin[x][y] == 3) {
					hierba = true;
				}
				if(jardin[x][y] == 4) {
					gusano = true;
				}
				
			}
		}
		
		if((agua && !hierba) || (agua && hierba && gusano) ) {
			System.out.printf("La flor de la posición %d,%d florecerá\r\n", i, j);
		}
	}
	
	private static void comprobarAbeja(int i, int j) {
		for(int x = i-3; x <= i+3; x++) {
			if(x < 0 || x >= jardin.length) {
				continue;
			}
			for(int y = j-3; y <= j+3; y++) {
				if(y < 0 || y >= jardin.length) {
					continue;
				}
				if(jardin[x][y] == 1) {
					comprobarCercanos(x, y);
				}
			}
		}
	}

}
