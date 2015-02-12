/*
 * Escuderia.java
 * This file is part of F1ChampionshipQueries
 *
 * Copyright (C) 2015 - LlamaTech Team 
 *
 * F1ChampionshipQueries is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * F1ChampionshipQueries is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with F1ChampionshipQueries. If not, see <http://www.gnu.org/licenses/>.
 */


package com.llama.tech.f1.backbone;

import java.io.Serializable;

import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;

/**
 * Esta es la clase que modela las escuderias (contructores)
 */
public class Escuderia implements Serializable, Comparable<Escuderia> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * Este es el atributo que representa el url del logo de la escuderia
	 */
	private String urlLogo;
	
	/**
	 * Este es el atributo que representa el nombre de la escuderia
	 */
	private String nombre;
	
	/**
	 * Este es el atributo que representa el pais de la escuderia
	 */
	private String pais;
	
	/**
	 * Este es el atributo que representa la posicion final de la escuderia
	 */
	private int posFinal;
	
	/**
	 * Este es el atributo que representa los puntos de la escuderia
	 */
	private int puntos;
	
	/**
	 * Este es el atributo que representa los pilotos de la escuderia
	 */
	private Lista<String> pilotos;

	/**
	 * Este es el atributo que representa el id de la escuderia
	 */
	private String id;
    // -----------------------------------------------------------------
 	// Metodos Construcotres
 	// -----------------------------------------------------------------
    
	/**
	 * Este es el metodo constructor de la clase escuderia
	 * pos: se construyó una nueva escudería
	 * @param pUrlLogo 
	 * @param pNombre
	 * @param pPais
	 * @param pPosFinal
	 * @param pPuntos
	 * @param pPilotos
	 * @param pId
	 */
	public Escuderia(String pUrlLogo, String pNombre, String pPais, int pPosFinal, int pPuntos, String pId)
	{
		pilotos = new LlamaArrayList<String>(10);
		urlLogo=pUrlLogo;
		nombre=pNombre;
		pais=pPais;
		posFinal=pPosFinal;
		puntos=pPuntos;
		id = pId;
	}
	 // -----------------------------------------------------------------
 	// Metodos
 	// -----------------------------------------------------------------

   

	/**
	 * Este metodo permite conseguir la ruta del logo
	 * @return ruta dellogo
	 */
	public String getUrlLogo() {
		return urlLogo;
	}

	/**
	 * Este metodo devuelve el nombre de la escuderia
	 * @return nombre escuderia
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo retorna el pais de la escuderia
	 * @return pais de la escuderia
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Este metodo retorna la posicion final de la escuderia
	 * @return posicion final escuderia
	 */
	public int getPosFinal() {
		return posFinal;
	}


	/**
	 * Este metodo retorna los puntos de la escuderia
	 * @return puntos de la escuderia
	 */
	public int getPuntos() {
		return puntos;
	}


	/**
	 * Este metodo retorna una lista con los nombres de los pilotos que pertenecen a la escuderia
	 * @return lista con nombres de pilotos
	 */
	public Lista<String> getPilotos() {
		return pilotos;
	}

	/**
	 * Este metodo agrega el nombre de un piloto a la lista de nombres de pilotos
	 * @param piloto nombre del piloto
	 */
	public void setPiloto(String piloto) {
		pilotos.addAlFinal(piloto);
	}

	/**
	 * Este metodo retorna el id de la escuderia
	 * @return id de la escuderia
	 */
	public String getId() {
		return id;
	}


	@Override
	public int compareTo(Escuderia o) 
	{
		return nombre.compareTo(o.getNombre());

	}
}
