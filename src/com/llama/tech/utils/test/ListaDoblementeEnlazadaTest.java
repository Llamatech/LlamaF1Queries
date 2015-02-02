package com.llama.tech.utils.test;

import com.llama.tech.f1.utils.ListaDoblementeEnlazada;

import junit.framework.TestCase;

/**
 * Esta es la clase usada para verificar que los metodos de la listaDoblementeEnlazada funcionen correctamente
 */
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
		for(int i = 0; i < 6; i++)
		{
			lista.addAlFinal(i);
		}
		System.out.println(lista);
	}

	/**
	 * Crea el escenario con una lista con un elemento
	 */
	public void setUpEscenario3()
	{
		lista = new ListaDoblementeEnlazada<Integer>();
		lista.addAlFinal(8);
	}


	/**
	 * Prueba de adición de elementos al principio de la lista
	 * <b> M�todos a probar: </b> <br>
     * addAlPrincipio. <br>
     * <b> Objetivo: </b> Probar que el m�todo addAlPrincipio() agrega correctamente elementos a la lista. <br>
	 */
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
		assertEquals("El metodo no agregó el elemento en la posición correcta", (Integer)9, lista.get(3));

		setUpEscenario3();
		tam = lista.size();
		agrego = lista.add((Integer)2,(Integer) 9);
		assertEquals("El metodo deberia retornar false", false, agrego);
		assertEquals("El elemento no se deberia agregar a la lista", tam, lista.size());

	}

	public void testAddPosicion()
	{
		//Se prueba el caso de una lista no vacía donde existe la posición
		setUpEscenario2();
		int tam = lista.size();
		boolean agrego = lista.add(2,(Integer) 9);
		assertEquals("El metodo deberia retornar true", true, agrego);
		assertEquals("El elemento no se agregó a la lista", tam+1, lista.size());
		assertEquals("El metodo no agregó el elemento en la posición correcta", (Integer)9, lista.get(2));

		//Se prueba el caso de una lista vacía
		setUpEscenario1();
		try{
			lista.add(0, (Integer)9);
			fail("El metodo debería lanzar una excepcion");
		}
		catch(Exception e){

			//Se prueba el caso de una lista no vaía con una posición que no existe
			setUpEscenario3();
			try{
				lista.add(6, (Integer)8);
				fail("El método debería lanzar una excepción");
			}
			catch(Exception ex)
			{

			}
		}
	}

	public void testClear()
	{
		//Prueba el método con una lista vacía
		setUpEscenario1();
		assertEquals("La longitud debería ser cero", 0, lista.size());
		assertEquals("El primer elemento debería ser null", null, lista.getFirst());
		assertEquals("El último elemento debería ser null", null, lista.getLast());

		//Prueba el método con una lista no vacía
		setUpEscenario2();
		assertEquals("La longitud debería ser cero", 0, lista.size());
		assertEquals("El primer elemento debería ser null", null, lista.getFirst());
		assertEquals("El último elemento debería ser null", null, lista.getLast());
	}

	public void testContains()
	{
		//Prueba el método con una lista vacía
		setUpEscenario1();
		boolean esta = lista.contains((Integer)6);
		assertEquals("El metodo deberia retornar false porque la lista esta vacía", false, esta);

		//Prueba el método con una lista donde se encuentra el elemento
		setUpEscenario2();
		esta = lista.contains((Integer)2);
		assertEquals("El metodo deberia retornar true", true, esta);

		//Prueba el método con una lista donde no se encuentra el elemento
		setUpEscenario3();
		esta = lista.contains((Integer)66);
		assertEquals("El metodo deberia retornar false porque la lista esta vacía", false, esta);
	}

	public void testGet()
	{
		//Prueba el método en una lista vacía
		try{
			setUpEscenario1();
			lista.get(3);
			fail("El metodo debería lanzar una excepción");
		}
		catch(Exception e){

			//Prueba el método con una lista no vacía que se pasa del límite
			try{
				setUpEscenario3();
				lista.get(5);
				fail("El metodo deberia lanzar una excepción");
			}
			catch(Exception ex){
				//Prueba el método con una lista no vacía
				setUpEscenario2();
				Integer num = lista.get(2);
				assertEquals("No retorna el elemento esperado", (Integer)2, num);
			}

		}
	}

	public void testGetFirst()
	{
		//Se prueba el método con una lista vacía
		setUpEscenario1();
		Integer el = lista.getFirst();
		assertEquals("El metodo beria retornar null", null, el);

		//Se prueba el método con una lista no vacía
		setUpEscenario2();
		el = lista.getFirst();
		assertEquals("El metodo beria retornar el primer elemento", (Integer)0	, el);
	}

	public void testGetLast()
	{
		//Se prueba el método con una lista vacía
		setUpEscenario1();
		Integer el = lista.getLast();
		assertEquals("El metodo beria retornar null", null, el);

		//Se prueba el método con una lista no vacía
		setUpEscenario2();
		el = lista.getLast();
		assertEquals("El metodo beria retornar el primer elemento", (Integer)5	, el);
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

	public void testLastIndexOf()
	{
		//Se prueba el método con una lista vacía
		setUpEscenario1();
		int pos = lista.lastIndexOf((Integer)9);
		assertEquals("El metodo deberia retornar -1 porque la lista esta vacia", -1, pos);

		//se prueba el método con una lista no vacía donde no esta el elemento
		setUpEscenario2();
		pos = lista.lastIndexOf((Integer)87);
		assertEquals("El metodo deberia retornar -1 porque el elemento no esta en la lista", -1, pos);

		//Se prueba el método con una lista no vacía donde esta el elemento repetido
		setUpEscenario2();
		lista.addAlFinal((Integer)1);
		pos = lista.lastIndexOf((Integer)1);
		assertEquals("El metodo devuelve la posición equivocada", 6, pos);
	}

	public void testIsEmpty()
	{
		//Se prueba en una lista vacía
		setUpEscenario1();
		boolean vacio = lista.isEmpty();
		assertEquals("La lista debería estar vacía", true, vacio);

		//se prueba con una lista no vacía
		setUpEscenario2();
		vacio = lista.isEmpty();
		assertEquals("La lista no debería retornar vacía", false, vacio);
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
		//Se prueba el metodo con la lista vacía
		setUpEscenario1();
		Integer res = null;

		res= lista.remove((Integer)9);
		fail("El método debería fallar porque no hay elementos que remover");


		//Se prueba el método con una lista no vacía donde no esta el elemento dado
		setUpEscenario2();
		res=lista.remove((Integer)9);
		assertEquals("El método debería retornar null", null, res);

		//Se prueba el método con una lista no vacía donde el elemento dado es el primero
		int tam = lista.size();
		Integer el = lista.get(0);
		Integer ell = lista.get(1);
		res = lista.remove((Integer)0);
		assertEquals("El metodo debería retornar el primer elemento", el, res);
		assertEquals("El primer elemento no es el correcto", ell, lista.get((int)0));
		assertEquals("Debería haber un elemento menos", tam-1, lista.size());

		//Se prueba el método con una lista no vacía donde el elemento dado es el ultimo
		setUpEscenario2();

		tam = lista.size();
		el = lista.getLast();
		ell = lista.get(lista.size()-2);
		res=lista.remove((Integer)5);
		assertEquals("El metodo debería retornar el ultimo elemento", el, res);
		assertEquals("El ultimo elemento no es el correcto", ell, lista.get(lista.getLast()));
		assertEquals("Debería haber un elemento menos", tam-1, lista.size());


		//Se prueba el método con una lista no vacía donde el elemento dado esta el en medio
		setUpEscenario2();

		tam = lista.size();
		el = lista.get(3);
		res=lista.remove((Integer)3);
		assertEquals("El metodo debería retornar el elemento eliminado", el, res);
		assertEquals("Debería haber un elemento menos", tam-1, lista.size());




	}

	public void testRemovePos()
	{
		//se prueba el método con una lista vacía
		try{
			setUpEscenario1();
			lista.get(0);
			fail("El metodo deberia lanzar una excepion porque la lista esta vacia");
		}
		catch (Exception e)
		{
			//Se prueba el metodo con una lista no vacia y una posicion inexistente
			try{
				setUpEscenario3();
				lista.get(99);
				fail("El metodo debería fallar porque no existe esa posicion");
			} catch (Exception ex){

				//Se prueba el metodo con una lista no vacia y una posicion existente
				setUpEscenario2();
				Integer el = lista.get(2);
				assertEquals("El metodo no retorna el elemento correcto", (Integer)2,el);
			}
		}

	}

	public void testSet()
	{
		//Se prueba el método con una lista vacía
		try{
			setUpEscenario1();
			lista.set(0, (Integer)5);
			fail("El metodo debería lanzar una excepcion");
		}catch(Exception e){

			//Se prueba el método con una lista no vacía y una posición inexistente
			try{
				setUpEscenario3();
				lista.add(17, (Integer)9);
				fail("El metodo debería lanzar una excepcion");
			}
			catch(Exception ex){

				//Se prueba el método con una lista no vacía y una posición existente
				setUpEscenario2();
				int tam = lista.size();
				Integer ant = lista.get(3);
				Integer el = lista.set(3, (Integer)17);
				assertEquals("El elemento no se insertó en el lugar debido", (Integer)17, lista.get(3));
				assertEquals("El metodo debería retornar el elemento eliminado" , ant, el);
				assertEquals("El tamaño de la lista no debería cambiar", tam, lista.size());
			}
		}
	}

	public void testSize()
	{
		//Se prueba el método con la lista vacía
		setUpEscenario1();
		int tam = lista.size();
		assertEquals("El tamaño esta equivocado", 0, tam); 

		//Se prueba el método con la lista no vacía
		setUpEscenario2();
		 tam = lista.size();
		assertEquals("El tamaño esta equivocado", 6, tam); 

		//Se prueba el método con la lista  d3 1 elemento
		setUpEscenario3();
		 tam = lista.size();
		assertEquals("El tamaño esta equivocado", 1, tam); 

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
		assertEquals("El metodo deberia retornar null porque el elemento no se encuentra en la lista", null, res);
	}

	public void testIndexOf()
	{
		//Se prueba el método con una lista vacía
		setUpEscenario1();
		int pos = lista.indexOf((Integer)9);
		assertEquals("El metodo deberia retornar -1 porque la lista esta vacia", -1, pos);

		//se prueba el método con una lista no vacía donde no esta el elemento
		setUpEscenario2();
		pos = lista.indexOf((Integer)87);
		assertEquals("El metodo deberia retornar -1 porque el elemento no esta en la lista", -1, pos);

		//Se prueba el método con una lista no vacía donde esta el elemento
		pos = lista.indexOf((Integer)3);
		assertEquals("El metodo devuelve la posición equivocada", 3, pos);

	}

}
