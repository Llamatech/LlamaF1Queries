package com.llama.tech.f1.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Esta clase permite recorrer una lista simplemente enlazada
 * @param <ClaseGenerica>  el tipo de elemento que permite obtener el iterador
 */
class IteradorListaSimplementeEnlazada<ClaseGenerica> implements Iterator<ClaseGenerica>{
	
	private ElementoSimplementeEnlazado<ClaseGenerica> elementoActual;
	
	/**
	 * Construye un iterador de la lista simplemente enlazada desde el elemento dado por par�metro
	 * @param elementoActual El elemento en el que empieza el recorrido
	 */
	public IteradorListaSimplementeEnlazada(ElementoSimplementeEnlazado<ClaseGenerica> elementoActual) {
		this.elementoActual = elementoActual;
	}

	@Override
	public boolean hasNext() {
		return elementoActual!=null;
	}

	@Override
	public ClaseGenerica next()throws NoSuchElementException
	{
		if(!hasNext())
		{
			throw new NoSuchElementException("No hay m�s elementos en el iterador");
		}
		
		ClaseGenerica obj = elementoActual.getValor();
		elementoActual = elementoActual.getSiguiente();
		
		return obj;
	}
	
}

