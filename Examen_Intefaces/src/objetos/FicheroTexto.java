package objetos;

import java.time.LocalDate;


public abstract class FicheroTexto extends Fichero {

	private final static int COLUMNAS_CONTENIDO = 1;
	
	protected String[][] contenido;
	
	public FicheroTexto(String nombre,int dimensionesContenido) {
		
		super(nombre);
		
		this.contenido = new String[dimensionesContenido][COLUMNAS_CONTENIDO];
		
	}
	
	public FicheroTexto(String nombre, LocalDate fechaCreacion,	int dimensionesContenido) {
		
		super(nombre, fechaCreacion);
		
		this.contenido = new String[dimensionesContenido][COLUMNAS_CONTENIDO];
		
	}
	
	@Override
	public double calcularDimension() {
		
		int dimension = 0;
		
		for(int i = 0; i < contenido.length; i++) {
			
			for(int j = 0; j < contenido[i].length; j++) {
				
				if(contenido[i][j] != null) {
					
					dimension += contenido[i][j].length();
					
				}
				
			}
			
		}
		
		return dimension;
	}
	

	public String[][] getContenido() {
		return contenido;
	}

	public void setContenido(String[][] contenido) {
		this.contenido = contenido;
	}



	
}
