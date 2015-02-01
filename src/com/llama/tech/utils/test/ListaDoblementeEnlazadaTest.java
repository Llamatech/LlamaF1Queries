package com.llama.tech.utils.test;

import com.llama.tech.f1.utils.ListaDoblementeEnlazada;

import junit.framework.TestCase;

public class ListaDoblementeEnlazadaTest extends TestCase {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Es la clase donde se har�n las pruebas
	 */
	private ListaDoblementeEnlazada<Integer> lista;

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Crea el escenario con una lista vacía
	 */
	public void setUpEscenario1()
	{
		lista = new ListaDoblementeEnlazada<Integer>();
	}

	/**
	 * Crea el escenario con una lista con más de un elemento
	 */
	public void setUpEscenario2()
	{
		lista = new ListaDoblementeEnlazada<Integer>();
		lista.addAlFinal(0);
		lista.addAlFinal(1);
		lista.addAlFinal(2);
		lista.addAlFinal(3);
		lista.addAlFinal(4);
		lista.addAlFinal(5);
	}

	/**
	 * Crea el escenario con una lista con un elemento
	 */
	public void setUpEscenario3()
	{
		lista = new ListaDoblementeEnlazada<Integer>();
		lista.addAlFinal(8);
	}

	
	public void testAddAlPrincipio()
	{
		setUpEscenario1();
		boolean agrego = lista.addAlPrincipio(98);
		assertEquals("El método debería retornar true", true, agrego);
		assertEquals("El elemento no se agregó en lap primera posición", 98, (int)lista.get(0));

		setUpEscenario2();
		agrego = lista.addAlPrincipio(98);
		assertEquals("El método debería retornar true", true, agrego);
		assertEquals("El elemento no se agregó en lap primera posición", 98, (int)lista.get(0));
	}

	public void testAddAlFinal()
	{
		setUpEscenario1();
		boolean agrego = lista.addAlFinal(98);
		assertEquals("El método debería retornar true", true, agrego);
		assertEquals("El elemento no se agregó en lap primera posición", 98, (int)lista.get(lista.size()-1));

		setUpEscenario2();
		agrego = lista.addAlFinal(98);
		assertEquals("El método debería retornar true", true, agrego);
		assertEquals("El elemento no se agregó en lap primera posición", 98, (int)lista.get(lista.size()-1));
	}

	public void testAddDespuesDe()
	{
		setUpEscenario2();
		int tam = lista.size();
		boolean agrego = lista.add((Integer)2,(Integer) 9);
		assertEquals("El metodo deberia retornar true", true, agrego);
		assertEquals("El elemento no se agregó a la lista", tam+1, lista.size());
		assertEquals("El metodo no agregó el elemento en la posición correcta", 2, (int)lista.get(3));

		setUpEscenario3();
		tam = lista.size();
		agrego = lista.add((Integer)2,(Integer) 9);
		assertEquals("El metodo deberia retornar false", false, agrego);
		assertEquals("El elemento no se deberia agregar a la lista", tam, lista.size());

	}

	public void testRemoveFirst()
	{
		setUpEscenario1();
		Integer res = null;
		try
		{
			res= lista.removeFirst();
			fail("El método debería fallar porque no hay elementos que remover");

		}
		catch(Exception e)
		{
			setUpEscenario3();
			try{
				res = lista.removeFirst();
				assertEquals("El método debería retornar el elemento eliminado", 8, (int)res);
				assertEquals("La lista debería quedar vacía", 0, lista.size());

				setUpEscenario2();
				res = lista.removeFirst();
				assertEquals("El método debería retornar el elemento eliminado", 0, (int)res);
			}
			catch(Exception ex){
				fail("El método no debería fallar");
			}
		}

	}

	public void testRemoveLast()
	{
		setUpEscenario1();
		Integer res = null;
		try
		{
			res= lista.removeLast();
			fail("El método debería fallar porque no hay elementos que remover");

		}
		catch(Exception e)
		{
			setUpEscenario3();
			try{
				res = lista.removeLast();
				assertEquals("El método debería retornar el elemento eliminado", 8, (int)res);
				assertEquals("La lista debería quedar vacía", 0, lista.size());

				setUpEscenario2();
				res = lista.removeFirst();
				assertEquals("El método debería retornar el elemento eliminado", 5, (int)res);
			}
			catch(Exception ex){
				fail("El método no debería fallar");
			}
		}

	}
	
	public void testRemove()
	{
		setUpEscenario1();
		Integer res = null;
		try
		{
			res= lista.removeLast();
			fail("El método debería fallar porque no hay elementos que remover");

		}
		catch(Exception e)
		{
			setUpEscenario2();
			try{
			res=lista.remove((Integer)9);
			assertEquals("El método debería retornar null", null, res);
			
			int tam = lista.size();
			Integer el = lista.get(0);
			Integer ell = lista.get(1);
			res = lista.remove((Integer)0);
			assertEquals("El metodo debería retornar el primer elemento", el, res);
			assertEquals("El primer elemento no es el correcto", ell, lista.get((int)0));
			assertEquals("Debería haber un elemento menos", tam-1, lista.size());
			
			setUpEscenario2();
			
			tam = lista.size();
			el = lista.getLast();
			ell = lista.get(lista.size()-2);
			res=lista.remove((Integer)5);
			assertEquals("El metodo debería retornar el ultimo elemento", el, res);
			assertEquals("El ultimo elemento no es el correcto", ell, lista.get(lista.getLast()));
			assertEquals("Debería haber un elemento menos", tam-1, lista.size());
			
			setUpEscenario2();
			
			tam = lista.size();
			el = lista.get(3);
			res=lista.remove((Integer)3);
			assertEquals("El metodo debería retornar el elemento eliminado", el, res);
			assertEquals("Debería haber un elemento menos", tam-1, lista.size());
			
			
			}
			catch( Exception ex){
				fail("El metodo no deberia fallar");
			}
		}
		
	}
	
	public void testBuscar()
	{
		setUpEscenario1();
		Integer res = lista.buscar((Integer)54);
		assertEquals("El metodo deberia retornar null porque la lista esta vacia", null, res);
		
		setUpEscenario2();
		res = lista.buscar((Integer)4);
		assertEquals("El metodo deberia retornar el elemento buscado", (Integer)4, res);
		
		setUpEscenario2();
		res= lista.buscar((Integer)12);
		assertEquals("El metodo deberia retornar null porque el elemento no se encuentra en la lista", (Integer)12, res);
	}
	
	public void testBuscarPosicion()
	{
		setUpEscenario1();
		int pos = lista.buscar((Integer)9);
		assertEquals("El metodo deberia retornar -1 porque la lista esta vacia", -1, pos);
		
		setUpEscenario2();
		pos = lista.buscar((Integer)87);
		assertEquals("El metodo deberia retornar -1 porque el elemento no esta en la lista", -1, pos);
		
		pos = lista.buscar((Integer)3);
		assertEquals("El metodo devuelve la posición equivocada", 3, pos);
		
	}

}
