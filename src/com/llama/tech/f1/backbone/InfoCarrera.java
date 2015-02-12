/*
 * InfoCarrera.java
 * This file is part of F1ChampionshipQueries
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
 * 
 */

package com.llama.tech.f1.backbone;

import java.io.Serializable;


public class InfoCarrera implements Serializable
{
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Atributo que modela el id de la carrera
	 */
     private String id;
     
     /**
 	 * Atributo que modela el points de la carrera
 	 */
     private double points;
     
     /**
 	 * Atributo que modela el posicion de la carrera
 	 */
     private String posicion;
     
     /**
 	 * Atributo que modela el vueltas completadas de la carrera
 	 */
     private int vueltasCompletadas;
     
     /**
 	 * Atributo que modela el mejor tiempo de la carrera
 	 */
     private String bestTime;
     
     /**
 	 * Atributo que modela la velocidad promedio de la carrera
 	 */
     private String avgSpeed;
     
     /**
 	 * Atributo que modela el estado de la carrera
 	 */
     private String estado;

  // -----------------------------------------------------------------
 	// Metodos Constructores
 	// -----------------------------------------------------------------

     /**
      * Retorna la velocidad promedio
      * @return volcidad promedio
      */
     public String getAvgSpeed() {
		return avgSpeed;
	}

     /**
      * Permite cambiar la velocidad promedio
      * @param avgSpeed nueva velocidad promedio
      */
	public void setAvgSpeed(String avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	/**
	 * Devuelve el estado de la carrera
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Permite poner un nuevo estado
	 * @param estado nuevo estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * retorna el mejor tiempo de la carrera
	 * @return mejor timepo
	 */
	public String getBestTime() {
		return bestTime;
	}

	/**
	 * Permite poner un nuevo mejor tiempo
	 * @param bestTime nuevo mejor tiempo
	 */
	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	/**
	 * Devuelve el numero de vueltas
	 * @return numero de vueltas
	 */
	public int getVueltasCompletadas() {
		return vueltasCompletadas;
	}

	/**
	 * permite poner un nuevo numero de vueltas
	 * @param vueltasCompletadas nuevo numero de vueltas
	 */
	public void setVueltasCompletadas(int vueltasCompletadas) {
		this.vueltasCompletadas = vueltasCompletadas;
	}

	/**
	 * Permite cambiar la posicion
	 * @param posicion nueva posicion
	 */
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	/**
	 * Metodo constructo de info carrera
	 * pos: se crea un nuevo infocarrera sin informacion
	 */
     public InfoCarrera()
     {
    	 
     }
     /**
      * Permite cambiar los punots
      * @param points nuevos puntos
      */
     public void setPoints(double points)
     {
    	 this.points = points;
     }
     
     /**
      * Devuleve los puntos
      * @return puntos
      */
     public double getPoints()
     {
    	 return points;
     }
     
     /**
      * Retorna la posicion
      * @return posicion
      */
     public String getPosicion()
     {
    	 return posicion;
     }
     
     /**
      * Permite cambiar el id de la carrera
      * @param idCarrera nuevo id
      */
     public void setIdCarrera(String idCarrera)
     {
    	 id = idCarrera;
     }
}
