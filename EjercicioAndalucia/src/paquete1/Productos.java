package paquete1;

public enum Productos {
	
	BOLLO(0.5f),
	LITROACEITE(1.75f),
	TABLETACHOCOLATE(2.10f,10);
	
	private float precio;
	private int onzasChocolate;
	
	private Productos(float precio) {
		this.precio = precio;
	}
	private Productos(float precio, int onzasChocolate) {
		this.onzasChocolate = onzasChocolate;
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}
	public int getOnzasChocolate() {
		return onzasChocolate;
	}

	

	
	
	
}
