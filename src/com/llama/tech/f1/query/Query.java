/*
 * Query.java
 * This file is part of F1ChampionshipQueries
 *
 * Copyright (C) 2015 - LlamaTech Team 
 * 
 * JSON Copyright (c) 2002 JSON.org
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

package com.llama.tech.f1.query;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.llama.tech.f1.backbone.IF1;
import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;

public class Query 
{
	private final static String ROOT = "http://ergast.com/api/f1/";
	private final static String DATA_ROOT = "./data/seasons/";
	private final static String IMG_ROOT = "./data/img/";
	private final static String DIR_ARCHIVO = "./data/persistence/";
	public final static File ARCHIVO = new File(DIR_ARCHIVO+"info.f1");

	/**
	 * Este método retorna el formato JSON del url que se le pasa por parametro.
	 * @param urlReq url del que se desea el formato JSON
	 * @return formato JSON
	 * @throws IOException si hay un error consultando la url
	 */
	private static String getJSONFormat(URL urlReq) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		try(BufferedReader in = new BufferedReader(new InputStreamReader(urlReq.openStream())))
		{
			String inputLine;
			while((inputLine = in.readLine()) != null)
			{
				sb.append(inputLine);
			}
		}
		return sb.toString();
	}

	/**
	 * Este método retorna el total de temporadas disponibles en la página de consultas
	 * @return una lista con todos los años disponibles
	 * @throws IOException si hay un problema haciendo la consulta
	 */
	public static String[] getTotalSeasons() throws IOException 
	{
		File dataRoot = new File(DATA_ROOT);
		String[] seasonList = null;
		boolean exists = false;
		int len = -1;

		for(File f: dataRoot.listFiles())
		{
			if(!f.isDirectory())
			{
				if(f.getName().equals("season_list.f1"))
				{
					try(BufferedReader br = new BufferedReader(new FileReader(DATA_ROOT+"season_list.f1")))
					{
						String inputLine;
						boolean finished = false;
						int i = 0;

						while((inputLine = br.readLine()) != null && !finished)
						{
							if(len == -1 && i == 0)
							{
								len = Integer.parseInt(inputLine);
								seasonList = new String[len];
							}
							else
							{
								seasonList[i] = inputLine;
								i++;
							}

							if(i > len)
							{
								finished = true;
							}
						}

						exists = true;
						break; // → Excelente idea!
					}
				}
			}
		}
		if(!exists)
		{
			URL urlReq = new URL(ROOT+"seasons.json?limit=200");
			String response = getJSONFormat(urlReq);
			JSONObject mainResults = new JSONObject(response);

			JSONObject mainList = mainResults.getJSONObject("MRData");
			int limit = mainList.getInt("limit");
			len = mainList.getInt("total");

			seasonList = new String[len];

			if(limit < len)
			{
				urlReq = new URL(ROOT+"seasons.json?limit="+len);
				response = getJSONFormat(urlReq);
				mainResults = new JSONObject(response);
				mainList = mainResults.getJSONObject("MRData");
			}

			JSONObject seasonDict = mainList.getJSONObject("SeasonTable");
			JSONArray seasons = seasonDict.getJSONArray("Seasons");

			FileOutputStream fos = new FileOutputStream(new File(DATA_ROOT+"season_list.f1"));
			PrintWriter pw = new PrintWriter(fos);

			pw.println(len);

			for(int i = 0; i <  seasons.length(); i++)
			{
				JSONObject current = seasons.getJSONObject(i);
				String year = current.getString("season");
				seasonList[i] = year;
				pw.println(year);
				pw.flush();

			}
			pw.close();
		}

		return seasonList;


	}

//	nombre; ... ; URL;"carrera1id%t1%t2%...%tn"$"vuelta:t%vuelta2:t%vueltan:tn" |
//	"carrera2id%..."%...|. 
	
	public static int getCircuitsPerSeason(String year) throws Exception
	{
		URL urlReq = new URL(ROOT+year+".json?limit=1");
		String content = getJSONFormat(urlReq);
		JSONObject mainResults = new JSONObject(content);
		JSONObject circuitsLength = mainResults.getJSONObject("MRData");
		int len = circuitsLength.getInt("total");
		
		return len;
		
	}
	
	/**
	 * 
	 */
	
	public static String[] getDriversSeason(String year) throws Exception
	{
		int numCircuits = getCircuitsPerSeason(year);
		boolean checkTime = false;
		if(Integer.parseInt(year) >= 2011)
		{
			checkTime = false;
		}
		
		String[] drivers = null;
		URL urlReq = new URL(ROOT+year+"/drivers.json?limit=200"); //yupi
		//Ahora a obtener el archivo JSON!
		String content = getJSONFormat(urlReq);
		JSONObject mainResults = new JSONObject(content);

		JSONObject mainList = mainResults.getJSONObject("MRData");
		int limit = mainList.getInt("limit");
		int len = mainList.getInt("total");
		
		drivers = new String[len];

		if(limit < len)
		{
			urlReq = new URL(ROOT+year+"/drivers.json?limit="+limit);
			content = getJSONFormat(urlReq);
			mainResults = new JSONObject(content);
			mainList = mainResults.getJSONObject("MRData");
		}
		//Entendido todo hasta el momento?

		//si señor
		//     * driverId+";"+nombre+";"+nacionalidad+";"+fechaNac+";"+escuderiaId+";"+escuderia+";"+puntos+";"+posFinal+";"+posicion+";"+estado+";"+estadistica+";"+urlImagen → !!!!!!

		//{"driverId":"alonso","permanentNumber":"14","code":"ALO","url":"http:\/\/en.wikipedia.org\/wiki\/Fernando_Alonso","givenName":"Fernando","familyName":"Alonso","dateOfBirth":"1981-07-29","nationality":"Spanish"}

		JSONObject driverTable = mainList.getJSONObject("DriverTable");
		JSONArray driverList = driverTable.getJSONArray("Drivers");
		StringBuilder sb = new StringBuilder();
		
		File dir = new File("./data/img/drivers/");
		
		for(int i = 0; i < driverList.length(); i++)
		{
			int numRaces = 0;
			boolean imageExists = false;
			String loc = null;
			String position = null;
			String points = null;
			String constructorId = null;
			String constructorName = null;
			JSONObject driver = driverList.getJSONObject(i);
			String driverId = driver.getString("driverId");
			
			//drivers/alonso/driverStandings.json
			URL totalInfo = new URL(ROOT+year+"/drivers/"+driverId+"/driverStandings.json?limit=200");
			String cons = getJSONFormat(totalInfo);
			JSONObject totalMain = new JSONObject(cons);
			JSONObject standings = totalMain.getJSONObject("MRData");
			JSONObject standingsTable = standings.getJSONObject("StandingsTable");
			JSONArray standingsLists = standingsTable.getJSONArray("StandingsLists");
			try
			{
				JSONObject moreStandingsInfo = standingsLists.getJSONObject(0);			
				JSONArray driverStandings = moreStandingsInfo.getJSONArray("DriverStandings");
				JSONObject pointsAndInfo = driverStandings.getJSONObject(0);
				
				
				position = pointsAndInfo.getString("position");
				points = pointsAndInfo.getString("points");
				
				JSONArray constructorInfo = pointsAndInfo.getJSONArray("Constructors");
				JSONObject constructor = constructorInfo.getJSONObject(0);
				constructorId = constructor.getString("constructorId");
				constructorName = constructor.getString("name");
			}
			catch(JSONException j) 
			{
				
			}
			
			String url = driver.getString("url");
			
			
			for(File f: dir.listFiles())
			{
				if(!f.isDirectory())
				{
					if(f.getName().contains(driverId))
					{
						loc = "./data/img/drivers/"+f.getName();
						imageExists = true;
						break;
					}
				}
			}
			
			if(!imageExists)
			{
				loc = ImageContent.getDriverConstructorImageContent(url, "./data/img/drivers/"+driverId);
			}
			
			
			sb.append(driverId);
			sb.append(";");
			sb.append(convertStringCanonicalForm(driver.getString("givenName")));
			sb.append(";");
			sb.append(convertStringCanonicalForm(driver.getString("familyName")));
			sb.append(";");
			sb.append(driver.getString("nationality"));
			sb.append(";");
			sb.append(driver.getString("dateOfBirth"));
			sb.append(";");
			sb.append(constructorId);
			sb.append(";");
			sb.append(constructorName);
			sb.append(";");
			sb.append(points);
			sb.append(";");
			sb.append(position);
			sb.append(";");
			if(loc == null)
			{
				loc = "./data/img/drivers/default.png";
			}
			sb.append(loc);
			sb.append(";");
			
			sb.append(-1+";");
			sb.append(numCircuits);
			drivers[i] = sb.toString();
			sb.setLength(0);
			System.out.println(drivers[i]);
			
		}
		
		
		return drivers;
		
	}

	
	public static Lista<String> getCircuitsSeason(String year) throws Exception
	{
		//http://ergast.com/api/f1/2008/results/
		Lista<String> circuits = new LlamaArrayList<String>(40);
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		URL req = new URL(ROOT+year+"/results.json?limit=500");
		String contents = getJSONFormat(req);
		JSONObject mainInfo = new JSONObject(contents);
		JSONObject resultsT = mainInfo.getJSONObject("MRData");
		JSONObject raceTable = resultsT.getJSONObject("RaceTable");
		JSONArray races = raceTable.getJSONArray("Races");
		
		File dir = new File(IMG_ROOT+"circuits/");
		
		//First list:
		//{"season":"2008","round":"1","url":"http:\/\/en.wikipedia.org\/wiki\/2008_Australian_Grand_Prix","raceName":"Australian Grand Prix","Circuit":{"circuitId":"albert_park","url":"http://en.wikipedia.org/wiki/Melbourne_Grand_Prix_Circuit","circuitName":"Albert Park Grand Pri
		//"circuitName":"Albert Park Grand Prix Circuit","Location":{"lat":"-37.8497","long":"144.968","locality":"Melbourne","country":"Australia"}},"date":"2008-03-16","time":"04:30:00Z","Results":
		for(int i = 0; i < races.length(); i++)
		{
			JSONObject totalRaceInfo = races.getJSONObject(i);
			String round = totalRaceInfo.getString("round");
			String raceName = totalRaceInfo.getString("raceName");
			String url = totalRaceInfo.getString("url");
			JSONObject circuit = totalRaceInfo.getJSONObject("Circuit");
			String circuitId = circuit.getString("circuitId");
			String circuitName = circuit.getString("circuitName");
			JSONObject location = circuit.getJSONObject("Location");
			String locality = location.getString("locality");
			String country = location.getString("country");
			String date = totalRaceInfo.getString("date");
			String time = "No Disponible";
			try
			{
				time = totalRaceInfo.getString("time");
			}
			catch(JSONException jExp)
			{
				
			}
			String loc = null;
			boolean imgExists = false;
			
			for(File f: dir.listFiles())
			{
				if(!f.isDirectory())
				{
					if(f.getName().contains(circuitId))
					{
						loc = IMG_ROOT+"circuits/"+f.getName();
						imgExists = true;
						break;
					}
				}
			}
			
			if(!imgExists)
			{
				loc = ImageContent.getDriverConstructorImageContent(url, "./data/img/circuits/"+circuitId);
			}
			
			sb.append(circuitName);
			sb.append(";");
			sb.append(circuitId);
			sb.append(";");
			sb.append(raceName);
			sb.append(";");
			sb.append(round);
			sb.append(";");
			sb.append(date);
			sb.append(";");
			sb.append(time);
			sb.append(";");
			sb.append(locality);
			sb.append(";");
			sb.append(country);
			sb.append(";");
			sb.append(loc);
			sb.append(";");
			
			/**
			 * {"number":"22","position":"1","positionText":"1","points":"10","Driver":{"driverId":"hamilton","permanentNumber":"44","code":"HAM","url":"http:\/\/en.wikipedia.org\/wiki\/Lewis_Hamilton","givenName":"Lewis","familyName":"Hamilton","dateOfBirth":"1985-01-07","nationality":"British"},"Constructor":{"constructorId":"mclaren","url":"http:\/\/en.wikipedia.org\/wiki\/McLaren","name":"McLaren","nationality":"British"},"grid":"1","laps":"58","status":"Finished","Time":{"millis":"5690616","time":"1:34:50.616"},"FastestLap":{"rank":"2","lap":"39","Time":{"time":"1:27.452"},"AverageSpeed":{"units":"kph","speed":"218.300"}}}
			 */
			
			JSONArray results = totalRaceInfo.getJSONArray("Results");
			for(int j = 0; j < results.length(); j++)
			{
				//pos1:pilotid:firstName:lastName:points:laps:status:totalTime:#lap,time#:AvgSpeed
				JSONObject driverA = results.getJSONObject(j);
				System.out.println(driverA.toString());
				String pos = driverA.getString("position");
				String points = driverA.getString("points");
				JSONObject driver = driverA.getJSONObject("Driver");
				String driverId = driver.getString("driverId");
				String givenName = driver.getString("givenName");
				String lastName = driver.getString("familyName");
				String laps = driverA.getString("laps");
				String status = driverA.getString("status");
				String fastLap = "-1";
				String fastTime = "-1";
				String avgSpeed = "-1";
				time = "-1";
				try
				{
					JSONObject timeInfo = driverA.getJSONObject("Time");
					time = timeInfo.getString("time");
				}
				catch(JSONException r)
				{
				}
				try
				{
					JSONObject fastestLap = driverA.getJSONObject("FastestLap");
					fastLap = fastestLap.getString("lap");
					fastTime = fastestLap.getJSONObject("Time").getString("time");
					JSONObject averageSpeed = fastestLap.getJSONObject("AverageSpeed");
					avgSpeed = averageSpeed.getString("speed")+averageSpeed.getString("units");    	
				}
				catch(JSONException t)
				{
					
				}
				
				sb2.append(pos);
				sb2.append(":");
				sb2.append(driverId);
				sb2.append(":");
				sb2.append(convertStringCanonicalForm(givenName));
				sb2.append(":");
				sb2.append(convertStringCanonicalForm(lastName));
				sb2.append(":");
				sb2.append(points);
				sb2.append(":");
				sb2.append(laps);
				sb2.append(":");
				sb2.append(status);
				sb2.append(":");
				sb2.append(time);
				sb2.append(":");
				sb2.append(fastLap);
				sb2.append(",");
				sb2.append(fastTime);
				sb2.append(":");
				sb2.append(avgSpeed);
				if(j != results.length()-1)
					sb2.append("|");
				
				sb.append(sb2.toString());
				sb2.setLength(0);
				
			}
			
			System.out.println(sb.toString());
			circuits.addAlFinal(sb.toString());
			sb.setLength(0);
			
		}
		
		return circuits;
		
	}
	
	
	public static String[] getConstructorsSeason(String year) throws Exception
	{
		String[] constructors;
		URL urlReq;
		boolean discardPos = false;
		if(Integer.parseInt(year) < 1958)
		{
			urlReq = new URL(ROOT+year+"/constructors.json?limit=200");
			discardPos = true;
		}
		else
		{
			urlReq = new URL(ROOT+year+"/constructorStandings.json?limit=200");
		}
		
		String content = getJSONFormat(urlReq);
		JSONObject mainInfo = new JSONObject(content);
		JSONObject constructorsInfo = mainInfo.getJSONObject("MRData");
		
		int len = constructorsInfo.getInt("total");
		constructors = new String[len];
		
		StringBuilder sb = new StringBuilder();
		File dir = new File(IMG_ROOT+"constructors/");
		
		if(discardPos)
		{
			JSONObject constructorTable = constructorsInfo.getJSONObject("ConstructorTable");
			JSONArray constructrs = constructorTable.getJSONArray("Constructors");
			for(int i = 0; i < len; i++)
			{
				//{"constructorId":"benetton","url":"http:\/\/en.wikipedia.org\/wiki\/Benetton_Formula","name":"Benetton","nationality":"Italian"}
				JSONObject constructor = constructrs.getJSONObject(i);
				String constructorId = constructor.getString("constructorId");
				String constructorName = constructor.getString("name");
				String constructorNationality = constructor.getString("nationality");
				String url = constructor.getString("url");
				String points = null;
				String pos = null;
				
				String loc = null;
				boolean imgExists = false;
				
				for(File f: dir.listFiles())
				{
					if(!f.isDirectory())
					{
						if(f.getName().contains(constructorId))
						{
							loc = IMG_ROOT+"constructors/"+f.getName();
							imgExists = true;
							break;
						}
					}
				}
				if(!imgExists)
					loc = ImageContent.getDriverConstructorImageContent(url, "./data/img/constructors/"+constructorId);
				
				if(constructorName.contains("&amp;"))
				{
					constructorName.replaceAll("&amp;", "&");
				}
				
				sb.append(constructorId);
				sb.append(";");
				sb.append(convertStringCanonicalForm(constructorName));
				sb.append(";");
				sb.append(constructorNationality);
				sb.append(";");
				sb.append(pos);
				sb.append(";");
				sb.append(points);
				sb.append(";");
				
				if(loc == null)
					loc = IMG_ROOT+"constructors/default.png";
				
				sb.append(loc);
				constructors[i] = sb.toString();
				sb.setLength(0);
				System.out.println(constructors[i]);
			}
			
		}
		else
		{
			JSONObject constructorTable = constructorsInfo.getJSONObject("StandingsTable");
			JSONArray standingsLists = constructorTable.getJSONArray("StandingsLists");
			JSONObject standingsList = standingsLists.getJSONObject(0);
			JSONArray constructorStandings = standingsList.getJSONArray("ConstructorStandings");
			//{"position":"1","positionText":"1","points":"701","wins":"16","Constructor":{"constructorId":"mercedes","url":"http://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One","name":"Mercedes","nationality":"German"}}
			for(int i = 0; i < len; i++)
			{
				JSONObject constructorInfo = constructorStandings.getJSONObject(i);
				int pos = constructorInfo.getInt("position");
				String points = constructorInfo.getString("points");
				JSONObject constructor = constructorInfo.getJSONObject("Constructor");
				String constructorId = constructor.getString("constructorId");
				String constructorName = constructor.getString("name");
				String constructorNationality = constructor.getString("nationality");
				String url = constructor.getString("url");
				
				String loc = null;
				boolean imgExists = false;
				
				for(File f: dir.listFiles())
				{
					if(!f.isDirectory())
					{
						if(f.getName().contains(constructorId))
						{
							loc = IMG_ROOT+"constructors/"+f.getName();
							imgExists = true;
							break;
						}
					}
				}
				if(!imgExists)
					loc = ImageContent.getDriverConstructorImageContent(url, "./data/img/constructors/"+constructorId);
				
				if(constructorName.contains("&amp;"))
				{
					constructorName = constructorName.replaceAll("&amp;", "&");
				}
				
				sb.append(constructorId);
				sb.append(";");
				sb.append(convertStringCanonicalForm(constructorName));
				sb.append(";");
				sb.append(constructorNationality);
				sb.append(";");
				sb.append(pos);
				sb.append(";");
				sb.append(points);
				sb.append(";");
				sb.append(loc);
				constructors[i] = sb.toString();
				sb.setLength(0);
				
				
			}
		}
		
		return constructors;
		
		
	}
		
	public static void guardar(IF1 o)
	{
		//Cuidado, esto no es una clase con atributos! Te refieres al archivo? Jajajaja no, query necesita un objeto por
		//parámetro para guardar → Got ya? jajaja si si te entiendo. Esto lo llamamos desde la interfaz, cierto?
		//Sí, recibe 
//		un objeto de tipo
//		Podemos hacer una constante para la ruta del archivo? Sí!
		try{
			FileOutputStream fos = new FileOutputStream(ARCHIVO);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			fos.close();
		}
		catch(Exception e){
			
		}
	}
	
	public static IF1 cargar()
	{
		try{ 
			if(ARCHIVO.exists())
			{
				FileInputStream fis = new FileInputStream(ARCHIVO);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object f1 = ois.readObject();
				ois.close();
				fis.close();
				return (IF1) f1;
			}
		}
	    catch(Exception ex)
	    {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private static String convertStringCanonicalForm(String input)
	{
		String normalized = java.text.Normalizer.normalize(input, java.text.Normalizer.Form.NFD);
		String accentsgone = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		return accentsgone;
	}
	
	
	


}
