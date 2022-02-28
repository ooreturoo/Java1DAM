package r1_Ejercicio1;

public class Rectangulo {
	private int longitud;
	private int ancho;
	
	
	public Rectangulo() {
		this.longitud = 1;
		this.ancho = 1;
	}
	
	public int perimetroRectangulo() {
		return longitud + ancho;
	}
	
	public int areaRectangulo() {
		return longitud * ancho;
	}
	
	public void setLongitud(int longitud) {
		if(longitud > 0 && longitud < 20) {
			this.longitud = longitud;
		}else {
			System.out.println("El valor de longitud tiene que estar entre 1 y 20");
		}
		
	}
	
	public int getLongitud() {
		return this.longitud;	
	}
	
	public void setAncho(int ancho) {
		if(ancho > 0 && ancho < 20) {
			this.ancho = ancho;
		}else {
			System.out.println("El valor de ancho tiene que estar entre 1 y 20");
		}
	}
	
	public int getAncho() {
		return this.ancho;
	}
	
}
