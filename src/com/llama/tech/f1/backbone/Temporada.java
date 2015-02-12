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

import com.llama.tech.utils.list.IteradorListaDoblementeEnlazada;
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
	
	/**
	 * Este atributo guarda la carrera de mayor duración
	 */
	private Carrera carreraMayorduracion;

	// -----------------------------------------------------------------
	// Metodos Constructores
	// -----------------------------------------------------------------

	/**
	 * Este es el metodo constructor de la temporada
	 * @param anho -el año de la temporada
	 * pos: se crea una temporada
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

	/**
	 * Este metodo retorna la lista de carreras de la temporada
	 * @return lista de carreras
	 */
	public Lista<Carrera> getCarreras() {
		return carreras;
	}

	/**
	 * Este metodo retorna la lista de pilotos de la temporada
	 * @return lista de pilotos
	 */
	public Lista<Piloto> getPilotos() {
		return pilotos;
	}

	/**
	 * Este metodo retorna la lista de escuderias d ela temporada
	 * @return lista de temporadas
	 */
	public Lista<Escuderia> getEscuderias() {
		return escuderias;
	}

	/**
	 * Este es el método que retorna el año asociado a la temporada
	 * @return año de la temporada
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Este es el booleano que confirma si los pilotos ya han sido cargados.
	 * Permite la función de persistencia.
	 * @return true si ya fueron cargados false de lo contrario
	 */
	public boolean isPilotosCargados() {
		return pilotosCargados;
	}

	/**
	 * Este es el booleano que confirma si las carreras ya han sido cargadas.
	 * Permite la función de persistencia.
	 * @return true si ya fueron cargadas false de lo contrario
	 */
	public boolean isCarrerasCargadas() {
		return carrerasCargadas;
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
							infoP[0], infoP[5],Integer.parseInt(infoP[11]));
					
					//Piloto(String nombre, String apellido, String nacionalidad,
//					String fechaNac, String escuderia, double puntos, int posFinal,
//					String urlImagen, String driverId, String escuderiaId, int pTotalCarreras, String pInfoCarreras) 
//			

					System.out.println(pilotos.size());
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


					//					nombre; ... ; URL;total;carrera1id%t1%t2%...%tn$"vuelta:t%vuelta2:t%vueltan:tn|
					//					"carrera2id%..."%...|. 
				}
			}
		}

	}

	/**
	 * Este metodo carga las carreras de la temporada
	 * @param infoCarreras informacion carreras
	 */
	public void cargarCarreras(Lista<String> infoCarreras) {

		if (!carrerasCargadas) {
			for (int i =0; i<infoCarreras.size();i++) {
				
				System.out.println("Loading:" + infoCarreras.get(i));
				String[] infoC = infoCarreras.get(i).split(";");
				
				String nombreCirc = infoC[0];
				String circuitId = infoC[1];
				String nombreCarr = infoC[2];
				int numeroCarrera = Integer.parseInt(infoC[3]);
				String fecha = infoC[4];
				String hora = infoC[5];
				String lugar = infoC[6];
				String pais = infoC[7];
				String URL = infoC[8];
				String informacionPosicionPilotos = infoC[9];

				String[] infoPos = informacionPosicionPilotos.split("[|]");

				Lista<Piloto> pPilotos = new LlamaArrayList<Piloto>(10);

				//pos1:pilotid:firstName:lastName:points:laps:status:totalTime:#lap,time#:AvgSpeed|pos2:...

				String tiempoPrimero = infoPos[1].split("[:]")[7];
				String tiempoUltimo = "";
				for(String pil:infoPos)
				{
					System.out.println(pil);
					
					String [] infoPil = pil.split("[:]");
					
					String posicion = infoPil[0];
					String idPiloto = infoPil[1];
					String nombreP =infoPil[2];
					String apellidoP =infoPil[3];
					int puntosEnCarrera =Integer.parseInt(infoPil[4]);
					int laps =Integer.parseInt(infoPil[5]);
					String status =infoPil[6];
					String totalTime=infoPil[7];
					String bestTime=infoPil[8].split("[#]")[1];
					String avgSpeed = infoPil[9];
					
					if(!totalTime.equals("-1"))
						tiempoUltimo=totalTime;
					
					Piloto a = buscarPilotoBinario(apellidoP);
					a.setInfoCarrera(numeroCarrera, circuitId, puntosEnCarrera, posicion, laps, bestTime, avgSpeed, status);
					pPilotos.addAlFinal(a);

				}
				
				//tiempo distinto de -1
				
				//Carrera(String pNombre, int pNumeroCarrera, String pFecha, 
				//String pHora, String pCircuito, String pLugar, String pPais, 
				//int pDuracion, String pUrlImagen, String pCarreraId, Lista<Piloto> pPilotos )

				//URL;
				//pos1:pilotid:firstName:lastName:points:laps:status:totalTime:#lap,time#:AvgSpeed|pos2:...

				//TODO armar la lista de pilotos buscando por su apellido. Pasarla por parámetro.

				
				Carrera race = new Carrera(nombreCarr, numeroCarrera, fecha, hora,
						nombreCirc, lugar, pais, 0, URL, circuitId ,pPilotos);
				
				double tiempo1=timeConversionDouble(tiempoPrimero);
				double tiempo2=timeConversionDouble(tiempoUltimo);
				
				double tiempoTotal = tiempo1+tiempo2;
				
				String duracion = timeConversionString(tiempoTotal);

				if(timeConversionDouble(duracion)>timeConversionDouble(carreraMayorduracion.getDuracion()))
					carreraMayorduracion=race;
				
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

		Piloto pil = new Piloto("", apellido, "", "", "", 0, 0, "", "", "", 0);
		return pilotos.remove(pil); 
//		public Piloto(String nombre, String apellido, String nacionalidad,
//				String fechaNac, String escuderia, double puntos, int posFinal,
//				String urlImagen, String driverId, String escuderiaId, int pTotalCarreras, String pInfoCarreras) 
//		
	}

	public Lista<Carrera> buscarCarrerasDespuesDeFecha(String pfecha)
	{
		Lista<Carrera> mandar = new ListaDoblementeEnlazada<Carrera>();
		LlamaIterator<Carrera> it = carreras.iterator();
		int pos =0;
		boolean encontre = false;

		while(it.hasNext()&&!encontre)
		{
			Carrera next = it.next();
			String[] fechaBusq = pfecha.split("-");
			String[] fechaAct = next.getFecha().split("-");

			//TODO poner bien formarto. Las carreras están ordenadas por fecha? Si no, hay que hacer algoritmo de ordenamiento

			int diaBusq = Integer.parseInt(fechaBusq[2]);
			int diaAct = Integer.parseInt(fechaAct[2]);

			int mesBusq = Integer.parseInt(fechaBusq[1]);
			int mesAct = Integer.parseInt(fechaAct[1]);

			//			boolean encontre = false;
			//			int incio =0;
			//			int fin = carreras.size()-1;
			//No puedo hacer búsqueda binaria *llora* puedo soñar

			if(mesBusq==mesAct)
			{
				if(diaBusq==diaAct)
				{
					encontre = true;
				}
				else if(diaAct>diaBusq)
				{
					encontre=true;
				}
			}
			else if(mesAct>mesBusq)
			{
				encontre=true;
			}

			it = carreras.iterator(pos);

			while(it.hasNext())
			{
				mandar.addAlFinal(it.next());
			}
		}

		return mandar; //Si devuelvo lista vacía en F1 tengo que preguntar a siguiente año
	}

	public Lista<Carrera> buscarCarrerasAntesDeFecha(String pfecha)
	{
		Lista<Carrera> mandar = new ListaDoblementeEnlazada<Carrera>();
		LlamaIterator<Carrera> it = carreras.iterator();
		int pos =0;
		boolean encontre = false;

		while(it.hasNext()&&!encontre)
		{
			Carrera next = it.next();
			String[] fechaBusq = pfecha.split("-");
			String[] fechaAct = next.getFecha().split("-");

			//TODO poner bien formarto. Las carreras están ordenadas por fecha? Si no, hay que hacer algoritmo de ordenamiento

			int diaBusq = Integer.parseInt(fechaBusq[1]);
			int diaAct = Integer.parseInt(fechaAct[1]);

			int mesBusq = Integer.parseInt(fechaBusq[0]);
			int mesAct = Integer.parseInt(fechaAct[0]);

			//			boolean encontre = false;
			//			int incio =0;
			//			int fin = carreras.size()-1;
			//No puedo hacer búsqueda binaria *llora* puedo soñar

			mandar.addAlFinal(next);

			if(mesBusq>mesAct)
			{
				if(diaBusq>diaAct)
				{
					encontre = true;
				}
			}


			it = carreras.iterator(pos);

		}

		return mandar; //Si esta vacía ignoro. 
	}

	public Piloto buscarPilotoBinario(String apellido)
	{
		Piloto param = new Piloto("", apellido, "", "", "", 0, 0,"", "", "", 0);
		Piloto buscado = null;

		int inicio =0;
		int fin= pilotos.size()-1;
		boolean encontre = false;

		while(inicio<=fin&&!encontre)
		{
			int medio=(inicio+fin)/2;
			if(pilotos.get(medio).compareTo(param)==0)
			{
				encontre = true;
				buscado = pilotos.get(medio);
			}
			else if(pilotos.get(medio).compareTo(param)<0)
			{
				inicio = medio+1;
			}
			else
			{
				fin=medio-1;
			}
		}

			return buscado;

	}

	public Escuderia buscarEscuderiaBinario(String pNombre)
	{
		Escuderia param = new Escuderia("", pNombre, "", 0, 0, "");
		Escuderia buscado = null;

		int inicio =0;
		int fin= escuderias.size()-1;
		boolean encontre = false;

		while(inicio<=fin&&!encontre)
		{
			int medio=(inicio+fin)/2;
			if(escuderias.get(medio).compareTo(param)==0)
			{
				encontre = true;
			}
			else if(escuderias.get(medio).compareTo(param)<0)
			{
				inicio = medio+1;
			}
			else
			{
				fin=medio-1;
			}
		}


		return buscado;
	}

	public void eliminarPiloto(String apellido)
	{
		pilotos.remove(new Piloto("", apellido, "", "", "", 0, 0, "", "", "", 0));
		for(int i=0; i< carreras.size();i++)
		{
			carreras.get(i).eliminarPiloto(apellido);
		}
	}

	public void eliminarEscuderia(String pNombre)
	{
		escuderias.remove(new Escuderia("", pNombre, "", 0, 0, ""));
	}
	
	public int buscarPosicionPiloto(String apellido)
	{
		Piloto param = new Piloto("", apellido, "", "", "", 0, 0,"", "", "",0);
		Piloto buscado = null;

		int inicio =0;
		int fin= pilotos.size()-1;
		boolean encontre = false;
		int medio=0;

		while(inicio<=fin&&!encontre)
		{
			medio=(inicio+fin)/2;
			if(pilotos.get(medio).compareTo(param)==0)
			{
				encontre = true;
				buscado = pilotos.get(medio);
			}
			else if(pilotos.get(medio).compareTo(param)<0)
			{
				inicio = medio+1;
			}
			else
			{
				fin=medio-1;
			}
		}
		
		return medio;
	}
	
	public String[][] darPilotosCarrera(int numCarrera)
	{
		Carrera carreris=carreras.get(numCarrera-1);
		
		Lista<Piloto> lista = carreris.getPilotos();
		
		String[][] devolver = new String[lista.size()][3];
		
		for(int i = 0;i<lista.size();i++)
		{
			
				devolver[i][0] = lista.get(i).getNombre() + " " + lista.get(i).getApellido();
				devolver[i][1]=lista.get(i).darPuntosCarrera(numCarrera)+"";
				devolver[i][2]=lista.get(i).darPosicionCarrera(numCarrera);
			
		}
		
		
		return devolver;
		
		
	}
	
	
	private static double timeConversionDouble(String t)
	{
		//	2:13:23.6
		double totalTime = 0.0;
		
		if(t.charAt(0) == '+')
		{
			t = t.substring(1);
		}
		String[] units = t.split(":");
		if(units.length == 3)
		{
			double hours = Double.parseDouble(units[0])*3600;
			double minutes = Double.parseDouble(units[1])*60;
			double seconds = Double.parseDouble(units[2]);
			totalTime = hours+minutes+seconds;
		}
		else if(units.length == 2)
		{
			double minutes = Double.parseDouble(units[0])*60;
			double seconds = Double.parseDouble(units[1]);
			totalTime = minutes+seconds;
		}
		else if(units.length == 0)
		{
			double seconds = Double.parseDouble(t);
			totalTime = seconds;
		}
		
		return totalTime;
	}
	
	private static String timeConversionString(Double t)
	{
		//String format = "%d:%d:%g";
		String time = null;
		if(t >= 3600)
		{
			String format = "%d:%d:%g";
			int hours = t.intValue()/3600;
			t = t % 3600;
			int minutes = t.intValue()/60;
			t = t % 60;
			double seconds = t;
			time = String.format(format, hours, minutes, seconds);
		}
		else if(t >= 60)
		{
			String format = "%d:%g";
			int minutes = t.intValue()/60;
			t = t % 60;
			double seconds = t;
			time = String.format(format, minutes, seconds);
		}
		else
		{
			String format = "%g";
			time = String.format(format, t);
		}
		
		return time;
	}
	
	public Carrera darCarreraMayorDuracion()
	{
		return carreraMayorduracion;
	}
	


}