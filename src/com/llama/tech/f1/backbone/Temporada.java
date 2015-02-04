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

public class Temporada implements Serializable 
{
	private Lista<Carrera> carreras;
	private Lista<Piloto> pilotos;
	private Lista<Escuderia> escuderias;
	private int year;
	private boolean pilotoBorrado;
	private boolean carreraBorrada;


	public void cargarPilotos(String[] infoPilotos)
	{
		for(String info:infoPilotos)
		{
			String[] infoP = info.split(";");
			Piloto pilot = new Piloto(nombre, nacionalidad, fechaNac, escuderia, puntos, posFinal, posicion, estado, estadistica, urlImagen)
			pilotos.addAlFinal(pilot);
		}

	}
	
	public void cargarCarreras(String[] infoCarreras)
	{
		for(String info:infoPilotos)
		{
			String[] infoP = info.split(";");
			Piloto pilot = new Piloto(nombre, nacionalidad, fechaNac, escuderia, puntos, posFinal, posicion, estado, estadistica, urlImagen)
			pilotos.addAlFinal(pilot);
		}
	}






}
