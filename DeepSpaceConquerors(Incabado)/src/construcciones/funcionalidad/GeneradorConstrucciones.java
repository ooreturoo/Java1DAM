package construcciones.funcionalidad;

import cartas.clases.Carta;
import construcciones.clases.*;
import dados.clases.*;
import recursos.clases.Materia;
import utiles.Leer;
import utiles.TextosConsola;

public class GeneradorConstrucciones {
	
	public static EscudoProtector generarEscudoConCarta(Carta carta) {
		
		EscudoProtector escudo = new EscudoProtector();
		
		Dado dado = new Dado_A();
		int resultadoDado = dado.lanzar();
		escudo.setPuntosDefensa(resultadoDado);
		
		return escudo;
	}


	public static Mina generarMinaConCarta(Carta cartaMina) {
		
		Mina mina = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(TextosConsola.ELECCION_MATERIAL).append("(");
		for(int i = 0; i < Materia.values().length; i++) {
			sb.append(Materia.values()[i]);
			if(i != Materia.values().length-1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		
		boolean materialValido = false;
		Materia material = null;
		while(!materialValido) {
			
			String materialElegido = Leer.lecturaString(sb.toString()).toLowerCase();
			
			for(int i = 0; i < Materia.values().length; i++) {
				
				if(Materia.values()[i].name().toLowerCase().equals(materialElegido)) {
					material = Materia.values()[i];
					materialValido = true;
				}
			}
			
			if(!materialValido) {
				System.out.println(TextosConsola.MATERIAL_ELEGIDO_INVALIDO);
			}
			
		}
		
		if(material.equals(Materia.ORO)) {
			mina = new Mina(material, 2);
		}else {
			Dado dado = new Dado_A();
			int resultadoDado = dado.lanzar();
			mina = new Mina(material,resultadoDado);
		}
			
		
		return mina;
	}
}
