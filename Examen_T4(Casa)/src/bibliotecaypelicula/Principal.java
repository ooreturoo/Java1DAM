package bibliotecaypelicula;

import menu.FuncionesBiblioteca;
import menu.InterfazMenu;

public class Principal {
	
	public static final int CAPACIDAD_MAXIMA_BIBLIO = 1;
	
	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca(CAPACIDAD_MAXIMA_BIBLIO);
		
		boolean salirMenu = false;
		
		while(!salirMenu) {
			
			InterfazMenu.mostrarMenu();
			
			salirMenu = FuncionesBiblioteca.funcionamientoMenu(biblioteca);
		}
	}
}
