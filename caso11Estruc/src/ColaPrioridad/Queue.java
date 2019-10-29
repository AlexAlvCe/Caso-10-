package ColaPrioridad;

// hash, c++, listas

import java.util.ArrayList;

public abstract class Queue<T> {

	protected ArrayList<T> colas[];
	
	public Queue() {
		// saco la cantidad de prioridades que hay en el enum
		int cantidadPrioridades = QueuePriorities.values().length;
		
		// hago un arreglo de ArrayLists de ese tama�o
		// en ese momento cada casilla sabe que ahi va un arraylist pero esta nulo
		colas = new ArrayList[cantidadPrioridades];
		
		// entonces hay que iniciar cada casilla del arreglo con el arraylist generic
		for(int indexArray=0; indexArray<cantidadPrioridades; indexArray++) {
			colas[indexArray] =  new ArrayList<T>();
		}
	}
	
	public Queue(T arregloItems[]) {
		this();
		
		for(T item : arregloItems) {
			enqueue(item);
		}
	}	
	
	// implemente este m�todo haciendo un llamado a enqueue con prioridad
	public abstract void enqueue(T pValue);
	
	// implemente �ste m�todo en la clase hija, si no hay elementos retorna null
	public abstract T dequeue();

	
	// implemente �ste m�todo en la clase hija, debe quitar todos los elementos de la cola
	public abstract void clear();

	public abstract void enqueue(T pValue, QueuePriorities priority);
}
