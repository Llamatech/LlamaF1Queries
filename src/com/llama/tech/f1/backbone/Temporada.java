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

	private Carrera carreraActual;

	private Piloto pilotoActual;

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

	/**
	 * Este es el booleano que confirma si las escuderias ya han sido cargadas.
	 * Permite la función de persistencia.
	 * @return true si ya fueron cargadas false de lo contrario
	 */
	public boolean isEscuderiasCargadas() {
		return escuderiasCargadas;
	}

	/**
	 * Este metodo carga los pilotos de la temporada
	 * pos: la lista de pilotos se encuentra actualizada
	 * @param infoPiloto- de los pilotos
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

					Escuderia buscada = buscarEscuderia(infoP[6]);
					if(buscada!=null)
					{
						buscada.setPiloto(infoP[1]+" "+infoP[2]+", "+infoP[3]);
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
		pilotoActual=pilotos.get(0);

	}

	/**
	 * pre: la lista de pilotos ya ha sido cargada
	 * Este metodo carga las carreras de la temporada
	 * pos: la lista de carreras se encuentra actualizada
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
					double puntosEnCarrera =Double.parseDouble(infoPil[4]);
					int laps =Integer.parseInt(infoPil[5]);
					String status =infoPil[6];
					String totalTime=infoPil[7];
					String bestTime=infoPil[8];
					if(bestTime.equals("-1,-1"))
						bestTime="No disponible";
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

				String duracion = "";
				if(tiempoPrimero.equals("-1")||tiempoUltimo.equals("-1"))
				{
					duracion = "No disponible";
				}
				else
				{
					System.out.println("tiempos1: "+tiempoPrimero+" "+tiempoUltimo);
					double tiempo1 = Double.parseDouble(tiempoPrimero.replace("+", "0"));
					double tiempo2 = Double.parseDouble(tiempoUltimo.replace("+", "0"));
//					double tiempo1=timeConversionDouble(tiempoPrimero);
//					double tiempo2=timeConversionDouble(tiempoUltimo);
//
					System.out.println("tiempos2: "+tiempo1+" "+tiempo2);
					double tiempoTotal = tiempo1+tiempo2;
					System.out.println("tiempos:3 "+tiempoTotal);
					duracion = tiempoTotal+"";
					System.out.println("duracion: "+duracion);
				}

				System.out.println(URL);

				Carrera race = new Carrera(nombreCarr, numeroCarrera, fecha, hora,
						nombreCirc, lugar, pais, duracion, URL, circuitId ,pPilotos);

				if(!duracion.equals("No disponible"))
				{
					if(carreraMayorduracion!=null){
						if(timeConversionDouble(duracion)>timeConversionDouble(carreraMayorduracion.getDuracion()))
							carreraMayorduracion=race;
					}
					else
						carreraMayorduracion=race;
				}

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
		carreraActual=carreras.get(0);
	}

	/**
	 * Este metodo carga las escudeias de la temporada
	 * pos: la lista de escuderias esta actualizada
	 * @param infoEscuderias-informacion escuderias
	 */
	public void cargarEscuderias(String[] infoEscuderias) {
		if (!escuderiasCargadas) {
			for (String info : infoEscuderias) {
				System.out.println("Loading: " + info);
				String[] infoE = info.split(";");
				int pos = -1;
				int points = -1;
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
		{
			carreraActual= itCarrera.next();
			return carreraActual;
		}
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
		{
			carreraActual=itCarrera.previous();
			return carreraActual;
		}
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
		{
			pilotoActual= itPiloto.next();
			return pilotoActual;
		}
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
		{
			pilotoActual = itPiloto.previous();
			return pilotoActual;
		}
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
	 * Busca la escuderia recibida por parametro en la lista de escuderias
	 * @param nombre el nombre de la escuderia a buscar
	 * @return escuderia buscada o null si no existe
	 */
	public Escuderia buscarEscuderia(String nombre)
	{
		Escuderia escu = null;

		LlamaIterator<Escuderia> it =escuderias.iterator();

		while(it.hasNext()&&escu==null)
		{
			Escuderia actual = it.next();
			if(nombre.equals(actual.getNombre()))
				escu=actual;
		}
		return escu;
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

	/**
	 * Este método crea una lista con todas las carreras después de la fecha dada por parámetro
	 * @param pfecha - fecha después de la cual se quieren las carreras
	 * @return lista con las carreras después de la fecha que entra por parámetro
	 */
	public Lista<Carrera> buscarCarrerasDespuesDeFecha(String pfecha)
	{
		Lista<Carrera> mandar = new ListaDoblementeEnlazada<Carrera>();
		LlamaIterator<Carrera> it = carreras.iterator();
		int pos =0;
		boolean encontre = false;

		while(it.hasNext()&&!encontre)
		{
			Carrera next = it.next();
			String[] fechaBusq = pfecha.split("[-]");
			String[] fechaAct = next.getFecha().split("[-]");

			//TODO poner bien formarto. Las carreras están ordenadas por fecha? Si no, hay que hacer algoritmo de ordenamiento

			int diaBusq = Integer.parseInt(fechaBusq[0]);
			int diaAct = Integer.parseInt(fechaAct[0]);

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

	/**
	 * Este método crea una lista con todas las carreras antes de la fecha dada por parámetro
	 * @param pfecha - fecha antes de la cual se quieren las carreras
	 * @return lista con las carreras antes de la fecha que entra por parámetro
	 */
	public Lista<Carrera> buscarCarrerasAntesDeFecha(String pfecha)
	{
		Lista<Carrera> mandar = new ListaDoblementeEnlazada<Carrera>();
		LlamaIterator<Carrera> it = carreras.iterator();
		int pos =0;
		boolean encontre = false;

		while(it.hasNext()&&!encontre)
		{
			Carrera next = it.next();
			String[] fechaBusq = pfecha.split("[-]");
			String[] fechaAct = next.getFecha().split("[-]");

			//TODO poner bien formarto. Las carreras están ordenadas por fecha? Si no, hay que hacer algoritmo de ordenamiento

			int diaBusq=Integer.parseInt(fechaBusq[0]);
			int diaAct = Integer.parseInt(fechaAct[0]);

			int mesBusq = Integer.parseInt(fechaBusq[1]);
			int mesAct = Integer.parseInt(fechaAct[1]);

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

	/**
	 * Éste método busca un piloto con el método de búsqueda binaria
	 * @param apellido - apellido del piloto que se busca
	 * @return Piloto buscado, null si no existe
	 */
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

	/**
	 * Éste método busca una escuderia con el método de búsqueda binaria
	 * @param pNombre - nombre de la escuderia que se busca
	 * @return Escuderia buscada, null si no existe
	 */
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
				buscado=escuderias.get(medio);
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

	/**
	 * Este método elimina un piloto de la temporada, y de las carreras que lo contengan.
	 * pos: El piloto ya no existe en temporada ni en ninguna de sus carreras
	 * @param apellido - apellido del piloto a eliminar
	 */
	public Piloto eliminarPiloto(String apellido)
	{
		Piloto remove = null;
		remove= pilotos.remove(new Piloto("", apellido, "", "", "", 0, 0, "", "", "", 0));
		for(int i=0; i< carreras.size();i++)
		{
			Piloto ush = carreras.get(i).eliminarPiloto(apellido);
			if(ush!=null)
				remove=ush;

		}
		return remove;
	}

	/**
	 * Este método elimina una carrera de la escudería
	 * pos: la carrera no existe en ele sistema
	 * @param pNombre nombre de la carrera a eliminar
	 */
	public Carrera eliminarCarrera(String nombre)
	{
		Lista<Piloto> lista = new LlamaArrayList<Piloto>(1);
		return carreras.remove(new Carrera(nombre, 0, "", "", "", "", "", "", "", "", lista));
	}


	/**
	 * Da una matriz con la información de los pilotos en una carrera dada por paramtero
	 * @param numCarrera numero de carrera 
	 * @return matriz con la información de los pilotos
	 */
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

	/**
	 * pre: El String tiene el formato adecuado
	 * Método que Convierte un String a segundos para poder utilizarlo como número
	 * @param t - String a convertir
	 * @return segundos del tiempo representado en el String
	 */
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

	/**
	 * pre: El tiempo que ingresa por parámetro es positivo.
	 * Método que convierte segundos a un formato hh:mm:ss tipo String
	 * @param t - número de segundos que se quieren representar en el formato
	 * @return String con el formato convertido
	 */
	private static String timeConversionString(Double t)
	{
		//String format = "%d:%d:%g";
		String time = null;
		if (t >= 3600) 
		{
			String format = "%d:%d:%g";
			int hours = t.intValue() / 3600;
			t = t % 3600;
			int minutes = t.intValue() / 60;
			t = t % 60;
			double seconds = t;
			time = String.format(format, hours, minutes, seconds);
		} 
		else if (t >= 60) 
		{
			String format = "%d:%g";
			int minutes = t.intValue() / 60;
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

	/**
	 * Este método devuelve la carrera con mayor duración
	 * @return carrera con mayor duración
	 */
	public Carrera darCarreraMayorDuracion()
	{
		return carreraMayorduracion;
	}

	/**
	 * Este método devuelve la carrera actual
	 * @return carrera actual
	 */
	public Carrera darCarreraActual()
	{
		return carreraActual;
	}

	/**
	 * Este metodo retorna el piloto actual
	 * @return piloto actual
	 */
	public Piloto darPilotoActual()
	{
		return pilotoActual;
	}
	
	public void remodelarIteradorPiloto(){
		
		itPiloto=pilotos.iterator(pilotos.indexOf(pilotoActual));
		
	}


}