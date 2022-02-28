package r2_Ejercicio7;

import Leer.Leer;

public class Jarra {
	private static final int CAPACIDAD = 7;
	private static int litrosLlenados;
	private int ocupado;
	
	private Jarra(int ocupado) {
		litrosLlenados += ocupado;
		this.ocupado = ocupado;
	}
	
	public static Jarra crearJarra(char jarra) {
		boolean cantidadValida = false;
		int llenar = 0;
		
		while(!cantidadValida) {
			llenar = Leer.lecturaInt("Introduce los litros con los que desea llenar la jarra " + jarra);
			if(llenar >= 0 && llenar <= CAPACIDAD) {
					cantidadValida = true;	
			}else {
				System.out.println("Cantidad indicada inválida.");
			}
		}
		
		return new Jarra(llenar);
	}
	
	
	public void llenarJarra() {
		litrosLlenados += CAPACIDAD-this.ocupado;
		this.ocupado = CAPACIDAD;
	}
	
	public void vaciarJarra() {
		this.ocupado = 0;
	}
	
	public void volcarJarra(Jarra jarra) {
		int cantidadNecesaria = CAPACIDAD - this.ocupado;
		
		if(cantidadNecesaria == 0) {
			
			System.out.println("La jarra ya está llena.");
			
		}else if(jarra.ocupado == 0) {
			
			System.out.println("No se puede volcar una jarra vacía.");
			
		}else if(cantidadNecesaria <= jarra.ocupado) {
			this.ocupado += cantidadNecesaria;
			jarra.ocupado -= cantidadNecesaria;
			System.out.println("Se ha volcado correctamente.");
		}else if(cantidadNecesaria > jarra.ocupado) {
			this.ocupado += jarra.ocupado;
			jarra.ocupado = 0;
			System.out.println("Se ha volcado correctamente.");
		}	
	}
	
	public static void estadoJarras(Jarra jarra1, Jarra jarra2) {
		System.out.println("La jarra A tiene " + jarra1.ocupado + " litros");
		System.out.println("La jarra B tiene " + jarra2.ocupado + " litros");
		
	}

	public static int getLitrosLlenados() {
		return litrosLlenados;
	}
	
}
