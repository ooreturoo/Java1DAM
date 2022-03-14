package utilidades;

import java.time.LocalDate;

import clases.Coche;
import excepciones.ValorCocheInvalidoException;

public class Funcionalidades {

	
	private static final String LETRAS_MATRICULA_INVALIDA = "AEIOUaeiou";
	private static final int LONGITUD_MATRICULA = 7;
	
	
	/**
	 * Método para comprobar si la matrícula recibida es válida.
	 * @param matricula
	 * @throws ValorCocheInvalidoException
	 */
	public static void comprobarMatricula(String matricula) throws ValorCocheInvalidoException {
		
		//Se comprueba que la longitud de la matricula sea la indicada.
		if(matricula.length() != LONGITUD_MATRICULA) {
			
			throw new ValorCocheInvalidoException("Longitud de la matrícula incorrecta.");
			
		}
		
		//Almacenara si la matricula cumple con todos los requisitos.
		boolean matriculaCorrecta = true;
		
		//Se recorreran todos los caracteres de la matricula.
		for(int i = 0; i < LONGITUD_MATRICULA && matriculaCorrecta; i++) {
			
			//Si los cuatro primeros caracteres no son números, se indicará que la matrícula no es correcta.
			if(i < 4 && !Character.isDigit(matricula.charAt(i))) {
				matriculaCorrecta = false;
			}
			
			//Se comprobará que los ultimos tres caracteres sean letras.
			if(i >= 4 && Character.isLetter(matricula.charAt(i))) {
				
				//Almacenará si el caracter que se recorre es válido.
				boolean letraValida = true;
				
				//Se recorre el array que almacena los caractéres invalidos.
				for(int j = 0; j < LETRAS_MATRICULA_INVALIDA.length() && !letraValida; j++) {
					
					//Si en algun momento el caracter es uno de los pertenecientes el array, se indicara que la letra no es válida.
					if(LETRAS_MATRICULA_INVALIDA.charAt(j) == matricula.charAt(i)) {
						letraValida = false;
					}
					
				}
				
				//Si se ha encontrado alguna letra válida, el valor de la matrícula será invalida.
				if(!letraValida) {
					
					matriculaCorrecta = false;
					
				}
				
				
			}else if(i >= 4) {
				
				matriculaCorrecta = false;
				
			}
			
		}
		
		//Lanzará una excepción si la matricula es incorrecta.
		if(!matriculaCorrecta) {
			
			throw new ValorCocheInvalidoException("El formato de la matrícula no es correcto.");
			
		}
	}
	
	
	/**
	 * Método para dar valores a los atributos del coche recibido por parámetro pidiendo los datos al usuario.
	 * @param coche
	 */
	public static void obtenerValoresCoche (Coche coche) {
		/*
		 * Se almacena cada pedido de un valor dentro de un while para que en el caso de que algunos de los campos que 
		 * introduzca sean erroneos, no deba volver a repetir todos desde el comienzo.
		 */
		boolean campoCorrecto = false;
		
		
		while(!campoCorrecto) {
			
			try {
				coche.setNombrePropietario(Leer.lecturaString("\nIntroduce el nombre del propietario del coche."));
				campoCorrecto = true;
			} catch (ValorCocheInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		campoCorrecto = false;
		
		while(!campoCorrecto) {
			
			try {
				coche.setMatricula(Leer.lecturaString("\nIntroduce la matrícula del vehículo."));
				campoCorrecto = true;
			} catch (ValorCocheInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		campoCorrecto = false;
		
		while(!campoCorrecto) {
			
			try {
				coche.setKilometros(Leer.lecturaInt("Introduce los kilometros del vehículo."));
				campoCorrecto = true;
			} catch (ValorCocheInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
		}

		campoCorrecto = false;
		
		while(!campoCorrecto) {
	
			try {
				coche.setMarca(Leer.lecturaString("Introduce la marca del vehículo."));
				campoCorrecto = true;
			} catch (ValorCocheInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
		}

		campoCorrecto = false;
		
		while(!campoCorrecto) {
			
			try {
				
				int dia = Leer.lecturaInt("Introduce el día del aparcamiento.",1,31);
				int mes = Leer.lecturaInt("Introduce el mes del aparcamiento.",1,13);		
				int year = Leer.lecturaInt("Introduce el año del aparcamiento.",2000,2023);
				
				coche.setFechaAparcamiento(LocalDate.of(year, mes, dia));
				campoCorrecto = true;
			} catch (ValorCocheInvalidoException e) {
				System.out.println(e.getMessage());
			}
	
		}

		
	}
	
}
