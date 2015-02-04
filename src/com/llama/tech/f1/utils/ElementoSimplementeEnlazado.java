package com.llama.tech.f1.utils;

import java.io.Serializable;

/**
 * Elemento de una lista simplemente encadenada
 * @param <ClaseGenerica> El tipo de valor que va a almacenar este elemento
 */
class ElementoSimplementeEnlazado<ClaseGenerica> implements Serializable{
	
	private static final long serialVersionUID = -1934520635606061885L;
	
	private ClaseGenerica valor;
	private ElementoSimplementeEnlazado<ClaseGenerica> siguiente;
	
	public ElementoSimplementeEnlazado(ClaseGenerica valor) {
		this.valor = valor;
	}
	
	public ClaseGenerica getValor() {
		return valor;
	}
	
	public void setValor(ClaseGenerica valor) {
		this.valor = valor;
	}
	
	public ElementoSimplementeEnlazado<ClaseGenerica> getSiguiente()
	{
		return siguiente;
	}
	
	public void setSiguiente(ClaseGenerica valor)
	{
		siguiente.setValor(valor);
	}
	
	public void setSiguiente(ElementoSimplementeEnlazado<ClaseGenerica> node)
	{
		siguiente = node;
	}
	
	public void reinicializarSiguiente()
	{
		siguiente = null;
	}
}
