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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Query 
{
	private final static String ROOT = "http://ergast.com/api/f1/";
	private final static String DATA_ROOT = "./data/seasons/";
	private final static String IMG_ROOT = "./data/img/";

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

	public static String[] getTotalSeasons() throws IOException //→ Aquí me encuentro!
	{
		File dataRoot = new File("./data/seasons/");
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
			URL urlReq = new URL(ROOT+"seasons.json");
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

	public static String[] getDriversSeason(String year) throws IOException
	{
		//TODO Guardar archivo de persistencia
		String[] drivers = null;
		URL urlReq = new URL(ROOT+year+"/drivers.json"); //yupi
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
			boolean imageExists = false;
			String loc = null;
			String position = null;
			String points = null;
			String constructorId = null;
			String constructorName = null;
			JSONObject driver = driverList.getJSONObject(i);
			String driverId = driver.getString("driverId");
			
			//drivers/alonso/driverStandings.json
//			URL totalInfo = new URL(ROOT+year+"/drivers/"+driverId+"/driverStandings.json");
//			String cons = getJSONFormat(totalInfo);
//			JSONObject totalMain = new JSONObject(cons);
//			JSONObject standings = totalMain.getJSONObject("MRData");
//			JSONObject standingsTable = standings.getJSONObject("StandingsTable");
//			JSONArray standingsLists = standingsTable.getJSONArray("StandingsLists");
//			try
//			{
//				JSONObject moreStandingsInfo = standingsLists.getJSONObject(0);			
//				JSONArray driverStandings = moreStandingsInfo.getJSONArray("DriverStandings");
//				JSONObject pointsAndInfo = driverStandings.getJSONObject(0);
//				
//				
//				position = pointsAndInfo.getString("position");
//				points = pointsAndInfo.getString("points");
//				
//				JSONArray constructorInfo = pointsAndInfo.getJSONArray("Constructors");
//				JSONObject constructor = constructorInfo.getJSONObject(0);
//				constructorId = constructor.getString("constructorId");
//				constructorName = constructor.getString("name");
//			}
//			catch(JSONException j)
//			{
//				
//			}
			
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
				loc = ImageContent.getImageContent(url, "./data/img/drivers/"+driverId);
			}
			
			sb.append(driverId);
			sb.append(";");
			sb.append(driver.getString("givenName"));
			sb.append(" ");
			sb.append(driver.getString("familyName"));
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
			sb.append(loc);
			sb.append(";");
			drivers[i] = sb.toString();
			sb.setLength(0);
			System.out.println(drivers[i]);
			
		}
		
		
		return drivers;
		
	}
	
	public static void main(String[] args) 
	{
		try {
			String[] pilots = getDriversSeason("1963");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
