/*
 * Temporada.java
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

import com.llama.tech.f1.utils.Lista;

/**
 * Esta es la clase que modela la Temporada
 */
public class Temporada implements Serializable 
{
	/**
	 * Constante para la serialización
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Este atributo representa la lista de carreras del año
	 */
	private Lista<Carrera> carreras;

	/**
	 * Este atributo representa la lista de pilotos del año
	 */
	private Lista<Piloto> pilotos;

	/**
	 * Este atributo representa la lista de escuderias del año
	 */
	private Lista<Escuderia> escuderias;

	/**
	 * este atributo representa el año de la temporada
	 */
	private int year;

	/**
	 * este atributo representa si se han borrado o no pilotos
	 */
	private boolean pilotoBorrado;

	/**
	 * Este atributo representa si se han borrado o no carreras
	 */
	private boolean carreraBorrada;


	// -----------------------------------------------------------------
	// Metodos Constructores
	// -----------------------------------------------------------------

	/**
	 * Este es el metodo constructor de la temporada
	 * @param anho -el año de la temporada
	 */
	public Temporada(int anho)
	{
		year= anho;
		pilotoBorrado=false;
		carreraBorrada=false;
	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Este metodo carga los pilotos de la temporada
	 * @param infoPilotos informacion de los pilotos
	 */
	public void cargarPilotos(String[] infoPilotos)
	{
		for(String info:infoPilotos)
		{
			String[] infoP = info.split(";");
			//TODO
			Piloto pilot = new Piloto(nombre, nacionalidad, fechaNac, escuderia, puntos, posFinal, posicion, estado, estadistica, urlImagen);
			pilotos.addAlFinal(pilot);
		}

	}

	/**
	 * Este metodo carga las carreras de la temporada
	 * @param infoCarreras informacion carreras
	 */
	public void cargarCarreras(String[] infoCarreras)
	{
		for(String info:infoCarreras)
		{
			String[] infoC = info.split(";");
			Carrera race = new Carrera(pNombre, pNumeroCarrera, pFecha, pHora, pCircuito, pLugar, pPais, pPosiciones, pDuracion, pUrlImagen);
			carreras.addAlFinal(race);
		}
	}

	/**
	 * Este metodo carga las escudeias de la temporada
	 * @param infoEscuderias informacion escuderias
	 */
	public void cargarEscuderias(String[] infoEscuderias)
	{
		for(String info:infoEscuderias)
		{
			String[] infoE = info.split(";");
			Escuderia escu = new Escuderia(pUrlLogo, pNombre, pPais, pPosFinal, pPuntos, pPilotos, pCarreras);
			escuderias.addAlFinal(escu);
		}
	}






}
