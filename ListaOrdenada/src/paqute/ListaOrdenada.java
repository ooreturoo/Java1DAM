package paqute;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaOrdenada<T extends Comparable<T>> {

	private LinkedList<T> lista;
	
	public ListaOrdenada(){
		
		lista = new LinkedList<T>();
		
	}
	
	public void addOrdenado(T t) {
		
		if(lista.isEmpty()) {
			
			lista.add(t);
			
		}else {
			
			Iterator<T> iterador = lista.iterator();
			
			int cont = 0;
			boolean introducido = false;
			
			while (iterador.hasNext() && !introducido) {
				
				
				if (iterador.next().compareTo(t) > 0) {
					
					introducido = true;
					
				}else {
					
					cont++;
					
				}
				
			}
			
			lista.add(cont, t);
			
		}
		
	}

	public LinkedList<T> getLista() {
		return lista;
	}
	
	
	
}
