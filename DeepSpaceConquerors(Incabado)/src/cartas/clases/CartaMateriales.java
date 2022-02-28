package cartas.clases;

import recursos.clases.Materia;

public class CartaMateriales extends Carta{
	
	public CartaMateriales(Materia material) {
		super(material.toString(), 0);
	}
	
}
