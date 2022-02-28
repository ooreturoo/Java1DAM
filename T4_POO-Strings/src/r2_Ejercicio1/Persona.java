package r2_Ejercicio1;

import java.time.LocalDate;

public class Persona {
	private String nombre;
	private LocalDate fechaNacimiento;
	private int dni;
	private char sexo;
	private float altura;
	private float peso;
	
	/**
	 * Genera la letra que le corresponde al dni de al persona. 
	 * @return Devuelve la letra.
	 */
	public char getLetraDni() {
		String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
		
		int modulo= dni % 23;
		char letra = juegoCaracteres.charAt(modulo);
		
		return letra;
	}
	
	/**
	 * Constructor de la clase persona.
	 * @param 
	 * @param fechaNacimiento 
	 * @param dni Recibe un número que tiene que ser de 8 dígitos.
	 * @param sexo Comprueba si el sexo introducido es valido.
	 */
	public Persona(String nombre, LocalDate fechaNacimiento,int dni, char sexo) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		if(comprobarDni(dni) == 8) {//Comprueba si dni tiene 8 dígitos, si es asi le da valor al atributo dni
			this.dni = dni;			
		}
		if(sexo == 'm' || sexo == 'f') {//Comprueba si el valor introducido es f o m, si es asi le da valor al atributo sexo
			this.sexo = sexo;			
		}
	}
	
	/**
	 * Obtiene el IMC a través de la alturay el peso.
	 * @return
	 */
	public float getIMC() {
		/*
		 * Si altura y peso no son 0, se calcula el IMC, si no se avisa al usuario.
		 */
		if(this.altura != 0 && this.peso != 0) {
			return (float) (this.peso / Math.pow(altura, 2));
		}else {
			System.out.println("No se pudo calcular el IMC");
		}
		
		return 0;
	}
	
	/**
	 * Comprueba las cifras que tiene el DNI.
	 * @param dni Recibe el DNI
	 * @return Devuelve el número de cifras.
	 */
	private int comprobarDni(int dni) {
		int cifras = 0;
		
		while(dni != 0) {
			dni /= 10;
			cifras++;
		}
		
		return cifras;
		
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [nombre=");
		builder.append(this.nombre);
		builder.append(", fechaNacimiento=");
		builder.append(this.fechaNacimiento);
		builder.append(", dni=");
		builder.append(this.dni);
		builder.append(", sexo=");
		builder.append(this.sexo);
		builder.append(", altura=");
		builder.append(this.altura);
		builder.append(", peso=");
		builder.append(this.peso);
		builder.append("]");
		return builder.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getDni() {
		return dni;
	}

	public char getSexo() {
		return sexo;
	}

	public float getAltura() {
		return altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
}
