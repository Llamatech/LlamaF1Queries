package com.llama.tech.f1.utils;

import java.io.Serializable;
import java.util.Iterator;

public class ListaSimplementeEnlazada<ClaseGenerica> implements Lista<ClaseGenerica>,Serializable{

	private static final long serialVersionUID = -8642976904815421465L;
	
	private ElementoSimplementeEnlazado<ClaseGenerica> primero; 
	private ElementoSimplementeEnlazado<ClaseGenerica> anterior; 
	private ElementoSimplementeEnlazado<ClaseGenerica> ultimo;
	private int length = 0;

	@Override
	public boolean addAlFinal(ClaseGenerica elemento) 
	{
		if(primero == null)
		{
			primero = new ElementoSimplementeEnlazado<ClaseGenerica>(elemento);
			anterior = primero;
			length++;
		}
		else
		{
			ultimo = new ElementoSimplementeEnlazado<ClaseGenerica>(elemento);
			anterior.setSiguiente(ultimo);
			ultimo.setValor(elemento);
			anterior = ultimo;
			ultimo = ultimo.getSiguiente();
			length++;
			
		}
		
	}

	@Override
	public void add(int pos, ClaseGenerica elemento) 
	{
		if(pos < 0 || pos > length-1 || length == 0)
		{
			throw new IndexOutOfBoundsException(String.format("El �ndice %d, es inv�lido", pos));
		}
		if(pos == 0)
		{
			ElementoSimplementeEnlazado<ClaseGenerica> nuevo = new ElementoSimplementeEnlazado<ClaseGenerica>(elemento);
			nuevo.setSiguiente(primero);
			primero = nuevo;
			length++;
		}
		else
		{
			ElementoSimplementeEnlazado<ClaseGenerica> anterior = primero;
			ElementoSimplementeEnlazado<ClaseGenerica> actual = primero.getSiguiente();
			int posActual = 0;
			boolean agregado = false;
			
			while(actual != null && !agregado)
			{
				if(posActual == pos)
				{
					ElementoSimplementeEnlazado<ClaseGenerica> nuevo = new ElementoSimplementeEnlazado<ClaseGenerica>(elemento);
					nuevo.setSiguiente(actual);
					anterior.setSiguiente(nuevo);
					agregado = true;
					length++;
				}
				
				anterior = actual;
				actual = actual.getSiguiente();
				posActual++;
			}
		}
		
	}

	@Override
	public void clear() 
	{
		length = 0;
		primero = null;
		ultimo = null;
		
	}

	@Override
	public boolean contains(ClaseGenerica elemento) 
	{
		boolean encontrado = false;
				
		if(length > 0)
		{
			if(primero.getValor().equals(elemento))
			{
				encontrado = true;
			}
			else if(anterior.getValor().equals(elemento))
			{
				encontrado = true;
			}
			else
			{
				ElementoSimplementeEnlazado<ClaseGenerica> actual = primero;
				encontrado = false;
				
				while(actual != null && !encontrado)
				{
					if(actual.getValor().equals(elemento))
					{
						encontrado = true;
					}
					
					actual = actual.getSiguiente();
				}
			}
		}
		return encontrado;
	}

	@Override
	public ClaseGenerica get(int pos) 
	{
		if(pos < 0 || pos > length-1 || length == 0)
		{
			throw new IndexOutOfBoundsException(String.format("El �ndice %d, es inv�lido", pos));
		}
		else if(pos == 0)
		{
			return primero.getValor();
		}
		else
		{
			ElementoSimplementeEnlazado<ClaseGenerica> actual = primero;
		 	int posActual = 0;
			
			while(actual != null)
			{
				if(posActual == pos)
				{
					return actual.getValor();
				}
				
				actual = actual.getSiguiente();
				posActual++;
			}
		}
		
		return null;
	}

	@Override
	public ClaseGenerica getLast() 
	{
		return anterior.getValor();
	}

	@Override
	public int indexOf(ClaseGenerica elemento) 
	{
		int index = -1;
		
		if(length > 0)
		{
			if(primero.getValor().equals(elemento))
			{
				index = 0;
			}
			else if(anterior.getValor().equals(elemento))
			{
				index = length-1;
			}
			else
			{
				ElementoSimplementeEnlazado<ClaseGenerica> actual = primero;
				int posActual = 0;
				boolean encontrado = false;
				
				while(actual != null && !encontrado)
				{
					if(actual.getValor().equals(elemento))
					{
						index = posActual;
						encontrado = true;
					}
					
					actual = actual.getSiguiente();
					posActual++;
				}
				
			}
		}
		
		return index;
	}

	@Override
	public int lastIndexOf(ClaseGenerica elemento) 
	{
		int index = -1;
		
		if(length > 0)
		{
			if(anterior.getValor().equals(elemento))
			{
				index = length-1;
			}
			else
			{
				ElementoSimplementeEnlazado<ClaseGenerica> actual = primero;
				int posActual = 0;
				
				while(actual != null)
				{
					if(actual.getValor().equals(elemento))
					{
						index = posActual;
					}
					
					actual = actual.getSiguiente();
					posActual++;
				}
			}
		}
		
		return index;
	}

	@Override
	public boolean isEmpty() 
	{
		return length == 0;
	}

	@Override
	public Iterator<ClaseGenerica> iterator() 
	{
		return new IteradorListaSimplementeEnlazada<>(primero);
	}
	
	@Override
	public Iterator<ClaseGenerica> iterator(int pos) 
	{
		ElementoSimplementeEnlazado<ClaseGenerica> elementoPos=null;
		
		if(pos < 0 || pos > length-1 || length == 0)
		{
			throw new IndexOutOfBoundsException(String.format("El �ndice %d, es inv�lido", pos));
		}
		
		ElementoSimplementeEnlazado<ClaseGenerica> actual = primero;
		int posActual = 0;
		boolean encontrado = false;
		
		while(actual != null && !encontrado)
		{
			if(posActual == pos)
			{
				elementoPos = actual;
				encontrado = true;
			}
			
			actual = actual.getSiguiente();
			posActual++;
		}
		
		
		return new IteradorListaSimplementeEnlazada<>(elementoPos);
	}

	@Override
	public ClaseGenerica remove(int pos) 
	{
		ClaseGenerica obj = null;
		
		if(pos < 0 || pos > length-1 || length == 0)
		{
			throw new IndexOutOfBoundsException(String.format("El �ndice %d, es inv�lido", pos));
		}
		else if(pos == 0)
		{
			obj = primero.getValor();
			primero = primero.getSiguiente();
			length--;
			
		}
		else
		{
			ElementoSimplementeEnlazado<ClaseGenerica> anterior = primero;
			ElementoSimplementeEnlazado<ClaseGenerica> actual = primero.getSiguiente();
			int posActual = 1;
			boolean eliminado = false;
			
			while(actual != null && !eliminado)
			{
				if(posActual == pos)
				{
					obj = actual.getValor();
					anterior.setSiguiente(actual.getSiguiente());
					eliminado = true;
					
					length--;
				}
				
				anterior = actual;
				actual = actual.getSiguiente();
				posActual++;
			}
			
		}
		
		return obj;
	}

	@Override
	public boolean remove(ClaseGenerica elemento) 
	{
		boolean eliminado = false;
		
		if(length > 0)
		{
			if(primero.getValor().equals(elemento))
			{
				
				primero = primero.getSiguiente();
				eliminado = true;
				length--;
			}
			else
			{
				ElementoSimplementeEnlazado<ClaseGenerica> anterior = primero;
				ElementoSimplementeEnlazado<ClaseGenerica> actual = primero.getSiguiente();
				
				while(actual != null && anterior != null && !eliminado)
				{
					if(actual.getValor().equals(elemento))
					{
						anterior.setSiguiente(actual.getSiguiente());
				        eliminado = true;
				        actual = null;
						length--;
						return eliminado;
					}
					
					anterior = actual;
					actual = actual.getSiguiente();
				}
			}
		}
		
		return eliminado;
	}

	@Override
	public ClaseGenerica set(int pos, ClaseGenerica elemento) 
	{
		ClaseGenerica obj = null;
		
		if(pos < 0 || pos > length-1 || length == 0)
		{
			throw new IndexOutOfBoundsException(String.format("El �ndice %d, es inv�lido", pos));
		}
		else if(pos == 0)
		{
			obj = primero.getValor();
			primero.setValor(elemento);
		}
		else if(pos == length-1)
		{
			obj = anterior.getValor();
			anterior.setValor(elemento);
		}
		else
		{
			ElementoSimplementeEnlazado<ClaseGenerica> actual = primero;
			int posActual = 0;
			boolean modificacion = false;
			
			while(actual != null && !modificacion)
			{
				if(posActual == pos)
				{
					obj = actual.getValor();
					actual.setValor(elemento);
					modificacion = true;
				}
				actual = actual.getSiguiente();
				posActual++;
			}
		}
		
		return obj;
	}

	@Override
	public int size() 
	{
		return length;
	}
	
	public ElementoSimplementeEnlazado<ClaseGenerica> darPrimero()
	{
		return primero;
	}

	@Override
	public boolean addAlPrincipio(ClaseGenerica elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(int pos, ClaseGenerica elemento)
			throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(ClaseGenerica elementoI, ClaseGenerica elementoAgregar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClaseGenerica buscar(ClaseGenerica elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClaseGenerica removeFirst() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClaseGenerica removeLast() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClaseGenerica remove(ClaseGenerica elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
