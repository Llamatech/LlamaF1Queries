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
     * Este es el atributo que representa la lista de posiciones de los participantes
     */
    private String[] posiciones;
    
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
    public Carrera(String pNombre,String[] pPosiciones, int pNumeroCarrera, String pFecha, String pHora, String pCircuito, String pLugar, String pPais, int pDuracion, String pUrlImagen, String pCarreraId, Lista<Piloto> pPilotos )
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
    	pilotos = pPilotos;
    	
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
    	s.append(nombre+";"+numeroCarrera+";"+fecha+";"+hora+";"+circuito+";"+lugar+";"+pais+";");
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
	 * 
	 * @return
	 */
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String[] getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(String[] posiciones) {
		this.posiciones = posiciones;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(String carreraId) {
		this.carreraId = carreraId;
	}

	@Override
	public int compareTo(Carrera o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
