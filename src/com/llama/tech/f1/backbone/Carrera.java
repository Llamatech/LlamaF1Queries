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

import com.llama.tech.utils.list.Lista;


/**
 * Esta es la clase que modela la carrera 
 */
public class Carrera implements Comparable<Carrera>, Serializable 
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
     * Este es el atributo que representa la duracion de la carrera
     */
    private String duracion;
    
    /**
     * Este es el atributo donde se guarda la URL de la imagend e la carrera
     */
    private String urlImagen;
    
    /**
     * Este es el atributo que representa el id de la carrera
     */
    private String carreraId;
    
    private Lista<Piloto> pilotos;	
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
     * @param pPilotos
     */
    public Carrera(String pNombre, int pNumeroCarrera, String pFecha, String pHora, String pCircuito, String pLugar, String pPais, String pDuracion, String pUrlImagen, String pCarreraId, Lista<Piloto> pPilotos )
    {
    	nombre = pNombre;
    	numeroCarrera = pNumeroCarrera;
    	fecha = pFecha;
    	hora = pHora;
    	circuito = pCircuito;
    	lugar = pLugar;
    	pais = pPais;
    	urlImagen = pUrlImagen;
    	carreraId = pCarreraId;
    	pilotos = pPilotos;
    	duracion = pDuracion;
    	
    	//TODO : hacer la lista de pilotos partiendo de lasp osiciones: buscarlos por su id/apellido y añadirlos.
    	
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
    	s.append("Fecha: "+fecha+", Nombre carrera: "+nombre+", Nombre circuito: "+circuito+", Ciudad: "+lugar+", Pais: "+pais);
//    	for(String c:posiciones)
//    	{
//    		s.append(c+";");
//    	}
    	//s.append(duracion+";"+urlImagen);
    	s.append(urlImagen);
    	
    	return s.toString();
    }


    /**
     * Retorna el nombre de la carrera
     * @return nombre de la carrera
     */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre de la carrera
	 * @param nombre el nombre al que será cambiado
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna el numero de la carrera
	 * @return el numero de la carrera
	 */
	public int getNumeroCarrera() {
		return numeroCarrera;
	}

	/**
	 * Cambia el numero de la carrera
	 * @param numeroCarrera numero nuevo carrera
	 */
	public void setNumeroCarrera(int numeroCarrera) {
		this.numeroCarrera = numeroCarrera;
	}

	/**
	 * Este metodo devuelve la fecha
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Este metodo devuelve la hora
	 * @return hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * Este metodo devuelve el circuito
	 * @return circuito
	 */
	public String getCircuito() {
		return circuito;
	}

	/**
	 * Este metodo devuelve el lugar
	 * @return lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Este metodo devuelve el pais
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Este metodo devuelve la duracion
	 * @return duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * Este metodo permite cambiar la duracion
	 * @param duracion nueva duracion
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Este metodo devuelve la lista de pilotos ordenados por posicion
	 * @return lista de pilotos
	 */
	public Lista<Piloto> getPilotos() {
		return pilotos;
	}

	/**
	 * Este metodo retorna la ruta de la imagen
	 * @return ruta de imagen
	 */
	public String getUrlImagen() {
		return urlImagen;
	}

	/**
	 * Este metodo retorna el id de la carrera
	 * @return id de carrera
	 */
	public String getCarreraId() {
		return carreraId;
	}

	@Override
	public int compareTo(Carrera o) {
		return nombre.compareTo(o.getNombre());
	}
	
	/**
	 * Elimina un piloto de la lista de pilotos segun el apellido dado por parametro
	 * @param apellido apellido de piloto a eliminar
	 */
	public void eliminarPiloto(String apellido)
	{
		pilotos.remove(new Piloto("", apellido, "", "", "", 0, 0, "", "", "", 0));
	}

}
