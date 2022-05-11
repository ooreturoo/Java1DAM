package objetos;

import java.time.LocalDate;

public class FicheroTextoPlano extends FicheroTexto {

	public FicheroTextoPlano(String nombre, int dimensionesContenido) {
		
		super(nombre, dimensionesContenido);
		
	}
	
	public FicheroTextoPlano(String nombre, LocalDate fechaCreacion,
			int dimensionesContenido) {
		
		super(nombre, fechaCreacion, dimensionesContenido);
		
	}
	
	public void leerFichero() {
		
		System.out.println("Contenido Fichero Texto Plano:");
		
		for(int i = 0; i < contenido.length; i++) {
			
			for(int j = 0; j < contenido[i].length; j++) {
				
				System.out.println(contenido[i][j]);
				
			}
		}
		
	}
	
}
