/*
 * F1.java
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

import com.llama.tech.f1.query.Query;
import com.llama.tech.utils.list.Lista;

/**
 * Esta es la clase principal del mundo y modela la base de datos de fórmula1
 */
public class F1 implements IF1, Serializable
{
	/**
	 *  Constante de Serialización. 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Este es el atributo que representa las temporadas de la base de datos
	 */
	private Lista<Temporada> temporadas;

	

	@Override
	public boolean deletePilotRecord(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCircuitRecord(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getSeasonInfo(String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSeasonList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getCircuitInfo(String name, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getPilotInfo(String name, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getConstructorInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getHistoricalSeasonInfo(String initialDate,
			String finalDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cargarTemporadas() throws IOException 
	{
	    String[] pTemporadas =  Query.getTotalSeasons();
		for	(String s:pTemporadas){
			Temporada t = new Temporada(Integer.parseInt(s));
			temporadas.addAlFinal(t);
		}
	}
	
	public void cargarCarrerasTemporada(int anho) throws IOException
	{
		String[]infoCarreras = Query.getCircuitsSeason(""+anho);
		temporadas.get(anho-1950).cargarCarreras(infoCarreras);
	}
	
	public void cargarPilotosTemporada(int anho) throws IOException
	{
		String[]infoPilotos = Query.getDriversSeason(""+anho);
		temporadas.get(anho-1950).cargarPilotos(infoPilotos);
	}
	
	public void cargarEscuderiasTemporada(int anho) throws IOException
	{
		String[]infoEscuderias = Query.getConstructorsSeason(""+anho);
		temporadas.get(anho-1950).cargarEscuderias(infoEscuderias);
	}

	@Override
	public String[] darTemporadas() {
		try {
			return Query.getTotalSeasons();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return new String[]{""};
		}
	}

	@Override
	public void cargar(String tipo, int anho) throws IOException {
		// TODO Auto-generated method stub
		if(tipo.equals("Pilotos"))
		{
			cargarPilotosTemporada(anho);
		}
		else if(tipo.equals("Carreras))
		
	}
}
