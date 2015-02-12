/*
 * Piloto.java
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
import java.util.Arrays;

import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;

/**
 * Esta es la clase que modela a los pilotos
 */
public class Piloto implements Serializable, Comparable<Piloto> 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Este es el atributo que representa el nombre del piloto
	 */
	private String nombre;

	/**
	 * Este es el atributo que representa el apellido del piloto
	 */
	private String apellido;

	/**
	 * Este es el atributo que representa la nacionalidad del piloto
	 */
	private String nacionalidad;

	/**
	 * Este es el atributo que representa la fecha de nacimiento del piloto
	 */
	private String fechaNac;

	/**
	 * Este es el atributo que representa la escudería del piloto
	 */
	private String escuderia;

	/**
	 * Este es el atributo que representa los puntos del piloto
	 */
	private double puntos;

	/**
	 * Este es el atributo que representa la posicion final del piloto
	 */
	private int posFinal;

	/**
	 * Este es el atributo donde se guarda el url de la imagen del piloto
	 */
	private String urlImagen;

	/**
	 * Este es el atributo que representa el id del conductor
	 */
	private String driverId;

	/**
	 * Este es el atributo que representa el 
	 */
	private String escuderiaId;

	/**
	 * Este es el atributo que 
	 */
	private Lista<InfoCarrera> infoCarreras;

	private int totalCarreras;


	// -----------------------------------------------------------------
	// Metodos Constructores
	// -----------------------------------------------------------------

	/**
	 * Este es el constructor de la clase piloto. Crea un piloto con todos sus atributos.
	 * @param nombre Nombre de pila del piloto
	 * @param apellido Apellido del piloto	
	 * @param nacionalidad Nacionalidad del piloto	
	 * @param fechaNac Fecha de naciemiento del piloto	
	 * @param escuderia Escudería a la que pertenecer el piloto
	 * @param puntos Puntos acumulados del piloto en la temporada
	 * @param posFinal
	 * @param urlImagen
	 * @param driverId
	 * @param escuderiaId
	 * @param pInfoCarreras
	 * @param pTotalCarreras
	 */
	public Piloto(String pnombre, String papellido, String pnacionalidad,
			String pfechaNac, String pescuderia, double ppuntos, int pposFinal,
			String purlImagen, String pdriverId, String pescuderiaId, int pTotalCarreras) 
	{
		this.nombre = pnombre;
		this.apellido = papellido;
		this.nacionalidad = pnacionalidad;
		this.fechaNac = pfechaNac;
		this.escuderia = pescuderia;
		this.puntos = ppuntos;
		this.posFinal = pposFinal;
		this.urlImagen = purlImagen;
		this.driverId = pdriverId;	
		this.escuderiaId = pescuderiaId;
		infoCarreras = new LlamaArrayList<InfoCarrera>(20);
		totalCarreras=pTotalCarreras;


		for(int i=0;i<totalCarreras;i++)
		{
			infoCarreras.addAlFinal(new InfoCarrera());
		}



		//		nombre; ... ; URL;"carrera1id%t1%t2%...%tn"$"vuelta:t%vuelta2:t%vueltan:tn" |
		//		"carrera2id%..."%...|. 
	}




	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------


	/**
	 * Este método devuelve el nombre del piloto
	 * @return nombre del piloto
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * Este metodo devuelve el apellido del pilto
	 * @return apellido del piloto
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Este metodo devuelve la nacionalidad del piloto
	 * @return nacionalidad del piloto
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * Este metodo devuelve la fecha de nacimiento del piloto
	 * @return fecha de nacimiento en formato dd-mm-aaaa
	 */
	public String getFechaNac() {
		return fechaNac;
	}

	/**
	 * Este metodo devuelve la escuderia a la que pertenece el piloto
	 * @return escuderia del piloto
	 */
	public String getEscuderia() {
		return escuderia;
	}

	/**
	 * Este metodo devuelve el total de puntos del piloto en la temporada
	 * @return puntos en la temporada
	 */
	public double getPuntos() {
		return puntos;
	}


	/**
	 * Este metodo devuelve el url de la imagen
	 * @return url de la imagen
	 */
	public String getUrlImagen() {
		return urlImagen;
	}

	/**
	 * Este metodo devuelve el id del piloto
	 * @return id piloto
	 */
	public String getDriverId() {
		return driverId;
	}

	/**
	 * Este metodo devuelve el id de la escuderia del piloto
	 * @return id de escuderia del piloto
	 */
	public String getEscuderiaId() {
		return escuderiaId;
	}

	/**
	 * Este metodo retorna la posicion general del piloto en la temporada
	 * @return posicion final iloto
	 */
	public int getPosFinal() {
		return posFinal;
	}
	

	
	@Override 
	public String toString()
	{
		StringBuilder s = new StringBuilder(512);
		s.append(nombre+" "+apellido);
		return s.toString();
	}

	@Override
	public boolean equals(Object o)
	{
		return compareTo((Piloto) o) == 0;
	}

	@Override
	public int compareTo(Piloto o)
	{
		String pApellido1 = apellido.toLowerCase();
		String pApellido2 = o.getApellido().toLowerCase();

		return pApellido1.compareTo(pApellido2);

	}

	/**
	 * Este método actualiza la información de una carrera dada por parámetro
	 * @param numCarrera numero de carrera a actualizar
	 * @param idCarrera id de carrera a actualizar
	 * @param puntosCarrera puntos de carrera a actualizar
	 * @param posicion posicion  de carrera a actualizar
	 * @param vueltasLaps vueltas de de carrera a actualizar
	 * @param bestTime mejor tiempo de de carrera a actualizar
	 * @param avgSpeed velocidad promedio de carrera a actualizar
	 * @param estado estado del piloto  de carrera a actualizar
	 */
	public void setInfoCarrera(int numCarrera, String idCarrera, double puntosCarrera,
			String posicion, int vueltasLaps, String bestTime, String avgSpeed, String estado)
	{
		InfoCarrera usar = infoCarreras.get(numCarrera-1);
		usar.setPoints(puntosCarrera);
		usar.setIdCarrera(idCarrera);
		usar.setPosicion(posicion);
		usar.setVueltasCompletadas(vueltasLaps);
		usar.setBestTime(bestTime);
		usar.setAvgSpeed(avgSpeed);
		usar.setEstado(estado);
	}


	/**
	 * Da los puntos de una carrera dada por parametro
	 * @param numCarrera carrera de averiguar
	 * @return puntos de una carrera dada por parametro
	 */
	public double darPuntosCarrera(int numCarrera)
	{
		return infoCarreras.get(numCarrera-1).getPoints();
	}

	/**
	 * Da la posicion de una carrera dada por parametro
	 * @param numCarrera carrera de averiguar
	 * @return posicion de una carrera dada por parametro
	 */
	public String darPosicionCarrera(int numCarrera)
	{
		return infoCarreras.get(numCarrera-1).getPosicion();
	}
	
	/**
	 * Da las vueltas de una carrera dada por parametro
	 * @param numCarrera carrera de averiguar
	 * @return vueltas de una carrera dada por parametro
	 */
	public int darVueltas(int numCarrera)
	{
		return infoCarreras.get(numCarrera-1).getVueltasCompletadas();
	}
	
	/**
	 * Da el mejor tiempo de una carrera dada por parametro
	 * @param numCarrera carrera de averiguar
	 * @return mejor tiempo de una carrera dada por parametro
	 */
	public String darBestTime(int numCarrera)
	{
		return infoCarreras.get(numCarrera-1).getBestTime();
	}
	
	/**
	 * Da la velocidad promedio de una carrera dada por parametro
	 * @param numCarrera carrera a averiguar
	 * @return velocidad promedio de una carrera dada por parametro
	 */
	public String darAvgSpeed(int numCarrera)
	{
		return infoCarreras.get(numCarrera-1).getAvgSpeed();
	}
	
	/**
	 * Da el estado de una carrera dada por parametro
	 * @param numCarrera carrera a averiguar
	 * @return estado de una carrera dada por parametro
	 */
	public String darEstado(int numCarrera)
	{
		return infoCarreras.get(numCarrera-1).getEstado();
	}



}
