/*
 * Carrera.java
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


/**
 * Esta es la clase que modela la carrera 
 */
public class Carrera implements Serializable 
{
	/**
	 *  Constante de serialización.
	 */
	
	private static final long serialVersionUID = 1L;
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * Este es el atributo que representa el nombre de la carrera
	 */
    private String nombre;
    
    /**
     * Este es el atributo que representa el numero de la carrera
     */
    private int numeroCarrera;
    
    /**
     * Este es el atributo que representa la fecha de la carrera
     */
    private String fecha;
    
    /**
     * Este es el atributo que representa la hora
     */
    private String hora;
    
    /**
     * Este es el atributo que representa el circuito
     */
    private String circuito;
    
    /**
     * Este es el atributo que representa el lugar de la carrera
     */
    private String lugar;
    
    /**
     * Este es el atributo que representa el pais
     */
    private String pais;
    
    /**
     * Este es el atributo que representa la lista de posiciones de los participantes
     */
    private String[] posiciones;
    
    /**
     * Este es el atributo que representa la duracion de la carrera
     */
    private int duracion;
    
    /**
     * Este es el atributo donde se guarda la URL de la imagend e la carrera
     */
    private String urlImagen;
    
    /**
     * Este es el atributo que representa el id de la carrera
     */
    private String carreraId;
	
    // -----------------------------------------------------------------
 	// Metodos Construcotres
 	// -----------------------------------------------------------------
    
    /**
     * 
     * @param pNombre
     * @param pNumeroCarrera
     * @param pFecha
     * @param pHora
     * @param pCircuito
     * @param pLugar
     * @param pPais
     * @param pPosiciones
     * @param pDuracion
     * @param pUrlImagen
     * @param pCarreraId;
     */
    public Carrera(String pNombre, int pNumeroCarrera, String pFecha, String pHora, String pCircuito, String pLugar, String pPais, String[] pPosiciones, int pDuracion, String pUrlImagen, String pCarreraId )
    {
    	nombre = pNombre;
    	numeroCarrera = pNumeroCarrera;
    	fecha = pFecha;
    	hora = pHora;
    	circuito = pCircuito;
    	lugar = pLugar;
    	pais = pPais;
    	posiciones = pPosiciones;
    	urlImagen = pUrlImagen;
    	carreraId = pCarreraId;
    	
    }
    
    // -----------------------------------------------------------------
  	// Metodos 
  	// -----------------------------------------------------------------

    /**
     * Este método transforma la informacion a una cadena de carácteres separada por ";" para enviarla en el siguiente orden:
     * nombre;numeroCarrera;fecha;hora;circuito;lugar;pais;posiciones...;duracion;urlImagen
     * @return cadena de caracteres con informacion
     */
    public String toString()
    {
    	StringBuilder s = new StringBuilder(512);
    	s.append(nombre+";"+numeroCarrera+";"+fecha+";"+hora+";"+circuito+";"+lugar+";"+pais+";");
    	for(String c:posiciones)
    	{
    		s.append(c+";");
    	}
    	s.append(duracion+";"+urlImagen);
    	
    	return s.toString();
    }

}
