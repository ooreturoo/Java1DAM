package paquete1;

public class Instituto {

	private int numAlumnos;
	private float fondosDisponibles;
	private int aceitePorBollo;
	private int onzasChocolate;
	
	
	public Instituto(int numAlumnos, float presupuesto, int aceiteBollo, int onzasChocolate) {
		
		this.numAlumnos = numAlumnos;
		this.fondosDisponibles = presupuesto;
		this.aceitePorBollo = aceiteBollo;
		this.onzasChocolate = onzasChocolate;
		
	}
	
	public int totalMililitros() {
		return this.numAlumnos * this.aceitePorBollo;
	}
	
	public int totalOnzas() {
		return this.numAlumnos * this.onzasChocolate;
	}

	public boolean esFactible(float presupuesto) {
		return this.fondosDisponibles >= presupuesto? true : false;
	}
	

	public int getNumAlumnos() {
		return numAlumnos;
	}


	public float getPresupuesto() {
		return fondosDisponibles;
	}


	
	
	
}
