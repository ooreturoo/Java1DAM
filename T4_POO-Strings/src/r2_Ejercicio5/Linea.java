package r2_Ejercicio5;

import java.util.Objects;

public class Linea {
	private Punto puntoA;
	private Punto puntoB;
	
	public Linea() {
		this.puntoA = new Punto();
		this.puntoB = new Punto();
	}
	
	public Linea(Punto puntoA, Punto puntoB) {
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}
	
	public void moverDerecha(double coordenada) {
		
		puntoA.setX(puntoA.getX() + coordenada);
		puntoB.setX(puntoB.getX() + coordenada);
	}
	
	public void moverIzquierda(double coordenada) {
		
		puntoA.setX(puntoA.getX() - coordenada);
		puntoB.setX(puntoB.getX() - coordenada);
	}
	
	public void moverArriba(double coordenada) {
		
		puntoA.setY(puntoA.getY() + coordenada);
		puntoB.setY(puntoB.getY() + coordenada);
	}
	
	public void moverAbajo(double coordenada) {
		
		
		puntoA.setY(puntoA.getY() - coordenada);
		puntoB.setY(puntoB.getY() - coordenada);
	}
	
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("[");
		bf.append(this.puntoA);
		bf.append(",");
		bf.append(this.puntoB);
		bf.append("]");
		return bf.toString();
		
		
	}
	

	public Punto getPuntoA() {
		return puntoA;
	}

	public Punto getPuntoB() {
		return puntoB;
	}

	public void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}

	public void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}

	@Override
	public int hashCode() {
		return Objects.hash(puntoA, puntoB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linea other = (Linea) obj;
		return Objects.equals(puntoA, other.puntoA) && Objects.equals(puntoB, other.puntoB);
	}
	
}
