package paquete1;

import java.util.Scanner;

import excepciones.ExcepcionDescuento;

public class Principal {
	
	private static final Scanner SCAN = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		Proveedor proveedores[] = new Proveedor[3];
		
		for(int i = 0; i < proveedores.length; i++) {
			
			boolean descValido = false;
			
			while(!descValido) {
				System.out.println("Introduce el descuento del Proveedor nº" + i);
				try {
					proveedores[i] = new Proveedor(Integer.parseInt(SCAN.nextLine()));
					descValido = true;
				} catch (NumberFormatException e) {
					System.out.println("Debes introducir un número");
				} catch (ExcepcionDescuento e) {
					System.out.println(e);
				}
			}
		}
		
		Instituto instituto = new Instituto(1000, 5201.54f, 75, 4);
		
		
		boolean proveedorValido = false;
		int nProveedor = 0;
		while(!proveedorValido) {
			System.out.println("Introduce el proveedor del que obtener el presupuesto.");
			try {
				nProveedor = Integer.parseInt(SCAN.nextLine());
				if(nProveedor <= 3 || nProveedor > 0) {
					proveedorValido = true;
				}else {
					System.out.println("Número de proovedor invalido.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Tienes que introducir un número.");
			}
			
		}
		Proveedor proveedor = proveedores[nProveedor - 1];
		
		float presupuesto = proveedor.calcularPresupuesto(proveedor.getProductos().get(0), instituto.getNumAlumnos());
		presupuesto += proveedor.calcularPresupuesto(proveedor.getProductos().get(1), instituto.totalMililitros());
		presupuesto += proveedor.calcularPresupuesto(proveedor.getProductos().get(2), instituto.totalOnzas());
		
		if(instituto.esFactible(presupuesto)) {
			System.out.println("Es factible.");
		}else {
			System.out.println("No es factible.");
		}
		
		
		
	}
}
