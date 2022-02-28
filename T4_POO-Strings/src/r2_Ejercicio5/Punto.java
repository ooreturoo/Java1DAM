package r2_Ejercicio5;

public class Punto {
	private double x;
	private double y;
	
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public String toString() {
		return "(" + this.x + "." + this.y + ")";
	}
	
	
}
