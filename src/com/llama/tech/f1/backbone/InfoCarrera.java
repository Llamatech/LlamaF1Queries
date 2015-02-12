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
     private String id;
     private double points;
     private String posicion;
     private int vueltasCompletadas;
     private String bestTime;
     private String avgSpeed;
     private String estado;

     
     public String getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(String avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBestTime() {
		return bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	public int getVueltasCompletadas() {
		return vueltasCompletadas;
	}

	public void setVueltasCompletadas(int vueltasCompletadas) {
		this.vueltasCompletadas = vueltasCompletadas;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

//	public InfoCarrera(String id)
//     {
//    	 this.id = id;
//
//    	 
//    	
//
//     }
     
     public InfoCarrera()
     {
    	 
     }
     
     public void setPoints(double points)
     {
    	 this.points = points;
     }
     
     public double getPoints()
     {
    	 return points;
     }
     
     public String getPosicion()
     {
    	 return posicion;
     }
     
     public void setIdCarrera(String idCarrera)
     {
    	 id = idCarrera;
     }
}
