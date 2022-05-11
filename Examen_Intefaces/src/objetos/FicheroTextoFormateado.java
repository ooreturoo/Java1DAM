package objetos;

import java.time.LocalDate;

import interfaces.Analizable;
import interfaces.Convertible;

public class FicheroTextoFormateado extends FicheroTexto implements Convertible, Analizable {

	private String tipoFuente;
	private int dimensionesFuente;
	private String colorFuente;
	
	public FicheroTextoFormateado(String nombre, LocalDate fechaCreacion, int dimensionesContenido,String tipoFuente, int dimensionesFuente,
			String colorFuente) {

		super(nombre, fechaCreacion, dimensionesContenido);
		
		this.tipoFuente = tipoFuente;
		this.dimensionesFuente = dimensionesFuente;
		this.colorFuente = colorFuente;
		
		
		
	}
	
	public FicheroTextoFormateado(String nombre,String tipoFuente, int dimensionesContenido,
			int dimensionesFuente, String colorFuente) {

		super(nombre,dimensionesContenido);
		
		this.tipoFuente = tipoFuente;
		this.dimensionesFuente = dimensionesFuente;
		this.colorFuente = colorFuente;
		
	}
	

	
	@Override
	public String convertir() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < contenido.length; i++) {
			
			for(int j = 0; j < contenido[i].length; j++) {
				
				if(contenido[i][j] != null) {
					
					sb.append(contenido[i][j]);
					
				}
				
			}
			
		}
		
		return sb.toString();
		
	}
	
	@Override
	public void analizar() {
		
		System.out.println("Analizando " + getNombre());
		
	}

	public String getTipoFuente() {
		return tipoFuente;
	}

	public void setTipoFuente(String tipoFuente) {
		this.tipoFuente = tipoFuente;
	}

	public int getDimensionesFuente() {
		return dimensionesFuente;
	}

	public void setDimensionesFuente(int dimensionesFuente) {
		this.dimensionesFuente = dimensionesFuente;
	}

	public String getColorFuente() {
		return colorFuente;
	}

	public void setColorFuente(String colorFuente) {
		this.colorFuente = colorFuente;
	}


}
