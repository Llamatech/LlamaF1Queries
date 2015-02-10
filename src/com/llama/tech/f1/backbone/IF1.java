/*
 * IF1.java
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

import java.io.IOException;
import java.io.Serializable;

import com.llama.tech.utils.list.Lista;

public interface IF1 extends Serializable
{	
	public String[] getSeasonInfo(String year);
	
	public String[] getSeasonList();
	
	public String[] getCircuitInfo(String name, String year);
	
	public String[] getPilotInfo(String name, String year);
	
	public String[] getConstructorInfo(String name);
	
	public Lista<Carrera> getHistoricalSeasonInfo(String initialDate, String finalDate) throws Exception;
	
	public boolean deletePilotRecord(String name);
	
	public boolean deleteCircuitRecord(String name);
	
	public String[] darTemporadasCompletas();
	
	public void cargar(int anho) throws Exception;
	
	public String[] darInfoCarreras(int anho);
	
	public String[] darInfoPilotos(int anho);
	
	public String[] darInfoEscuderias(int anho);
	
	public Piloto darAnteriorPiloto(int anho) throws Exception;

	public Piloto darSiguientePiloto(int anho) throws Exception;

	public Carrera darAnteriorCarrera(int anho) throws Exception;

	public Carrera darSiguienteCarrera(int anho) throws Exception;
	
	public Escuderia darAnteriorEscuderia(int anho) throws Exception;
	
	public Escuderia darSiguienteEscuderia(int anho) throws Exception;
	
	public Temporada darTemporada(int anho);
	
	public Temporada[] darTemporadas();

	
}
