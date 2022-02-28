package paquete1;

import java.util.ArrayList;

import excepciones.ExcepcionDescuento;

public class Proveedor {

	private ArrayList<Productos> productos;
	private static final int DESCUENTO_MAX = 25;
	private int descuentoProveedor;
	
	public Proveedor(int descuentoProveedor) throws ExcepcionDescuento {
		
		this.productos = new ArrayList<Productos>();
		
		productos.add(Productos.BOLLO);
		productos.add(Productos.LITROACEITE);
		productos.add(Productos.TABLETACHOCOLATE);
		if(descuentoProveedor > DESCUENTO_MAX || descuentoProveedor < 0) {
			throw new ExcepcionDescuento();
		}else {
			this.descuentoProveedor = descuentoProveedor;
		}
		
	}
	
	public float calcularPresupuesto(Productos producto, int cantidadProducto) {
		float descuento = calculoDescuento(producto.getPrecio());
		if(producto.equals(Productos.LITROACEITE)) {
			cantidadProducto = ConvertidorCantidades.litroAceite(cantidadProducto);
		}else if(producto.equals(Productos.TABLETACHOCOLATE)) {
			cantidadProducto = ConvertidorCantidades.obtenerTabletas(cantidadProducto);
		}
		
		return producto.getPrecio()*cantidadProducto - descuento;
	}
	
	
	private float calculoDescuento(float precioProducto) {
		float descuento = 0;
		
		descuento = (precioProducto / this.descuentoProveedor)*100;
		
		return descuento;
		
	}

	public static int getDescuentoMax() {
		return DESCUENTO_MAX;
	}

	public ArrayList<Productos> getProductos() {
		return productos;
	}
	
	
	
	
}
