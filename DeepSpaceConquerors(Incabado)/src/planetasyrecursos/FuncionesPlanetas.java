package planetasyrecursos;

import dados.clases.Dado;
import dados.clases.Dado_B;
import naves.clases.NaveAtaque;
import recursos.clases.MateriaPrima;
import utiles.TextosConsola;

public class FuncionesPlanetas {
	
	
	/**
	 * Método encargado de aumentar o reducir los recursos de un planeta.
	 * @param materialesPlaneta Recursos del planeta.
	 * @param materialesModificadores Recursos que se quieren modificar.
	 * @param operador Operador de suma o resta, dependiendo si se quiere aumentar o reducir los recursos.
	 * @return Devuelve los recursos finales.
	 */
	public static MateriaPrima[] reducirAumentarRecursosPlaneta(MateriaPrima[] materialesPlaneta, MateriaPrima[] materialesModificadores, char operador) {
			//Se almacena los valores pasados por parámetro para modificar los valores.
			MateriaPrima[] resultado  = materialesPlaneta;
			//Indicara si el planeta tiene suficientes materiales.
			boolean materialesSuficientes = true;
			
			
			for(int i = 0; i < resultado.length && materialesSuficientes; i++) {
				//Obtenemos cada recurso del planeta.
				MateriaPrima mPlaneta = resultado[i];
				
				for(int j = 0; j < materialesModificadores.length && materialesSuficientes; j++) {
					//Obtenemos cada recurso modificador.
					MateriaPrima mModificador = materialesModificadores[j];
					//Comprobamos si el recurso del planeta es igual que el recurso que se quiere modificar.
					if(mPlaneta.getTipoMateria().equals(mModificador.getTipoMateria())) {
						
						//Se comprueba cual es el operador que se ha introducido para la operación a realizar.
						switch(operador) {
						case '+':
							//Se suma los recursos y se asigna al array que será el final.
							resultado[i].setCantidadMateria(mPlaneta.getCantidadMateria() + mModificador.getCantidadMateria());
							break;
						case '-':
							//Se obtiene el resultado de la resta.
							int diferencia = mPlaneta.getCantidadMateria() - mModificador.getCantidadMateria();
							/*
							 * Si el resultado da negativo, significa que el planeta no tiene los suficiente recursos.
							 * En caso contrario se añadirá a los recursos resultantes.
							 */
							if(diferencia < 0) {
								materialesSuficientes = false;
							}else {
								resultado[i].setCantidadMateria(diferencia);
							}
							break;
						}
						
					}
				}
			}
			
			/*
			 * Si habían los recursos suficientes, se devolverá el resultado. Si no se devolverá los materiales
			 * del planeta sin modificarse.
			 */
			
			if(materialesSuficientes) {
				
				return resultado;
				
			}else {
				return materialesPlaneta;
			}
			
	}
	
	/*
	 * TODO Implementar el método que compruebe que la nave que quiere atacar esta en al orbita del planeta
	 * a atacar.
	 */
	
	/**
	 * Método encargado del ataque a un planeta.
	 * @param nave La nave atacante
	 * @param planetaParaAtacar Planeta al que realizar el ataque
	 * @return Devuelve true o false, dependiendo de si pudo atacarse el planeta con exito.
	 */
	public static boolean ataqueAPlaneta(NaveAtaque nave, Planeta planetaParaAtacar) {
		
		boolean planetaAtacado = false;
		
		//Si el planeta a atacar no está conquistado se avisara al usuario y se devolverá false.
		if(planetaParaAtacar.isConquistado()) {
			
			Dado dado = new Dado_B();
			//Se lanza el dado para ver si se fálla el ataque.
			int resultadoDado = dado.lanzar();
			//Si el resultado es igual al número mínimo o máximo del dado, se esquivará el ataque.
			if(resultadoDado == dado.getMin() || resultadoDado == dado.getMax()) {
				
				System.out.println(TextosConsola.ATAQUE_ESQUIVADO);
				
			}else {
				
				/*
				 * Se comprueba si el planeta tiene escudo protector, de ser así se atacará el escudo protector,
				 * si no, se atacará directamente al planeta.
				 */
				if(planetaParaAtacar.isEscudoProtector()) {
					
					//Se ataca al escudo.
					nave.Atacar(planetaParaAtacar.getEscudo());
						
					//Si el valor del escudo despues de haberlo atacado es 0, se destruye.
					if(planetaParaAtacar.getEscudo().getPuntosDefensa() == 0) {
							planetaParaAtacar.destruirEscudoProtector();
					}
					
					
				}else {
					
					//Se ataca al planeta.
					nave.Atacar(planetaParaAtacar);
					
					//Si el escudo del planeta llega a 0, se considerará conquistado.
					if(planetaParaAtacar.getCantidadEscudo() == 0) {
						/*
						 * TODO Crear metodo conquista e implementar aqui la conquista del planeta.
						 * Contemplar cmabiar el almacenamiento de los planetas del tablero(El del tablero deberia
						 * modificarse solo puesto que sería el que se pasaría por parametro), 
						 * del jugador propietario
						 * anterior y del nuevo propietario.
						 */
						
					}
					
				}
				
			}
			
			
			
			planetaAtacado = true;
			
		}else {
			System.out.println(TextosConsola.ATACAR_NO_CONQUISTADO);
		}
		
		return planetaAtacado;
	}
	
	//TODO Añadir textos para cada vez que se ataca con la información adecuada en cada caso.
	
	
}
