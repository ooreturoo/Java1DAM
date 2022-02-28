package naves.interfaces;

import planetasyrecursos.Planeta;
import recursos.clases.MateriaPrima;

public interface ITransportador {
	
	void transportar(Planeta planetaDestino, MateriaPrima[] materiasPrimas);
	
}
