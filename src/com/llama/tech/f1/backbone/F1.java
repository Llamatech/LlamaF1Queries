package com.llama.tech.f1.backbone;

import java.io.Serializable;

import com.llama.tech.f1.utils.Lista;

public class F1 implements IF1, Serializable
{
	/**
	 *  Constante de Serialización. 
	 */
	private static final long serialVersionUID = 1L;
	
	private Lista<Temporada> temporadas;

	@Override
	public Temporada getSeasonInfo(String year) 
	{
		return null;
		
	}

	@Override
	public String[] getSeasonList() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrera getCircuitInfo(String name, String year) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piloto getPilotInfo(String name, String year) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Escuderia getConstructorInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrera[] getHistoricalSeasonInfo(String initialDate, String finalDate) {
		// TODO Auto-generated method stub
		return null;
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

}
