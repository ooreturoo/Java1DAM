package general.interfaces;

public interface IAtacador {
	
	<T extends IAtacable> void Atacar(T objetivo);
	
}
