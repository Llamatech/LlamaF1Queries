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

import com.llama.tech.utils.list.LlamaArrayList;
import com.llama.tech.utils.list.LlamaArrayList.MyIterator;
import com.llama.tech.utils.list.LlamaIterator;
import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.ListaDoblementeEnlazada;






public class Temporada implements Comparable<Temporada>, Serializable 
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
	 * Este atributo representa el año de la temporada
	 */
	private int year;

	/**
	 * Este atributo representa si ya se cargaron los pilotos. Si hay un piloto borrado, es falso.
	 */
	private boolean pilotosCargados;

	/**
	 * Este atributo representa si ya se cargaron las carreras. Si hay una carrera borrada, es falso.
	 */
	private boolean carrerasCargadas;

	/**
	 * Este atributo representa si ya se cargaron las escuderias. 
	 */
	private boolean escuderiasCargadas;

	private LlamaIterator<Carrera> itCarrera;

	private LlamaIterator<Piloto> itPiloto;

	private LlamaIterator<Escuderia> itEscuderia;




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
		pilotosCargados=false;
		carrerasCargadas=false;
		escuderiasCargadas= false;
		pilotos= new LlamaArrayList<Piloto>();
		escuderias = new LlamaArrayList<Escuderia>();
		carreras = new ListaDoblementeEnlazada<Carrera>();
		itCarrera = carreras.iterator();
		itPiloto = pilotos.iterator();
		itEscuderia = escuderias.iterator();
	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	public Lista<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(Lista<Carrera> carreras) {
		this.carreras = carreras;
	}

	public Lista<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(Lista<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	public Lista<Escuderia> getEscuderias() {
		return escuderias;
	}

	public void setEscuderias(Lista<Escuderia> escuderias) {
		this.escuderias = escuderias;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isPilotosCargados() {
		return pilotosCargados;
	}

	public void setPilotosCargados(boolean pilotosCargados) {
		this.pilotosCargados = pilotosCargados;
	}

	public boolean isCarrerasCargadas() {
		return carrerasCargadas;
	}

	public void setCarrerasCargadas(boolean carrerasCargadas) {
		this.carrerasCargadas = carrerasCargadas;
	}

	public boolean isEscuderiasCargadas() {
		return escuderiasCargadas;
	}

	public void setEscuderiasCargadas(boolean escuderiasCargadas) {
		this.escuderiasCargadas = escuderiasCargadas;
	}

	/**
	 * Este metodo carga los pilotos de la temporada
	 * @param infoPilotos informacion de los pilotos
	 */
	public void cargarPilotos(String[] infoPilotos)
	{
		if(!pilotosCargados){
			for(String info:infoPilotos)
			{
				System.out.println("Loading: "+info);
				if(info!=null)
				{
				String[] infoP = info.split(";");
				Piloto pilot = new Piloto(infoP[1], infoP[2], infoP[3], infoP[4], infoP[6], 
						Integer.parseInt(infoP[7]), Integer.parseInt(infoP[7]), 
						infoP[8], infoP[0], infoP[5]);
				
				pilotos.addAlFinal(pilot);
				}
			}
		}

	}

	/**
	 * Este metodo carga las carreras de la temporada
	 * @param infoCarreras informacion carreras
	 */
	public void cargarCarreras(String[] infoCarreras)
	{
		int pos = 0;
		if(!carrerasCargadas){
			for(String info:infoCarreras)
			{
				String[] infoC = info.split(";");
				

								Carrera race = new Carrera(infoC[2], pos, infoC[4], infoC[5], 
										                   infoC[0], infoC[6], infoC[7],
										                   0 , infoC[8],infoC[1]);
								carreras.addAlFinal(race);

				//				sb.append(circuitName);
				//				sb.append(";");
				//				sb.append(circuitId);
				//				sb.append(";");
				//				sb.append(raceName);
				//				sb.append(";");
				//				sb.append(round);
				//				sb.append(";");
				//				sb.append(date);
				//				sb.append(";");
				//				sb.append(time);
				//				sb.append(";");
				//				sb.append(locality);
				//				sb.append(";");
				//				sb.append(country);
				//				sb.append(";");
				//				sb.append(loc);
			pos++;
			}
		}
	}

	/**
	 * Este metodo carga las escudeias de la temporada
	 * @param infoEscuderias informacion escuderias
	 */
	public void cargarEscuderias(String[] infoEscuderias)
	{
		if(!escuderiasCargadas){
			for(String info:infoEscuderias)
			{
				String[] infoE = info.split(";");
				int pos = 0;
				int points = 0;
				if(!infoE[3].equals("null"))
				{
					pos = Integer.parseInt(infoE[3]);
				}
				if(!infoE[4].equals("null"))
				{
					points = Integer.parseInt(infoE[4]);
				}
				Escuderia e = new Escuderia(infoE[5], infoE[1], infoE[2], 
						                    pos, points, infoE[0]);
				escuderias.addAlFinal(e);
//				sb.append(constructorId);
//				sb.append(";");
//				sb.append(constructorName);
//				sb.append(";");
//				sb.append(constructorNationality);
//				sb.append(";");
//				sb.append(pos);
//				sb.append(";");
//				sb.append(points);
//				sb.append(";");
//				sb.append(loc);
				
				
				//TODO
				//				Escuderia escu = new Escuderia(pUrlLogo, pNombre, pPais, pPosFinal, pPuntos, pPilotos, pCarreras);
				//				escuderias.addAlFinal(escu);
			}
		}
	}

	public String[] darInfoEscuderias()
	{
		String[] ret = new String[escuderias.size()];
		for(int i = 0; i < escuderias.size(); i++)
		{
			Escuderia e = escuderias.get(i);
			ret[i] = e.toString();
		}
		return ret;
	}

	public String[] darInfoCircuitos()
	{
		String[] ret = new String[carreras.size()];
		for(int i = 0; i < carreras.size(); i++)
		{
			Carrera c = carreras.get(i);
			ret[i] = c.toString();
		}

		return ret;
	}

	public String[] darInfoPilotos()
	{
		String[] ret = new String[pilotos.size()];
		for(int i = 0; i < pilotos.size(); i++)
		{
			Piloto p = pilotos.get(i);
			ret[i] = p.toString();
		}
		return ret;
	}

	@Override
	public int compareTo(Temporada o) 
	{
		if(getYear() == o.getYear())
		{
			return 0;
		}
		else if(getYear() > o.getYear())
		{
			return 1;
		}
		else
		{
			return -1;
		}

	}

	public Carrera darSiguienteCarrera() throws Exception
	{
		if(itCarrera.hasNext())
			return itCarrera.next();
		else
			throw new Exception("No hay siguiente");
	}

	public Carrera darAnteriorCarrera() throws Exception
	{
		if(itCarrera.hasPrevious())
			return itCarrera.previous();
		else
			throw new Exception("No hay anterior");
	}

	public Piloto darSiguientePiloto() throws Exception
	{
		if(itPiloto.hasNext())
			return itPiloto.next();
		else
			throw new Exception("No hay siguiente");
	}

	public Piloto darAnteriorPiloto() throws Exception
	{
		if(itPiloto.hasPrevious())
			return itPiloto.previous();
		else
			throw new Exception("No hay anterior");
	}

	public Escuderia darSiguienteEscuderia() throws Exception
	{
		if(itEscuderia.hasNext())
			return itEscuderia.next();
		else
			throw new Exception("No hay siguiente");

	}

	public Escuderia darAnteriorEscuderia() throws Exception
	{
		if(itEscuderia.hasPrevious())
			return itEscuderia.previous();
		else
			throw new Exception("No hay anterior");
	}






}