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

/**
 * Esta es la clase que modela a los pilotos
 */
public class Piloto implements Serializable 
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
	 * Este es el atributo que representa la nacionalidad del piloto
	 */
	private String nacionalidad;

	/**
	 * Este es el atributo que representa la fecha de nacimiento del piloto
	 */
	private String fechaNac;

//	/**
//	 * Este es el atributo que representa la escudería del piloto
//	 */
//	private String escuderia;
//
//	/**
//	 * Este es el atributo que representa los puntos del piloto
//	 */
//	private int puntos;
//
//	/**
//	 * Este es el atributo que representa la posicion final del piloto
//	 */
//	private int posFinal;
//
//	/**
//	 * Este es el atributo que representa la posicion del piloto
//	 */
//	private int posicion;
//
//	/**
//	 * Este es el atributo que representa el estado final del piloto
//	 */
//	private String estado;
//
//	/**
//	 * Este es el atributo que representa la Estadística del piloto
//	 */
//	private String estadistica;

	/**
	 * Este es el atributo donde se guarda el url de la imagen del piloto
	 */
	private String urlImagen;

	/**
	 * Este es el atributo que representa el id del conductor
	 */
	private String driverId;

//	/**
//	 * Este es el atributo que representa el 
//	 */
//	private String escuderiaId;
//
//	
	// -----------------------------------------------------------------
	// Metodos Constructores
	// -----------------------------------------------------------------

	/**
	 * Este es el metodo constructor de la clase
	 * @param nombre
	 * @param nacionalidad
	 * @param fechaNac
	 * @param escuderia
	 * @param puntos
	 * @param posFinal
	 * @param posicion
	 * @param estado
	 * @param estadistica
	 * @param urlImagen
	 * @param pIdDriver
	 * @paran pIdEscuderia
	 */
	public Piloto(String nombre, String nacionalidad, String fechaNac,
			  String urlImagen, String pIdDriver) 
	{
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNac = fechaNac;
//		this.escuderia = escuderia;
//		this.puntos = puntos;
//		this.posFinal = posFinal;
//		this.posicion = posicion;
//		this.estado = estado;
//		this.estadistica = estadistica;
		this.urlImagen = urlImagen;
		this.driverId = pIdDriver;
//		this.escuderiaId = pIdEscuderia;
	}




	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	//TODO
	/**
	 * Este método transforma la informacion a una cadena de carácteres separada por ";" para enviarla en el siguiente orden:
	 * nombre;nacionalidad;fechaNac;escuderia;puntos;posFinal;posicion;estado;estadistica;urlImagen
	 * @return cadena de caracteres con informacion
	 */
	public String toString()
	{
		StringBuilder s = new StringBuilder(512);
		s.append(driverId+";"+nombre+";"+nacionalidad+";"+fechaNac+";"+urlImagen);

		return s.toString();
	}


}
