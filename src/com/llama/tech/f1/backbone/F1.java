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
import java.lang.reflect.Array;
import java.util.Arrays;

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

	private boolean carga;


	/**
	 * Este es el atributo que representa las temporadas de la base de datos
	 */
	private Temporada[] temporadas;

	private int min;
	private int max;

	public F1()
	{
		
	}
	public F1(int pMin, int pMax) throws Exception
	{
		min=pMin;
		max = pMax;
		cargarTemporadas();
		temporadas = Arrays.copyOfRange(temporadas, pMin-1950, pMax-1950+1); 
		for (int i = 0; i < temporadas.length; i++) {
			cargar(temporadas[i].getYear());
		}

	}



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
		temporadas = new Temporada[pTemporadas.length];
		int i = 0;
		for	(String s:pTemporadas){
			Temporada t = new Temporada(Integer.parseInt(s));
			temporadas[i] = t;
			i++;
		}
	}

	public void cargarCarrerasTemporada(int anho) throws Exception
	{
		String[]infoCarreras = Query.getCircuitsSeason(""+anho);
		temporadas[anho-min].cargarCarreras(infoCarreras);
	}

	public void cargarPilotosTemporada(int anho) throws Exception
	{
		String[]infoPilotos = Query.getDriversSeason(""+anho);
		temporadas[anho-min].cargarPilotos(infoPilotos);
	}

	public void cargarEscuderiasTemporada(int anho) throws Exception
	{
		String[]infoEscuderias = Query.getConstructorsSeason(""+anho);
		temporadas[anho-min].cargarEscuderias(infoEscuderias);
	}

	@Override
	public String[] darTemporadasCompletas() {
		try {
			return Query.getTotalSeasons();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return new String[]{""};
		}
	}

	@Override
	public void cargar(int anho) throws Exception {
		// TODO Auto-generated method stub
		cargarCarrerasTemporada(anho);
		cargarEscuderiasTemporada(anho);
		cargarPilotosTemporada(anho);

	}



	@Override
	public String[] darInfoCarreras(int anho) {
		return temporadas[anho-min].darInfoCircuitos();
	}



	@Override
	public String[] darInfoPilotos(int anho) {
		return temporadas[anho-min].darInfoPilotos();
	}



	@Override
	public String[] darInfoEscuderias(int anho) {
		return temporadas[anho-min].darInfoCircuitos();
	}

	public static IF1 cargarF1()
	{
		return Query.cargar();
	}

	public Piloto darAnteriorPiloto(int anho) throws Exception
	{
		return temporadas[anho-min].darAnteriorPiloto();
	}

	public Piloto darSiguientePiloto(int anho) throws Exception
	{
		return temporadas[anho-min].darSiguientePiloto();
	}

	public Carrera darAnteriorCarrera(int anho) throws Exception
	{
		return temporadas[anho-min].darAnteriorCarrera();
	}

	public Carrera darSiguienteCarrera(int anho) throws Exception
	{
		return temporadas[anho-min].darSiguienteCarrera();
	}

	public Escuderia darAnteriorEscuderia(int anho) throws Exception
	{
		return temporadas[anho-min].darAnteriorEscuderia();
	}

	public Escuderia darSiguienteEscuderia(int anho) throws Exception
	{
		return temporadas[anho-min].darSiguienteEscuderia();
	}
	
	public Temporada darTemporada(int anho)
	{
		System.out.println(anho-min + " "+ temporadas.length);
		return temporadas[anho-min];
	}
	
	public Temporada[] darTemporadas()
	{
		return temporadas;
	}


}
