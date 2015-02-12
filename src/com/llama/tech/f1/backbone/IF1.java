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

/**
 * Esta es la interfaz del modelo del mundo
 */
public interface IF1 extends Serializable
{	
	/**
	 * Muestra las carreras desde una fecha inciial hasta una fecha final
	 * @param initialDate fecha incio periodo busqueda
	 * @param finalDate fecha fin periodo busqueda
	 * @return lista con todas las carreras dentro de ese periodo
	 * @throws Exception si se solicita un año no disponible
	 */
	public Lista<Carrera> getHistoricalSeasonInfo(String initialDate, String finalDate) throws Exception;
	
	/**
	 * Borra un piloto del sistema
	 * @param apellido apellido del piloto a borrar
	 */
	public void deletePilotRecord(String apellido);
	
	/**
	 * Borra un circuito del sistema
	 * @param nombre del circuito a eliminar
	 */
	public void deleteCircuitRecord(String nombre);
	
	/**
	 * Da las temporadas completas
	 * @return temporadas
	 */
	public String[] darTemporadasCompletas();
	
	/**
	 * carga de query la info necesaria
	 * @param anho año a cargar iinfo
	 * @throws Exception si hay un error cargando la info
	 */
	public void cargar(int anho) throws Exception;
		
	/**
	 * Da el anterior piloto de una temporada especifica
	 * @param anho temporada de la que se requiere el piloto
	 * @return piloto anterior
	 * @throws Exception si no hay anterior
	 */
	public Piloto darAnteriorPiloto(int anho) throws Exception;

	/**
	 * Da el siguiente piloto de una temporada especifica
	 * @param anho temporada de la que se requiere el piloto
	 * @return piloto siguiente
	 * @throws Exception si no hay siguiente
	 */
	public Piloto darSiguientePiloto(int anho) throws Exception;

	/**
	 * Da el anterior carrera de una temporada especifica
	 * @param anho temporada de la que se requiere el piloto
	 * @return carrera anterior
	 * @throws Exception si no hay anterior
	 */
	public Carrera darAnteriorCarrera(int anho) throws Exception;
	/**
	 * Da  siguiente carrera de una temporada especifica
	 * @param anho temporada de la que se requiere la carrera
	 * @return carrera siguiente
	 * @throws Exception si no hay siguiente
	 */
	public Carrera darSiguienteCarrera(int anho) throws Exception;
	/**
	 * Da anterior escudera de una temporada especifica
	 * @param anho temporada de la que se requiere la escuderia
	 * @return escuderia anterior
	 * @throws Exception si no hay anterior
	 */
	public Escuderia darAnteriorEscuderia(int anho) throws Exception;
	/**
	 * Da el siguiente escuderia de una temporada especifica
	 * @param anho temporada de la que se requiere la escuderia
	 * @return escuderia siguiente
	 * @throws Exception si no hay siguiente
	 */
	public Escuderia darSiguienteEscuderia(int anho) throws Exception;
	
	/**
	 * Devuelve una temporada segun su año
	 * @param anho 
	 * @return temporada de ese año
	 */
	public Temporada darTemporada(int anho);
	
	/**
	 * Retorna todas las temporadas
	 * @return arreglo de temporadas
	 */
	public Temporada[] darTemporadas();
	
	/**
	 * Retorna el piloto de la tmeporada que s ebusca
	 * @param anho donde se busca
	 * @param pApellido del piloto
	 * @return piloto con el apellido o null si no existe
	 */
	public Piloto buscarPiloto(int anho, String pApellido);
	
	/**
	 * Retorna el piloto de la tmeporada que s ebusca
	 * @param anho donde se busca
	 * @param pApellido del piloto
	 * @return piloto con el apellido o null si no existe
	 */
	public Escuderia buscarEscuderia(int anho, String pNombre);
	
	/**
	 * Da la informacion de la carrera  en un año
	 * @param numCarrera la carrera
	 * @param anho el año
	 * @return matriz con la informacion de llegada de pilotos
	 */
	public String[][] darPilotosCarrera(int numCarrera, int anho);
	
	/**
	 * Devuelve la lista de todas las carreras de una temporada
	 * @param anho temporada a buscar
	 * @return lista de carreras
	 */
	public Lista<Carrera >darCarrerasTemporada(int anho);
	
	/**
	 * Devuelve la lista de todos los pilotos de iuna temporada
	 * @param anho temporada a buscar
	 * @return lista de pilotos
	 */
	public Lista <Piloto >darPilotosTemporada(int anho);
	
	/**
	 * Devuelve la lista de todas las escuderias de una temporada
	 * @param anho temporada a buscar
	 * @return lista de escuderias
	 */
	public Lista<Escuderia> darEscuderiasTemporada(int anho);
	
	/**
	 * Da la carrera con mayor duracion de un año específico
	 * @param anho amho de búsqueda
	 * @return carrera con mayor duración en ese año
	 */
	public Carrera darCarreraMayorduracion(int anho);
	
}
