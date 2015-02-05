package com.llama.tech.utils.test;

import com.llama.tech.f1.utils.Lista;
import com.llama.tech.f1.utils.ListaSimplementeEnlazada;

/**
 * Esta es la clase que prueba la lista simplemente enlazada
 */
public class ListaSimplementeEnlazadaTest extends ListaTest{

	/**
	 * Este metodo crea una lista nueva
	 */
	@Override
	public Lista<Integer> crearNuevaLista() {
		return new ListaSimplementeEnlazada<Integer>();
	}
	
	

}
