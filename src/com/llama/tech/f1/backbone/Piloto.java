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
	 * Este es el atributo que representa la posicion del piloto
	 */
	private int posicion;

	/**
	 * Este es el atributo que representa el estado final del piloto
	 */
	private String estado;

	/**
	 * Este es el atributo que representa la Estadística del piloto
	 */
	private String estadistica;

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


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getNacionalidad() {
		return nacionalidad;
	}




	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}




	public String getFechaNac() {
		return fechaNac;
	}




	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}




	public String getEscuderia() {
		return escuderia;
	}




	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}




	public double getPuntos() {
		return puntos;
	}




	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}




	public int getPosicion() {
		return posicion;
	}




	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}




	public String getUrlImagen() {
		return urlImagen;
	}




	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}




	public String getDriverId() {
		return driverId;
	}




	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}




	public String getEscuderiaId() {
		return escuderiaId;
	}




	public void setEscuderiaId(String escuderiaId) {
		this.escuderiaId = escuderiaId;
	}




	public int getPosFinal() {
		return posFinal;
	}




	public void setPosFinal(int posFinal) {
		this.posFinal = posFinal;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}




	public String getEstadistica() {
		return estadistica;
	}




	public void setEstadistica(String estadistica) {
		this.estadistica = estadistica;
	}    	


	/**
	 * Este método transforma la informacion a una cadena de carácteres separada por ";" para enviarla en el siguiente orden:
	 * nombre;nacionalidad;fechaNac;escuderia;puntos;posFinal;posicion;estado;estadistica;urlImagen
	 * @return cadena de caracteres con informacion
	 */
	@Override 
	public String toString()
	{
		StringBuilder s = new StringBuilder(512);
		s.append(driverId+";"+nombre+";"+apellido+";"+nacionalidad+";"+fechaNac+";"+escuderiaId+";"+escuderia+";"+puntos+";"+posicion+";"+urlImagen);

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

		//		return apellido.compareTo(o.getApellido());
	}

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


	public double darPuntosCarrera(int numCarrera)
	{
		return infoCarreras.get(numCarrera-1).getPoints();
	}

	public String darPosicionCarrera(int numCarrera)
	{
		return infoCarreras.get(numCarrera-1).getPosicion();
	}



}
