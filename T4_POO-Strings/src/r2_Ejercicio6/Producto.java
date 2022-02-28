package r2_Ejercicio6;

public class Producto {
	private static int contadorProductos;
	private int idProducto;
	private String nombre;
	private String descripcion;
	private double precioSinIVA;
	private double precioTotal;
	
	
	public Producto(String nombre, String descripcion,double precioSinIVA) {
		contadorProductos++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioSinIVA = precioSinIVA;
		this.idProducto = Producto.contadorProductos;
		calcPecioTotal();
	}
	
	public void calcPecioTotal() {
		this. precioTotal = this.precioSinIVA + (this.precioSinIVA * 0.2);
	}

	public int getIdProducto() {
		return idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioSinIVA() {
		return precioSinIVA;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecioSinIVA(double precioSinIVA) {
		this.precioSinIVA = precioSinIVA;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [idProducto=");
		builder.append(idProducto);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", precioSinIVA=");
		builder.append(precioSinIVA);
		builder.append(", precioTotal=");
		builder.append(precioTotal);
		builder.append("]");
		return builder.toString();
	}
	
	
}
