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
	private String[] pilotos;
	
	/**
	 * Este es el atributo que representa las carreras de la escuderia
	 */
	private String[] carreras;
	
	/**
	 * Este es el atributo que representa el id de la escuderia
	 */
	private String id;
    // -----------------------------------------------------------------
 	// Metodos Construcotres
 	// -----------------------------------------------------------------
    
	/**
	 * 
	 * @param pUrlLogo
	 * @param pNombre
	 * @param pPais
	 * @param pPosFinal
	 * @param pPuntos
	 * @param pPilotos
	 * @param pCarreras
	 * @param pId
	 */
	public Escuderia(String pUrlLogo, String pNombre, String pPais, int pPosFinal, int pPuntos, String pId)
	{
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
     * Este método transforma la informacion a una cadena de carácteres separada por ";" para enviarla en el siguiente orden:
     * id;nombre;pais;posFinal;puntos;pilotos...;carreras...;urlLogo
     * @return cadena de caracteres con informacion
     */
    public String toString()
    {
    	StringBuilder s = new StringBuilder(512);
    	s.append(id+";"+nombre+";"+pais+";"+posFinal+";"+puntos+";");
    	for(String c:pilotos)
    	{
    		s.append(c+";");
    	}
    	for(String c:carreras)
    	{
    		s.append(c+";");
    	}
    	s.append(urlLogo);
    	
    	return s.toString();
    }

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPosFinal() {
		return posFinal;
	}

	public void setPosFinal(int posFinal) {
		this.posFinal = posFinal;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String[] getPilotos() {
		return pilotos;
	}

	public void setPilotos(String[] pilotos) {
		this.pilotos = pilotos;
	}

	public String[] getCarreras() {
		return carreras;
	}

	public void setCarreras(String[] carreras) {
		this.carreras = carreras;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int compareTo(Escuderia o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
