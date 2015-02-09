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

public class Temporada implements Comparable<Temporada>, Serializable {
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
	 * Este atributo representa si ya se cargaron los pilotos. Si hay un piloto
	 * borrado, es falso.
	 */
	private boolean pilotosCargados;

	/**
	 * Este atributo representa si ya se cargaron las carreras. Si hay una
	 * carrera borrada, es falso.
	 */
	private boolean carrerasCargadas;

	/**
	 * Este atributo representa si ya se cargaron las escuderias.
	 */
	private boolean escuderiasCargadas;

	/**
	 * El iterador de carreras
	 */
	private LlamaIterator<Carrera> itCarrera;

	/**
	 * El iterador de pilotos
	 */
	private LlamaIterator<Piloto> itPiloto;

	/**
	 * El iterador de escuderias
	 */
	private LlamaIterator<Escuderia> itEscuderia;

	// -----------------------------------------------------------------
	// Metodos Constructores
	// -----------------------------------------------------------------

	/**
	 * Este es el metodo constructor de la temporada
	 * 
	 * @param anho
	 *            -el año de la temporada
	 */
	public Temporada(int anho) {
		year = anho;
		pilotosCargados = false;
		carrerasCargadas = false;
		escuderiasCargadas = false;
		pilotos = new LlamaArrayList<Piloto>(60);
		escuderias = new LlamaArrayList<Escuderia>(60);
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
	 * 
	 * @param infoPilotos
	 *            informacion de los pilotos
	 */
	public void cargarPilotos(String[] infoPilotos) {
		if (!pilotosCargados) {
			for (String info : infoPilotos) {
				System.out.println("Loading: " + info);
				if (info != null) {
					double points = 0.0;
					int pos = -1;
					String[] infoP = info.split(";");
					if (!infoP[7].equals("null")) {
						points = Double.parseDouble(infoP[7]);
					}
					if (!infoP[8].equals("null")) {
						pos = Integer.parseInt(infoP[8]);
					}
					

					Piloto pilot = new Piloto(infoP[1], infoP[2], infoP[3],
							infoP[4], infoP[6], points, pos, infoP[9],
							infoP[0], infoP[5],infoP[10]);

					pilotos.addAlFinal(pilot);

					// sb.append(driverId);
					// sb.append(";");
					// sb.append(driver.getString("givenName"));
					// sb.append(";");
					// sb.append(driver.getString("familyName"));
					// sb.append(";");
					// sb.append(driver.getString("nationality"));
					// sb.append(";");
					// sb.append(driver.getString("dateOfBirth"));
					// sb.append(";");
					// sb.append(constructorId);
					// sb.append(";");
					// sb.append(constructorName);
					// sb.append(";");
					// sb.append(points);
					// sb.append(";");
					// sb.append(position);
					// sb.append(";");
//					sb.append(loc);
//					sb.append(";");
//					drivers[i] = sb.toString();
//					sb.setLength(0);
//					System.out.println(drivers[i]);
//					
				}
			}
		}

	}

	/**
	 * Este metodo carga las carreras de la temporada
	 * @param infoCarreras informacion carreras
	 */
	public void cargarCarreras(String[] infoCarreras) {
		int pos = 0;
		if (!carrerasCargadas) {
			for (String info : infoCarreras) {
				System.out.println("Loading:" + info);
				String[] infoC = info.split(";");

				Carrera race = new Carrera(infoC[2], pos, infoC[4], infoC[5],
						infoC[0], infoC[6], infoC[7], 0, infoC[8], infoC[1]);
				carreras.addAlFinal(race);

				// sb.append(circuitName);
				// sb.append(";");
				// sb.append(circuitId);
				// sb.append(";");
				// sb.append(raceName);
				// sb.append(";");
				// sb.append(round);
				// sb.append(";");
				// sb.append(date);
				// sb.append(";");
				// sb.append(time);
				// sb.append(";");
				// sb.append(locality);
				// sb.append(";");
				// sb.append(country);
				// sb.append(";");
				// sb.append(loc);
				pos++;
			}
		}
	}

	/**
	 * Este metodo carga las escudeias de la temporada
	 * 
	 * @param infoEscuderias
	 *            informacion escuderias
	 */
	public void cargarEscuderias(String[] infoEscuderias) {
		if (!escuderiasCargadas) {
			for (String info : infoEscuderias) {
				System.out.println("Loading: " + info);
				String[] infoE = info.split(";");
				int pos = 0;
				int points = 0;
				if (!infoE[3].equals("null")) {
					pos = Integer.parseInt(infoE[3]);
				}
				if (!infoE[4].equals("null")) {
					points = Integer.parseInt(infoE[4]);
				}
				Escuderia e = new Escuderia(infoE[5], infoE[1], infoE[2], pos,
						points, infoE[0]);
				escuderias.addAlFinal(e);
				// sb.append(constructorId);
				// sb.append(";");
				// sb.append(constructorName);
				// sb.append(";");
				// sb.append(constructorNationality);
				// sb.append(";");
				// sb.append(pos);
				// sb.append(";");
				// sb.append(points);
				// sb.append(";");
				// sb.append(loc);

				// TODO
				// Escuderia escu = new Escuderia(pUrlLogo, pNombre, pPais,
				// pPosFinal, pPuntos, pPilotos, pCarreras);
				// escuderias.addAlFinal(escu);
			}
		}
	}

	/**
	 * Devuelva la informacion de las escuderias
	 * @return info de las escuderias en String
	 */
	public String[] darInfoEscuderias() {
		String[] ret = new String[escuderias.size()];
		for (int i = 0; i < escuderias.size(); i++) {
			Escuderia e = escuderias.get(i);
			ret[i] = e.toString();
		}
		return ret;
	}

	/**
	 * Devuelva la informacion de las careras
	 * @return info de las carreras en String
	 */
	public String[] darInfoCircuitos() {
		String[] ret = new String[carreras.size()];
		for (int i = 0; i < carreras.size(); i++) {
			Carrera c = carreras.get(i);
			ret[i] = c.toString();
		}

		return ret;
	}

	/**
	 * Devuelva la informacion de las pilotos
	 * @return info de las pilotos en String
	 */
	public String[] darInfoPilotos() {
		String[] ret = new String[pilotos.size()];
		for (int i = 0; i < pilotos.size(); i++) {
			Piloto p = pilotos.get(i);
			ret[i] = p.toString();
		}
		return ret;
	}

	@Override
	public int compareTo(Temporada o) {
		if (getYear() == o.getYear()) {
			return 0;
		} else if (getYear() > o.getYear()) {
			return 1;
		} else {
			return -1;
		}

	}

	/**
	 * Da la siguiente carrera
	 * @return la siguiente carrera
	 * @throws Exception si no hay siguiente
	 */
	public Carrera darSiguienteCarrera() throws Exception {
		if (itCarrera.hasNext())
			return itCarrera.next();
		else
			throw new Exception("No hay siguiente");
	}

	/**
	 * Da la anterior carrera
	 * @return la anterior carrera
	 * @throws Exception si no hay anterior
	 */
	public Carrera darAnteriorCarrera() throws Exception {
		if (itCarrera.hasPrevious())
			return itCarrera.previous();
		else
			throw new Exception("No hay anterior");
	}

	/**
	 * Da el siguiente piloto
	 * @return el siguiente piloto
	 * @throws Exception si no hay siguiente
	 */
	public Piloto darSiguientePiloto() throws Exception {
		if (itPiloto.hasNext())
			return itPiloto.next();
		else
			throw new Exception("No hay siguiente");
	}

	/**
	 * Da el anterior piloto
	 * @return el anterior piloto
	 * @throws Exception si no hay anterior
	 */
	public Piloto darAnteriorPiloto() throws Exception {
		if (itPiloto.hasPrevious())
			return itPiloto.previous();
		else
			throw new Exception("No hay anterior");
	}

	/**
	 * Da la siguiente escuderia
	 * @return la siguiente escuderia
	 * @throws Exception si no hay siguiente
	 */
	public Escuderia darSiguienteEscuderia() throws Exception {
		if (itEscuderia.hasNext())
			return itEscuderia.next();
		else
			throw new Exception("No hay siguiente");

	}

	/**
	 * Da la anterior escuderia
	 * @return la anterior escuderia
	 * @throws Exception si no hay siguiente
	 */
	public Escuderia darAnteriorEscuderia() throws Exception {
		if (itEscuderia.hasPrevious())
			return itEscuderia.previous();
		else
			throw new Exception("No hay anterior");
	}

	/**
	 * Busca el piloto recibido por parametro en la lista de pilotos
	 * @param apellido el apellido del piloto a buscar
	 * @return piloto buscado o null si no existe
	 */
	public Piloto buscarPiloto(String apellido)
	{
		Piloto piloto = null;
		
		LlamaIterator<Piloto> it =pilotos.iterator();
		
		while(it.hasNext()&&piloto==null)
		{
			Piloto actual = it.next();
			if(apellido.equals(actual.getApellido()))
				piloto=actual;
		}
		return piloto;
	}
	
	/**
	 * Quita la información del piloto que recibe por parámetro
	 * @param apellido delp iloto a borrar
	 * @return piloto borrado o null si no existe
	 */
	public Piloto removePiloto(String apellido){
		
		Piloto pil = new Piloto("", apellido, "","", "", 0, 0, "", "", "","");
		return pilotos.remove(pil); 
	}
}